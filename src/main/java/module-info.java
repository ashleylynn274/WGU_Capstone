module com.example.netflixrec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.netflixrec to javafx.fxml;
    //exports com.example.netflixrec;
    exports Main;
    opens Main to javafx.fxml;
    exports View_Controller;
    opens View_Controller to javafx.fxml;
    opens Model to javafx.base;
}