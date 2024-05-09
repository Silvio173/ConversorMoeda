package scr;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestCurrency {
    public Currency searchCurrency(String coin){
        URI address = URI.create("https://v6.exchangerate-api.com/v6/b2e192d097de5dbd9cfe296a/latest/"
        + coin);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Não consegui obter o valor de conversão");
        }
    }
}
