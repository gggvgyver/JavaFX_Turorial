package notes;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class NotesController {
    @FXML
    private DatePicker picker;

    @FXML
    private TextArea notes;

    private Map<LocalDate, String> data = new HashMap<>();

    public void initialize() {
        load();

        picker.valueProperty().addListener((o, oldDate, date) -> {
            notes.setText(data.getOrDefault(date, ""));
        });

        picker.setValue(LocalDate.now());
    }

    public void updateNotes() {
        data.put(picker.getValue(), notes.getText());
    }

    public void exit() {
        save();
        Platform.exit();
    }

    private void save() {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("notes.data")))) {
            stream.writeObject(data);
            System.out.println("저장성공");
        } catch (Exception e) {
            System.out.println("저장실패: " + e);
        }
    }

    private void load() {
        Path file = Paths.get("notes.data");

            if(Files.exists(file)) {
                try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(file))) {
                    data = (Map<LocalDate, String>) stream.readObject();
                    System.out.println("불러오기성공");
                } catch (Exception e) {
                    System.out.println("불러오기실패: " + e);
            }
        }
    }
}
