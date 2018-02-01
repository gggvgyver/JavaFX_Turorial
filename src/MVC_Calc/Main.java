package MVC_Calc;

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
            Scene scene = new Scene(root, 280, 280);
            scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("도서관에서 FX 계산기 MVC형태로 제작 180201");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
