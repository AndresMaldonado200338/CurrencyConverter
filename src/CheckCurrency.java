import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CheckCurrency {

    public Coin requestAPI(String base, String result, double quantity) throws IOException, InterruptedException {
        URI URL = URI.create("https://v6.exchangerate-api.com/v6/76310284a374d36ee9d7cc45/pair/" + base + "/" + result + "/" + quantity);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URL).build();

        try {
            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Coin.class);
        } catch (NullPointerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
