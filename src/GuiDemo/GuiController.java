package GuiDemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    //체크박스
    @FXML private Label viewLabelOne; //라벨: 결과값1
    @FXML private CheckBox firstCheckBox; //체크박스1
    @FXML private CheckBox secondCheckBox; //체크박스2
    @FXML private CheckBox thirdCheckBox; //체크박스3

    //선택박스
    @FXML private Label viewLabelTwo; //라벨: 결과값2
    @FXML private ChoiceBox firstChoiceBox; //선택박스1

    public void checkButtonPushed() {
        String order = "니가 체크한것은: ";

        if(firstCheckBox.isSelected()) order += "\n파페로니";
        if(secondCheckBox.isSelected()) order += "\n파인애플";
        if(thirdCheckBox.isSelected()) order += "\n베이컨";

        this.viewLabelOne.setText(order);
    }

    public void choiceButtonPushed() {
        this.viewLabelTwo.setText(firstChoiceBox.getValue().toString());
    }

    public void initialize(URL url, ResourceBundle rb) {
        //체크박스
        viewLabelOne.setText("");

        //선택박스
        viewLabelTwo.setText("");
        firstChoiceBox.getItems().add("사과");
        firstChoiceBox.getItems().add("배");
        firstChoiceBox.getItems().addAll("바나나", "오렌지", "감", "수박");

    }
}
