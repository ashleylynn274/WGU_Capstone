package Main;

import DAO.NetflixDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NetflixRec extends Application {
    public NetflixRec() {}

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NetflixRec.class.getResource("/View_Controller/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 515);
        stage.setTitle("Netflix Recommendation Program");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        NetflixDao.loadData();

        launch();
    }
}