package notes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NotesApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("notes.fxml"));
        Parent root = loader.load();

        stage.setOnCloseRequest(event -> {
            event.consume();
            loader.<NotesController>getController().exit();
        });
        stage.setScene(new Scene(root));
        stage.show();
    }
}
