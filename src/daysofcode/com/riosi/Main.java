package daysofcode.com.riosi;
import java.net.URI;
import java.net.http.*;

// project: consumir API do IMDB e mostrar os Top250 filmes no console
// usar libs java.net.URI & java.net.http
// o método joga uma exceção por causa do HttpResponse

public class Main {

    public static void main(String[] args) throws Exception {

        String apiKey = "k_e4434yd3";
        URI apiImDb = URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey); // cria URI object

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(apiImDb).build(); // passo a uri pra fazer a chamada.

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // cria handler do tipo string
        String jsonResponse = response.body(); // guarda a resposta em formato json

        System.out.println(jsonResponse);

    }

}
