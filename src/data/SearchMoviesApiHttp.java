package data;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class SearchMoviesApiHttp {

    public static String searchMoviesApi(int numberMovie) {

        final String url = "https://swapi.dev/api/films/" + numberMovie;

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest
                .newBuilder().uri(URI.create(url)).build();

        try {

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
