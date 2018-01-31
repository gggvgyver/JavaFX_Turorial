package alarm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlarmApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));

        AlarmController controller = new AlarmController(new AlarmModel());
        loader.setController(controller);

        stage.setScene(new Scene(loader.load()));
        stage.setOnCloseRequest(event -> controller.onExit());
        stage.setTitle("FX로 만든 알람시계 180125 도서관에서");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
