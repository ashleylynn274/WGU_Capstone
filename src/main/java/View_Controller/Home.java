package View_Controller;

import Main.NetflixRec;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    ComboBox<String> tv_movie_opt;
    ObservableList<String> tv_movie_opt_list = FXCollections.observableArrayList("TV Show", "Movie");
    @FXML
    ComboBox<String> release_decade_opt;

    ObservableList<String> release_decade_opt_list = FXCollections.observableArrayList("2020", "2010", "2000",
            "1990", "1980", "1970", "1960", "1950");
    @FXML
    ComboBox<String> genre_opt;

    ObservableList<String> genre_opt_list_movie = FXCollections.observableArrayList("Dramas", "Comedies", "Documentaries",
            "Thrillers", "International Movies", "Children & Family Movies",
            "Romantic Movies", "Music & Musicals", "Horror Movies", "Sci-Fi & Fantasy", "Anime Features");

    ObservableList<String> genre_opt_list_tv = FXCollections.observableArrayList("Docuseries", "TV Comedies", "TV Dramas",
            "Crime TV Shows", "Kids' TV", "Spanish-Language TV Shows", "TV Action & Adventure", "International TV Shows",
            "Anime Series", "Reality TV");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_movie_opt.setItems(tv_movie_opt_list);
        release_decade_opt.setItems(release_decade_opt_list);
    }

    public void onmovieoption(ActionEvent actionEvent) {
        if (tv_movie_opt.getValue() == "TV Show") {
            genre_opt.setItems(genre_opt_list_tv);
        }
        else {
            genre_opt.setItems(genre_opt_list_movie);
        }
    }

    public void go(ActionEvent actionEvent) throws IOException {
        String choice = tv_movie_opt.getValue();
        String decade = release_decade_opt.getValue();
        String genre = genre_opt.getValue();

        if (choice == null || decade == null || genre == null) {
            //System.out.println("POP UP: Please select a choice.");
            return;
        }

        Results.tv_movie_opt = choice;
        Results.release_decade_opt = decade;
        Results.genre_opt = genre;

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(NetflixRec.class.getResource("/View_Controller/Results.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 515);
        stage.setTitle("Netflix Recommendation Program");
        stage.setScene(scene);

        stage.show();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void dashboard(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(NetflixRec.class.getResource("/View_Controller/Visualizations.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 515);
        stage.setTitle("Netflix Recommendation Program");
        stage.setScene(scene);
        stage.show();
    }
}
