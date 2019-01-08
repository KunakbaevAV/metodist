import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @autor Kunakbaev Artem
 */
public class MainWindow extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));
        primaryStage.setTitle("Электронный методист");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

