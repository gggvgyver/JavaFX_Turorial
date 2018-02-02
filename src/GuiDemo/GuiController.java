package GuiDemo;

import javafx.collections.ObservableList;
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
    @FXML private ChoiceBox<String> firstChoiceBox; //선택박스1

    //콤보박스
    @FXML private Label comboLabel; //라벨: 콤보 결과값
    @FXML private ComboBox<String> firstComboBox; //콤보박스1

    //라디오박스
    @FXML private Label radioLabel; //라벨: 라디오 결과값
    @FXML private RadioButton firstRadioBox; //라디오박스1
    @FXML private RadioButton secondRadioBox; //라디오박스2
    @FXML private RadioButton thirdRadioBox; //라디오박스3
    @FXML private RadioButton fourthRadioBox; //라디오박스4

    //라디오박스 중복불가
    private ToggleGroup radioToggleGroup;

    //리스트뷰와 텍스트영역
    @FXML private ListView<String> listView;
    @FXML private TextArea textArea;

    //------------------------------------------------------

    //체크박스 결과
    public void checkButtonPushed() {
        String order = "니가 체크한것은: ";

        if(this.firstCheckBox.isSelected()) order += "\n파페로니";
        if(this.secondCheckBox.isSelected()) order += "\n파인애플";
        if(this.thirdCheckBox.isSelected()) order += "\n베이컨";

        this.checkLabel.setText(order);
    }

    // /선택박스 결과
    public void choiceButtonPushed() {
        this.choiceLabel.setText(firstChoiceBox.getValue());
    }

    //콤보박스 결과
    public void comboButtonPushed() {
        this.comboLabel.setText("니가 선택한 콤보는:\n" + firstComboBox.getValue());
    }

    /* 라디오박스 결과 표현1 */
    public  void radioButtonPushed() {
        String order = "라디오값: ";

        if(this.firstRadioBox.isSelected()) order += "\n자바";
        if(this.secondRadioBox.isSelected()) order += "\n파이썬";
        if(this.thirdRadioBox.isSelected()) order += "\n비주얼베이직";
        if(this.fourthRadioBox.isSelected()) order += "\nPHP";

        this.radioLabel.setText(order);
    }

    /* 라디오박스 결과 표현2 */
    public  void radioButtonPushed2() {
        if(this.radioToggleGroup.getSelectedToggle().equals(this.firstRadioBox)) radioLabel.setText("자바");
        if(this.radioToggleGroup.getSelectedToggle().equals(this.secondRadioBox)) radioLabel.setText("파이썬");
        if(this.radioToggleGroup.getSelectedToggle().equals(this.thirdRadioBox)) radioLabel.setText("비주얼베이직");
        if(this.radioToggleGroup.getSelectedToggle().equals(this.fourthRadioBox)) radioLabel.setText("PHP");
    }

    /* 리스트뷰와 텍스트영역 설정*/
    public void listViewButtonPushed() {
        StringBuilder textAreaString = new StringBuilder();
        ObservableList listOfItems = listView.getSelectionModel().getSelectedItems();
        for(Object item : listOfItems) {
            textAreaString.append(String.format("%s%n", (String) item));
        }
        textArea.setText(textAreaString.toString());
    }

    //------------------------------------------------------

    public void initialize(URL url, ResourceBundle rb) {
        /* 체크박스 초기값 */
        this.checkLabel.setText("");

        /* 선택박스 초기값 */
        this.choiceLabel.setText("선택하세요!");
        this.firstChoiceBox.getItems().add(0, "꿀사과");
        this.firstChoiceBox.getItems().add(1, "사과");
        this.firstChoiceBox.getItems().add(2, "배");

        /* 콤보박스 초기값 */
        this.firstComboBox.getItems().add(0, "노트북");
        this.firstComboBox.getItems().add(1, "세탁기");
        this.firstComboBox.getItems().add(2, "전자렌지");
        this.firstComboBox.getItems().add(3, "컴퓨터");

        /* 라디오박스 초기값 */
        this.radioLabel.setText("");
        radioToggleGroup = new ToggleGroup();
        this.firstRadioBox.setToggleGroup(radioToggleGroup);
        this.secondRadioBox.setToggleGroup(radioToggleGroup);
        this.thirdRadioBox.setToggleGroup(radioToggleGroup);
        this.fourthRadioBox.setToggleGroup(radioToggleGroup);

        /* 리스트뷰와 텍스트영역 초기값*/
        this.listView.getItems().add(0, "축구");
        this.listView.getItems().add(1, "농구");
        this.listView.getItems().add(2, "야구");
        this.listView.getItems().add(3, "배구");
        this.listView.getItems().add(4, "당구");
        this.listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
