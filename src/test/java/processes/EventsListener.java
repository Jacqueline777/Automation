    package processes;
        import io.cucumber.plugin.ConcurrentEventListener;
        import io.cucumber.plugin.event.*;
        import java.io.*;
        import java.util.Properties;

    public class EventsListener implements ConcurrentEventListener {
        Result result ;
        Status status;
        Throwable error;
        String error_message;
//        static
        String path = "C/Users/jacqueline.kamadi/Automation/APIs/src/test/java/processes/utils/getPassProperties.properties";
        @Override
        public void setEventPublisher(EventPublisher publisher) {
            publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
        }

        public  String handleTestCaseFinished(TestCaseFinished event) {
                TestCase testCase = event.getTestCase();

                 result = event.getResult();
                 status = result.getStatus();
                 if(status.toString().equalsIgnoreCase("failed")){

                     error = result.getError();
                     String scenarioName = testCase.getName();
                     System.out.println("Testcase " +   " - " + status.name()+"id "+scenarioName);
                     error_message=error.getMessage();

                     FileOutputStream fileOut = null;
                     FileInputStream fileIn = null;

                         Properties configProperty = new Properties();

                         File file = new File(path);
                     try {
                         fileIn = new FileInputStream(file);
                     } catch (FileNotFoundException e) {
                         throw new RuntimeException(e);
                     }
                     try {
                         configProperty.load(fileIn);
                     } catch (IOException e) {
                         throw new RuntimeException(e);
                     }
                     configProperty.setProperty(testCase.getTags().toString(), error_message);
                     try {
                         fileOut = new FileOutputStream(file);
                     } catch (FileNotFoundException e) {
                         throw new RuntimeException(e);
                     }
                     try {
                         configProperty.store(fileOut, path);
                     } catch (IOException e) {
                         throw new RuntimeException(e);
                     }
                 }
                 else{

                     error = null;
                     String scenarioName = testCase.getName();
                     String id = "" + testCase.getUri() + testCase.getLine();
                     System.out.println("Testcase " + id + " - " + status.name());
                     error_message="No error";
                 }
                return error_message;
            }
    }

