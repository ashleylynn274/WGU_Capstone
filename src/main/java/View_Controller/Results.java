package View_Controller;

import DAO.NetflixDao;
import Main.NetflixRec;
import Model.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Results implements Initializable {
    public static String tv_movie_opt;
    public static String release_decade_opt;
    public static String genre_opt;
    public TableColumn title_col;
    public TableColumn date_col;
    public TableColumn description_col;
    public TableView<Videos> table_id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // pass data from home to here to calculate results
        ObservableList<Videos> videoList = FXCollections.observableArrayList();

        for (Videos V: NetflixDao.videoList) {
            if (V.getType().equals(tv_movie_opt) && (V.isInDecade(release_decade_opt)) && (V.isInGenre(genre_opt))){
                videoList.add(V);
            }
        }
        table_id.setItems(videoList);
        title_col.setCellValueFactory(new PropertyValueFactory<>("Title"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("Release_year"));
        description_col.setCellValueFactory(new PropertyValueFactory<>("Description"));
    }

    public void home(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(NetflixRec.class.getResource("/View_Controller/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 515);
        stage.setTitle("Netflix Recommendation Program");
        stage.setScene(scene);
        stage.show();
    }
}
