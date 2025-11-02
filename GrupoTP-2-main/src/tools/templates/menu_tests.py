from generators.menu import gerar_menu_item
from pathlib import Path

def gerar_metodo_teste_menuitem(i, item):
    nome = item["name"].replace('"', '\\"')
    condicao_valida = item["is_valid"]

    return f"""
    @Test
    public void testMenuItem_{i}() {{
        MenuItem.PreCondition cond = () -> {str(condicao_valida).lower()};
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("{nome}", cond, action);

        assertEquals("{nome}", item.getName());
        assertEquals({str(condicao_valida).lower()}, item.isValid());

        if (item.isValid()) {{
            item.execute();
        }}
    }}
    """.strip()



def gerar_classe_menuitem_tests():
    metodos = []
    for i in range(10):
        exemplo = gerar_menu_item().example()
        metodo = gerar_metodo_teste_menuitem(i, exemplo)  # gera string de método Java
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.menu.MenuItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/MenuItemGeneratedTest.java").write_text(codigo, encoding="utf-8")

gerar_classe_menuitem_tests()