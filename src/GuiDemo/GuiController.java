package GuiDemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    //체크박스
    @FXML private Label checkLabel; //라벨: 체크 결과값
    @FXML private CheckBox firstCheckBox; //체크박스1
    @FXML private CheckBox secondCheckBox; //체크박스2
    @FXML private CheckBox thirdCheckBox; //체크박스3

    //선택박스
    @FXML private Label choiceLabel; //라벨: 선택 결과값
    @FXML private ChoiceBox firstChoiceBox; //선택박스1

    //콤보박스
    @FXML private Label comboLabel; //라벨: 콤보 결과값
    @FXML private ComboBox firstComboBox; //콤보박스1

    //라디오박스
    @FXML private Label radioLabel; //라벨: 라디오 결과값
    @FXML private RadioButton firstRadioBox; //라디오박스1
    @FXML private RadioButton secondRadioBox; //라디오박스2
    @FXML private RadioButton thirdRadioBox; //라디오박스3
    @FXML private RadioButton fourthRadioBox; //라디오박스4

    //라디오박스 중복불가
    private ToggleGroup radioToggleGroup;

    //------------------------------------------------------

    //체크박스 결과
    public void checkButtonPushed() {
        String order = "니가 체크한것은: ";

        if(firstCheckBox.isSelected()) order += "\n파페로니";
        if(secondCheckBox.isSelected()) order += "\n파인애플";
        if(thirdCheckBox.isSelected()) order += "\n베이컨";

        this.checkLabel.setText(order);
    }

    // /선택박스 결과
    public void choiceButtonPushed() {
        this.choiceLabel.setText(firstChoiceBox.getValue().toString());
    }

    //콤보박스 결과
    public void comboButtonPushed() {
        this.comboLabel.setText("니가 선택한 콤보는:\n" + firstComboBox.getValue().toString());
    }

    //라디오박스 결과 표현1
    public  void radioButtonPushed() {
        String order = "라디오값: ";

        if(firstRadioBox.isSelected()) order += "\n자바";
        if(secondRadioBox.isSelected()) order += "\n파이썬";
        if(thirdRadioBox.isSelected()) order += "\n비주얼베이직";
        if(fourthRadioBox.isSelected()) order += "\nPHP";

        this.radioLabel.setText(order);
    }

    //라디오박스 결과 표현2
    public  void radioButtonPushed2() {
        if(this.radioToggleGroup.getSelectedToggle().equals(this.firstRadioBox)) radioLabel.setText("자바");
        if(this.radioToggleGroup.getSelectedToggle().equals(this.secondRadioBox)) radioLabel.setText("파이썬");
        if(this.radioToggleGroup.getSelectedToggle().equals(this.thirdRadioBox)) radioLabel.setText("비주얼베이직");
        if(this.radioToggleGroup.getSelectedToggle().equals(this.fourthRadioBox)) radioLabel.setText("PHP");
    }

    //------------------------------------------------------

    public void initialize(URL url, ResourceBundle rb) {
        //체크박스 초기값
        checkLabel.setText("");

        //선택박스 초기값
        choiceLabel.setText("선택하세요!");
        firstChoiceBox.getItems().add("사과");
        firstChoiceBox.getItems().add("배");
        firstChoiceBox.getItems().addAll("바나나", "오렌지", "감", "수박");

        //콤보박스 초기값
        firstComboBox.getItems().add("노트북");
        firstComboBox.getItems().addAll("TV", "냉장고", "세탁기");

        //라디오박스 초기값
        radioLabel.setText("");
        radioToggleGroup = new ToggleGroup();
        this.firstRadioBox.setToggleGroup(radioToggleGroup);
        this.secondRadioBox.setToggleGroup(radioToggleGroup);
        this.thirdRadioBox.setToggleGroup(radioToggleGroup);
        this.fourthRadioBox.setToggleGroup(radioToggleGroup);
    }
}
