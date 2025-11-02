import string

from hypothesis.strategies import composite, text, booleans
import string
@composite
def gerar_menu_item(draw):
    nome = draw(text(alphabet=string.ascii_letters, min_size=2, max_size=12))
    valido = draw(booleans())
    return {
        "name": nome,
        "is_valid": valido
    }
