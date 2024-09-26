import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Caller {
    private static final String apiSite = "https://v6.exchangerate-api.com/v6/";
    private static String apiKey;

    public static void configLoader() {
        Properties properties = new Properties();
        String configPath = "config.properties";
        try (FileInputStream input = new FileInputStream(configPath)) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        apiKey = properties.getProperty("api_key");
    }

    public static void convert(double cantidad, String from, String to) throws IOException, InterruptedException {
        configLoader();
        String callSite = apiSite + apiKey + "/pair/" + from + "/" + to + "/" + cantidad;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(callSite)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var json = response.body();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double conversion = jsonObject.get("conversion_result").getAsDouble();
        System.out.println("El valor de " + cantidad + " " + from + " corresponde al valor final de " + to + " " + conversion);
    }

}
