package DAO;

import Model.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class NetflixDao {
    public static final char SEP = '|';
    public static String aline = null;
    public static ObservableList<Videos> videoList = FXCollections.observableArrayList();
    public static void loadData() {
        // load the data into a local variable
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("netflix_titles_pipe.csv")));

            aline = reader.readLine();
            while (aline != null) {
                aline = reader.readLine();
                int idIndex = aline.indexOf(SEP);
                if (idIndex < 0)
                    break;
                String id = nextValue();
                String type = nextValue();
                String title = nextValue();
                String director = nextValue();

                String cast = nextValue();
                String country = nextValue();
                String date_added = nextValue();
                String release_year = nextValue();
                String rating = nextValue();
                String duration = nextValue();
                String listed_in = nextValue();
                String description = nextValue();

                Videos v = new Videos(id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description);
                videoList.add(v);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String nextValue(){
        int idIndex = aline.indexOf(SEP);
        if (idIndex < 0)
            return aline;
        String id = aline.substring(0, idIndex);
        aline = aline.substring(idIndex + 1);
        return id;
    }
}
