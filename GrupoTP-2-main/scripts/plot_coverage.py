import lxml.etree as ET
import matplotlib.pyplot as plt
import numpy as np
import os
from bs4 import BeautifulSoup

# Diretórios
script_dir = os.path.dirname(os.path.abspath(__file__))
project_root = os.path.abspath(os.path.join(script_dir, ".."))
JACOCO_REPORT = os.path.join(project_root, "target", "site", "jacoco", "jacoco.xml")
PITEST_REPORT_DIR = os.path.join(project_root, "target", "pit-reports")
PLOT_DIR = os.path.join(project_root, "plots")
os.makedirs(PLOT_DIR, exist_ok=True)

def parse_jacoco_report():
    print(f"Tentando abrir o relatório JaCoCo em: {JACOCO_REPORT}")
    try:
        tree = ET.parse(JACOCO_REPORT)
        root = tree.getroot()

        # Dados para os gráficos de barras
        package_coverage = {}
        for package in root.findall(".//package"):
            package_name = package.get("name").replace("/", ".")  # Converte barras para pontos
            counters = package.findall("counter")
            for counter in counters:
                if counter.get("type") == "LINE":
                    missed = int(counter.get("missed"))
                    covered = int(counter.get("covered"))
                    total = missed + covered
                    coverage = (covered / total * 100) if total > 0 else 0
                    package_coverage[package_name] = {
                        "coverage": coverage,
                        "covered": covered,
                        "missed": missed,
                        "total": total
                    }
                    break

        # Dados para o gráfico de pizza (cobertura geral de linhas)
        total_lines_covered = 0
        total_lines_missed = 0
        for counter in root.findall(".//counter"):
            if counter.get("type") == "LINE":
                total_lines_covered += int(counter.get("covered"))
                total_lines_missed += int(counter.get("missed"))

        return package_coverage, total_lines_covered, total_lines_missed
    except FileNotFoundError:
        print(f"Erro: O arquivo {JACOCO_REPORT} não foi encontrado. Execute 'mvn clean verify'.")
        return {}, 0, 0
    except Exception as e:
        print(f"Erro ao parsear JaCoCo: {e}")
        return {}, 0, 0

def parse_pitest_report():
    print(f"Procurando relatórios PITest em: {PITEST_REPORT_DIR}")
    if not os.path.exists(PITEST_REPORT_DIR):
        print(f"Erro: Diretório {PITEST_REPORT_DIR} não encontrado. Execute 'mvn pitest:mutationCoverage'.")
        return {}

    # Verificar se existe index.html diretamente no diretório raiz
    root_index = os.path.join(PITEST_REPORT_DIR, "index.html")
    if os.path.exists(root_index):
        print(f"Tentando abrir o relatório PITest em: {root_index}")
        PITEST_REPORT = root_index
    else:
        # Caso contrário, procurar o subdiretório mais recente
        subdirs = [d for d in os.listdir(PITEST_REPORT_DIR) if os.path.isdir(os.path.join(PITEST_REPORT_DIR, d))]
        if not subdirs:
            print(f"Erro: Nenhum subdiretório encontrado em {PITEST_REPORT_DIR}.")
            return {}
        latest_dir = max(subdirs, key=lambda d: os.path.getmtime(os.path.join(PITEST_REPORT_DIR, d)))
        PITEST_REPORT = os.path.join(PITEST_REPORT_DIR, latest_dir, "index.html")
        print(f"Tentando abrir o relatório PITest em: {PITEST_REPORT}")

    try:
        with open(PITEST_REPORT, "r", encoding="utf-8") as file:
            soup = BeautifulSoup(file, "html.parser")
            mutation_data = {}
            # Encontrar todas as tabelas no relatório do PITest
            tables = soup.find_all("table")
            if not tables:
                print("Erro: Nenhuma tabela encontrada no relatório PITest.")
                return {}
            print(f"Total de tabelas encontradas: {len(tables)}")

            # Iterar sobre todas as tabelas
            for i, table in enumerate(tables):
                print(f"Analisando tabela {i + 1}:")
                rows = table.find_all("tr")
                print(f"Total de linhas na tabela: {len(rows)}")
                if len(rows) <= 1:  # Ignorar tabelas com apenas o cabeçalho
                    print("Tabela contém apenas o cabeçalho ou está vazia.")
                    continue

                # Iterar pelas linhas da tabela, ignorando o cabeçalho
                for row in rows[1:]:
                    cols = row.find_all("td")
                    print(f"Total de colunas na linha: {len(cols)}")
                    if len(cols) >= 5:  # Verificar se há pelo menos 5 colunas
                        try:
                            package_name = cols[0].text.strip().replace("/", ".")
                            # Extrair apenas o percentual de 'Mutation Coverage' (coluna 3, índice 3)
                            mutation_coverage_text = cols[3].text.strip()
                            mutation_score = float(mutation_coverage_text.split()[0].rstrip("%"))
                            mutants_total = int(cols[3].text.strip().split()[1].split("/")[1])  # Total de mutantes
                            mutants_killed = int(cols[3].text.strip().split()[1].split("/")[0])  # Mutantes mortos
                            mutation_data[package_name] = {
                                "mutation_score": mutation_score,
                                "mutants_total": mutants_total,
                                "mutants_killed": mutants_killed,
                            }
                            print(f"Dados extraídos: Pacote={package_name}, Mutation Score={mutation_score}%")
                        except Exception as e:
                            print(f"Erro ao processar linha: {e}")
                            continue
                    else:
                        print("Linha não contém colunas suficientes (necessário pelo menos 5).")
            return mutation_data
    except FileNotFoundError:
        print(f"Erro: O arquivo {PITEST_REPORT} não foi encontrado.")
        return {}
    except Exception as e:
        print(f"Erro ao parsear PITest: {e}")
        return {}

