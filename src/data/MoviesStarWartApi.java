package data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import record.MoviesApi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MoviesStarWartApi {

    public static void requestMoviesStartWart() {

        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();
        try {

            System.out.println("Enter the movie ID to search: ");
            int numberMovie = scanner.nextInt();

            String resultJsonMovie = SearchMoviesApiHttp.searchMoviesApi(numberMovie);
            System.out.println(resultJsonMovie);
            MoviesApi moviesApi = gson.fromJson(resultJsonMovie, MoviesApi.class);
            System.out.println(moviesApi);

            SavedMovies.savedMovies(gson.toJson(moviesApi));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }

    }

}
