import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Caller {

    private final String configPath = "config.properties";
    private final String apiSite = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;
    private String configSupported;
    private String[] supported;
    private String fromTo;

    private void configLoader() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(configPath)) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        apiKey = properties.getProperty("apiKey");
        configSupported = properties.getProperty("selected_currencies");
        String[] supported = configSupported.split(",");
        fromTo = properties.getProperty("convert_to");
    }


    public void unwrap(String modifier) {
        String callSite = apiSite + apiKey + "/" + modifier;
        String content = httpContent(callSite);

    }

    public void unwrap(String modifier, String callName) {
        String callSite = apiSite + apiKey + "/" + modifier + "/" + fromTo + "/" + callName;
        String content = httpContent(callSite);
    }

    private String httpContent(String callSite) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(callSite)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void supported() {
        String modifier = "codes";
    }

    public void convert() {
        String modifier = "pair";
    }

}
