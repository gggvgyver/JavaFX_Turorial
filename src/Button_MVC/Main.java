package Button_MVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Main.fxml"))));
        stage.setTitle("버튼을 누르세요 MVC 테스트 180131 내방에서");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
