package JUnit_Test;

import MakeItFit.views.UserView;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UserViewTest {

    // Configura entrada/saída para testes
    private void setupIO(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @Test
    void testLoginWithNewUserCreation() throws Exception {
        String input = "n\n" +                     // Não carregar estado
                "test@example.com\n" +       // Email
                "y\n" +                      // Criar novo usuário
                "Amateur\n" +                // Tipo
                "John Doe\n" +               // Nome
                "30\n" +                     // Idade
                "Male\n" +                   // Gênero
                "70.0\n" +                   // Peso
                "180\n" +                    // Altura
                "75\n" +                     // BPM
                "3\n" +                      // Nível
                "123 Main St\n" +            // Endereço
                "555-1234\n";                // Telefone

        setupIO(input);
        UserView userView = new UserView();
        userView.login();
        assertNotNull(userView.makeItFitController.getEmail()); // Verifica se o email do usuário está configurado // Verifica se o usuário está logado
    }

    @Test
    void testGetUserDetails() throws Exception {
        String input = "n\ntest@example.com\ny\nAmateur\nJohn Doe\n30\nMale\n70.0\n180\n75\n3\n123 Main St\n555-1234\n";
        setupIO(input);
        UserView userView = new UserView();
        userView.login();
        assertDoesNotThrow(() -> userView.getUserDetails()); // Verifica se os detalhes são exibidos
    }
/* 
    @Test
    void testUpdateName() throws Exception {
        String input = "n\ntest@example.com\ny\nAmateur\nJohn Doe\n30\nMale\n70.0\n180\n75\n3\n123 Main St\n555-1234\n";
        setupIO(input);
        UserView userView = new UserView();
        userView.login();

        String updateInput = "Novo Nome\n";
        setupIO(updateInput);
        userView.updateName(); // Atualiza o nome
        assertEquals("Novo Nome", userView.makeItFitController.getName()); // Verifica a atualização // Verifica a atualização
    }
*/
    @Test
    void testAddActivityToUser() throws Exception {
        String input = "n\ntest@example.com\ny\nAmateur\nJohn Doe\n30\nMale\n70.0\n180\n75\n3\n123 Main St\n555-1234\n";
        setupIO(input);
        UserView userView = new UserView();
        userView.login();

        String activityInput = "PushUp\n01/01/2023\n30\nTreino\n10\n5\n";
        setupIO(activityInput);
        assertDoesNotThrow(() -> userView.addActivityToUser()); // Verifica se a atividade é adicionada
    }
}