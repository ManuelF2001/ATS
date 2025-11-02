from generators.queries_manager import in_interval


def contar_atividades(user_activities, d1=None, d2=None):
    if d1 and d2:
        return sum(1 for a in user_activities if in_interval(a, d1, d2))
    return len(user_activities)


def gerar_teste_most_activities(data, user_refs, d1, d2):
    atividades_por_user = {user["email"]: 0 for user in data["users"]}
    users_by_code = {u["code"]: u for u in data["users"]}

    for a in data["activities"]:
        if not in_interval(a, d1, d2):
            continue
        user = users_by_code[a["user_code"]]
        user_email = user["email"]
        atividades_por_user[user_email] += 1

    print("\nAtividades finais por utilizador no intervalo:")
    for email, total in atividades_por_user.items():
        print(f"{email}: {total}")

    max_atividades = max(atividades_por_user.values())
    empates = [email for email, total in atividades_por_user.items() if total == max_atividades]

    if len(empates) == 1:
        email_mais_atividades = empates[0]
        return f"""

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {{
            assertEquals("{email_mais_atividades}", result.getEmail());
        }}
        """
    else:
        emails_str = ', '.join(f'"{e}"' for e in empates)
        return f"""

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {{
            Set<String> expected = new HashSet<>(Arrays.asList({emails_str}));
            assertTrue(expected.contains(result.getEmail()), "Utilizador vencedor não está no empate: " + result.getEmail());
        }}
        """
