.PHONY: all clean test coverage report plot

# Diretórios
REPORT_DIR = target/site
PLOT_DIR = plots

# Comandos padrão
MVN = mvn
PYTHON = python

# Regra principal: executa testes, análise de mutação e gera gráficos
all:
	$(MVN) clean verify
	$(MVN) pitest:mutationCoverage
	$(PYTHON) scripts/plot_coverage.py
	@echo "Testes, análise de mutação e gráficos gerados em $(PLOT_DIR)/"

# Executa os testes com Maven
test:
	$(MVN) clean verify
	@echo "Testes executados"

# Gera os gráficos
plot:
	$(PYTHON) scripts/plot_coverage.py
	@echo "Gráficos gerados em $(PLOT_DIR)/"

# Limpa o projeto
clean:
	$(MVN) clean
	@rmdir /s /q "$(PLOT_DIR)"
	@echo "Projeto limpo"