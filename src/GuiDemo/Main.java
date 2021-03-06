package GuiDemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("Gui.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("도서관에서 자바FX GUI 연습 180202");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
