package FX_DESIGNS.buttons;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Buttons extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buttons.fxml"));

        /*
        AlarmController controller = new AlarmController(new AlarmModel());
        loader.setController(controller);
        */

        stage.setScene(new Scene(loader.load()));
        //stage.setOnCloseRequest(event -> controller.onExit());
        stage.setTitle("도서관에서 버튼연습 180131");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
