package JUnit_Test;

import MakeItFit.views.AdminView;
import MakeItFit.views.MakeItFitView;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
/* 
class AdminViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private InputStream originalIn;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        originalIn = System.in;
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    // Teste de login do administrador
    @Test
    void testAdminLogin() {
        provideInput("n\n"); // Não carregar estado
        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::login);
        assertTrue(outContent.toString().contains("Logging in as administrator"));
    }

    // Teste de criação de usuário
    @Test
    void testCreateUser() {
        String input = "newuser@example.com\n" +
                "Amateur\n" +
                "Jane Smith\n" +
                "28\n" +
                "Female\n" +
                "65.5\n" +
                "170\n" +
                "72\n" +
                "4\n" +
                "456 Oak St\n" +
                "555-5678\n";

        provideInput(input);
        AdminView adminView = new AdminView();
        assertDoesNotThrow(() -> {
            adminView.setNewEmail();
            adminView.createUser();
        });
        assertTrue(outContent.toString().contains("User created successfully"));
    }

    // Teste de remoção de usuário
    @Test
    void testRemoveUser() {
        // Primeiro cria um usuário
        testCreateUser();

        provideInput("newuser@example.com\n");
        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::removeUser);
        assertTrue(outContent.toString().contains("User removed successfully"));
    }

    // Teste de atualização de nome
    @Test
    void testUpdateName() {
        // Cria usuário
        testCreateUser();

        provideInput("newuser@example.com\nUpdated Name\n");
        AdminView adminView = new AdminView();
        assertDoesNotThrow(() -> {
            adminView.setEmail();
            adminView.updateName();
        });
        assertTrue(outContent.toString().contains("Name updated successfully"));
    }

    // Teste de listagem de todos os usuários
    @Test
    void testPrintAllUsersDetails() {
        // Cria pelo menos um usuário
        testCreateUser();

        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::printAllUsersDetails);
        assertTrue(outContent.toString().contains("(All users)"));
    }

    // Teste de adição de atividade
    @Test
    void testAddActivityToUser() {
        testCreateUser();

        String activityInput = "newuser@example.com\n" +
                "Running\n" +
                "01/01/2023\n" +
                "45\n" +
                "Morning Run\n" +
                "5000\n" +
                "10.5\n";

        provideInput(activityInput);
        AdminView adminView = new AdminView();
        assertDoesNotThrow(() -> {
            adminView.setEmail();
            adminView.addActivityToUser();
        });
        assertTrue(outContent.toString().contains("Activity added to user successfully"));
    }

    // Teste de execução de query (exemplo: quilômetros corridos)
    @Test
    void testExecuteQueryHowManyKMsDone() {
        testAddActivityToUser(); // Garante que há dados para a query

        String queryInput = "newuser@example.com\ny\n01/01/2023\n01/02/2023\n";
        provideInput(queryInput);
        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::executeQueryHowManyKMsDone);
        assertTrue(outContent.toString().contains("kilometers"));
    }

    // Teste de execução de query (atividade mais realizada)
    @Test
    void testExecuteQueryMostDoneActivity() {
        testAddActivityToUser(); // Garante que há dados

        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::executeQueryMostDoneActivity);
        assertTrue(outContent.toString().contains("Result:"));
    }

    // Teste de avanço de tempo
    @Test
    void testAdvanceTimeManager() {
        provideInput("7\n"); // Avança 7 dias
        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::advanceTimeManager);
        assertTrue(outContent.toString().contains("Time advanced successfully"));
    }

    // Teste de salvamento do sistema
    @Test
    void testSaveSystem() {
        provideInput("backup.dat\n");
        AdminView adminView = new AdminView();
        assertDoesNotThrow(adminView::saveSystem);
        assertTrue(outContent.toString().contains("System state saved successfully"));
    }

    // Teste de todas as queries
    @Test
    void testAllQueries() {
        testAddActivityToUser(); // Dados para as queries

        AdminView adminView = new AdminView();

        // Query 1: Quilômetros corridos
        provideInput("newuser@example.com\nn\n");
        assertDoesNotThrow(adminView::executeQueryHowManyKMsDone);

        // Query 2: Altimetria
        provideInput("newuser@example.com\nn\n");
        assertDoesNotThrow(adminView::executeQueryHowManyAltimetryDone);

        // Query 3: Plano mais exigente
        assertDoesNotThrow(adminView::executeQueryMostDemandingTrainingPlan);

        // Query 4: Atividade mais realizada
        assertDoesNotThrow(adminView::executeQueryMostDoneActivity);

        // Query 5: Maior queima calórica
        provideInput("n\n");
        assertDoesNotThrow(adminView::executeQuerywhoBurnsMoreCalories);

        // Query 6: Mais atividades realizadas
        provideInput("n\n");
        assertDoesNotThrow(adminView::executeQueryWhoDidTheMostActivities);

        // Query 7: Listar atividades do usuário
        provideInput("newuser@example.com\n");
        assertDoesNotThrow(adminView::executeQueryGetAllActivitiesFromUser);

        String output = outContent.toString();
        assertTrue(output.contains("Result:"));
    }
}
*/