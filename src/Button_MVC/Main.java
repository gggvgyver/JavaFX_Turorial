package Button_MVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("내방에서 자바FX MVC 연습 180131");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
