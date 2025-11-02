from generators.queries_manager import in_interval


def caloric_waste(activity, index):
    tipo = activity["tipo"]
    if tipo == "Running":
        return int(activity["speed"] * activity["distance"] * index * 0.005)
    elif tipo == "PushUp":
        return int(activity["repetitions"] * activity["series"] * index * 0.1)
    elif tipo == "Trail":
        effort = (activity["distance"] * 0.5 +
                  activity["elevation_gain"] * 0.1 -
                  activity["elevation_loss"] * 0.1)
        return max(0, int(effort * index * 0.01))
    elif tipo == "WeightSquat":
        return int(activity["repetitions"] * activity["series"] *
                   activity["weight"] * 0.2 * index * 0.5)
    return 0




def gerar_teste_burns_more(data, user_refs, d1, d2):
    calorias_por_user = {user["email"]: 0 for user in data["users"]}
    users_by_code = {u["code"]: u for u in data["users"]}

    for a in data["activities"]:
        if not in_interval(a, d1, d2):
            continue
        user = users_by_code[a["user_code"]]
        user_email = user["email"]
        index = user["index"]
        calorias = caloric_waste(a, index)
        calorias_por_user[user_email] += calorias

    print("\nCalorias finais por utilizador no intervalo:")
    for email, total in calorias_por_user.items():
        print(f"{email}: {total}")

    max_calorias = max(calorias_por_user.values())
    empates = [email for email, cal in calorias_por_user.items() if cal == max_calorias]

    if len(empates) == 1:
        email_mais_calorias = empates[0]
        return f"""

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {{
            assertEquals("{email_mais_calorias}", r.getEmail());
        }}
        """
    else:
        emails_str = ', '.join(f'"{e}"' for e in empates)
        return f"""
        User resultado = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (resultado != null) {{
            Set<String> expected = new HashSet<>(Arrays.asList({emails_str}));
            assertTrue(expected.contains(resultado.getEmail()), "Utilizador vencedor não está no empate: " + resultado.getEmail());
        }}
        """