def plot_coverage_percentage(package_coverage):
    if not package_coverage:
        print("Nenhum dado de cobertura por pacote disponível.")
        return
    sorted_packages = sorted(package_coverage.items(), key=lambda x: x[1]["coverage"])
    packages = [p[0] for p in sorted_packages]
    coverage_values = [p[1]["coverage"] for p in sorted_packages]

    plt.figure(figsize=(12, 6))
    colors = ["#FF5733" if cov < 80 else "#4CAF50" for cov in coverage_values]
    bars = plt.bar(packages, coverage_values, color=colors)
    plt.xlabel("Pacotes")
    plt.ylabel("Cobertura de Linhas (%)")
    plt.title("Cobertura de Linhas por Pacote (JaCoCo)")
    plt.xticks(rotation=45, ha="right")
    plt.ylim(0, 100)

    for bar in bars:
        height = bar.get_height()
        plt.text(bar.get_x() + bar.get_width()/2., height + 1,
                 f'{height:.1f}%', ha='center', va='bottom', fontsize=10)

    plt.tight_layout()
    plt.savefig(os.path.join(PLOT_DIR, "coverage_percentage.png"), dpi=150)
    plt.close()

def plot_lines_covered_missed(package_coverage):
    if not package_coverage:
        print("Nenhum dado de cobertura por pacote disponível.")
        return
    sorted_packages = sorted(package_coverage.items(), key=lambda x: x[1]["coverage"])
    packages = [p[0] for p in sorted_packages]
    covered_values = [p[1]["covered"] for p in sorted_packages]
    missed_values = [p[1]["missed"] for p in sorted_packages]

    x = np.arange(len(packages))
    width = 0.35

    fig, ax = plt.subplots(figsize=(12, 6))
    bars1 = ax.bar(x - width/2, covered_values, width, label='Linhas Cobertas', color="#2196F3")
    bars2 = ax.bar(x + width/2, missed_values, width, label='Linhas Não Cobertas', color="#FF5733")

    ax.set_ylabel('Número de Linhas')
    ax.set_title('Linhas Cobertas e Não Cobertas por Pacote (JaCoCo)')
    ax.set_xticks(x)
    ax.set_xticklabels(packages, rotation=45, ha="right")
    ax.legend()

    for bar in bars1:
        height = bar.get_height()
        ax.text(bar.get_x() + bar.get_width()/2., height + 5,
                f'{int(height)}', ha='center', va='bottom', fontsize=10)
    for bar in bars2:
        height = bar.get_height()
        ax.text(bar.get_x() + bar.get_width()/2., height + 5,
                f'{int(height)}', ha='center', va='bottom', fontsize=10)

    fig.tight_layout()
    plt.savefig(os.path.join(PLOT_DIR, "lines_covered_missed.png"), dpi=150)
    plt.close()

def plot_overall_coverage(covered, missed):
    if covered == 0 and missed == 0:
        print("Nenhum dado de cobertura geral disponível.")
        return
    labels = ["Linhas Cobertas", "Linhas Não Cobertas"]
    sizes = [covered, missed]
    colors = ["#4CAF50", "#FF5733"]
    explode = (0.1, 0)  # Destacar a fatia de linhas cobertas

    plt.figure(figsize=(8, 8))
    plt.pie(sizes, explode=explode, labels=labels, colors=colors, autopct="%1.1f%%",
            startangle=140, pctdistance=0.85, textprops={'fontsize': 12})
    plt.title("Cobertura Geral de Linhas (JaCoCo)", fontsize=14)
    plt.legend(labels=[f"{labels[0]} ({covered})", f"{labels[1]} ({missed})"],
               title="Contagem", loc="center left", bbox_to_anchor=(1, 0, 0.5, 1), fontsize=10)
    plt.tight_layout()
    plt.savefig(os.path.join(PLOT_DIR, "overall_coverage.png"), dpi=150)
    plt.close()

def plot_mutation_score(mutation_data):
    if not mutation_data:
        print("Nenhum dado de mutação por pacote disponível.")
        return
    sorted_packages = sorted(mutation_data.items(), key=lambda x: x[1]["mutation_score"])
    packages = [p[0] for p in sorted_packages]
    mutation_scores = [p[1]["mutation_score"] for p in sorted_packages]

    plt.figure(figsize=(12, 6))
    # Alterado para 50% em vez de 80%
    colors = ["#FF5733" if score < 50 else "#4CAF50" for score in mutation_scores]
    bars = plt.bar(packages, mutation_scores, color=colors)
    plt.xlabel("Pacotes")
    plt.ylabel("Pontuação de Mutação (%)")
    plt.title("Pontuação de Mutação por Pacote (PITest)")
    plt.xticks(rotation=45, ha="right")
    plt.ylim(0, 100)

    for bar in bars:
        height = bar.get_height()
        plt.text(bar.get_x() + bar.get_width()/2., height + 1,
                 f'{height:.1f}%', ha='center', va='bottom', fontsize=10)

    plt.tight_layout()
    plt.savefig(os.path.join(PLOT_DIR, "mutation_score.png"), dpi=150)
    plt.close()

if __name__ == "__main__":
    # Gerar gráficos para cobertura (JaCoCo)
    package_coverage, total_lines_covered, total_lines_missed = parse_jacoco_report()
    plot_coverage_percentage(package_coverage)
    plot_lines_covered_missed(package_coverage)
    plot_overall_coverage(total_lines_covered, total_lines_missed)

    # Gerar gráficos para mutação (PITest)
    mutation_data = parse_pitest_report()
    plot_mutation_score(mutation_data)

    print(f"Gráficos gerados em {PLOT_DIR}/")