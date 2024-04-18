package data;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class SavedMovies {

    public static void savedMovies(String movie) {


        try {
            FileWriter fileWriter = new FileWriter("movies.json", false);
            fileWriter.write(movie);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
