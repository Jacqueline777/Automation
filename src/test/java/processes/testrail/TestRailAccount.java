package processes.testrail;


import java.util.Properties;


public class TestRailAccount {
    public static APIClient testRailApiClient() {

        Properties prop = new Properties();
//        Properties passProp = getPassProperties();

        String baseUrl = "https://imstechlabs.testrail.io/index.php?/auth/login/";

        String usernameTestRail = "jkamadi@imsglobalventures.com";
//        String passwordTestRail = "ArekaCourt4@";

        String passwordTestRail =  "ScCIUFf7kBP39JgMWVTE-cemY8eiXwiz5NktrLEOo";

        APIClient client = new APIClient(baseUrl);
        client.setUser(usernameTestRail);
        client.setPassword(passwordTestRail);

        return client;
    }
}
