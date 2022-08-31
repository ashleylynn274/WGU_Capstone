package View_Controller;

import DAO.NetflixDao;
import Main.NetflixRec;
import Model.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Visualizations implements Initializable {

    @FXML
    public PieChart type_pie;

    @FXML
    public PieChart rating_pie;

    @FXML
    public BarChart<String, Integer> bar_chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_movie_pie_chart();
        rating_pie();
        set_bar_chart();
    }

    public void tv_movie_pie_chart() {
        int movieCount = 0;
        int tvCount = 0;

        for (Videos V: NetflixDao.videoList) {
            if (Objects.equals(V.getType(), "Movie")) {
                movieCount++;
            }
            else if (Objects.equals(V.getType(), "TV Show")){
                tvCount++;
            }
        }

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Movies", movieCount),
                        new PieChart.Data("TV Shows", tvCount)
                        );
        type_pie.setData(pieChartData);
    }

    public void rating_pie() {
        int g = 0;
        int pg = 0;
        int pg13 = 0;
        int r = 0;

        for (Videos x: NetflixDao.videoList) {
            if (Objects.equals(x.getRating(), "G")) {
                g++;
            }
            else if (Objects.equals(x.getRating(), "PG")) {
                pg++;
            }
            else if (Objects.equals(x.getRating(), "PG-13")) {
                pg13++;
            }
            else if (Objects.equals(x.getRating(), "R")) {
                r++;
            }
        }

        ObservableList<PieChart.Data> data =
                FXCollections.observableArrayList(
                        new PieChart.Data("G", g),
                        new PieChart.Data("PG", pg),
                        new PieChart.Data("PG-13", pg13),
                        new PieChart.Data("R", r));
        rating_pie.setData(data);
    }

    public void set_bar_chart() {
        int fifties = 0;
        int sixties = 0;
        int seventies = 0;
        int eighties = 0;
        int ninties = 0;
        int ooohs = 0;
        int tens = 0;
        int twenties = 0;

        for (Videos V: NetflixDao.videoList) {
            // if in decade, add to list
            if (V.isInDecade("1950")) {
                //add to 50s
                fifties++;
            } else if (V.isInDecade("1960")) {
                sixties++;
            } else if (V.isInDecade("1970")) {
                seventies++;
            } else if (V.isInDecade("1980")) {
                eighties++;
            } else if (V.isInDecade("1990")) {
                ninties++;
            } else if (V.isInDecade("2000")) {
                ooohs++;
            } else if (V.isInDecade("2010")) {
                tens++;
            } else if (V.isInDecade("2020")) {
                twenties++;
            }
        }

        System.out.println("'20: " + twenties);

        XYChart.Series s = new XYChart.Series();
        s.getData().add(new XYChart.Data<>("'50s", fifties));
        s.getData().add(new XYChart.Data<>("'60s", sixties));
        s.getData().add(new XYChart.Data<>("'70s", seventies));
        s.getData().add(new XYChart.Data<>("'80s", eighties));
        s.getData().add(new XYChart.Data<>("'90s", ninties));
        s.getData().add(new XYChart.Data<>("'00s", ooohs));
        s.getData().add(new XYChart.Data<>("'10s", tens));
        s.getData().add(new XYChart.Data<>("'20s", twenties));

        bar_chart.getData().add(s);
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
