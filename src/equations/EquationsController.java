package equations;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class EquationsController {
    @FXML
    private TextField fieldInput;

    @FXML
    private Label labelOutput;

    public void initialize() {
        fieldInput.setFont(Font.font(24));
        labelOutput.setFont(Font.font(24));
    }

    public void solve() {
        EqSolver solver = new ABCEqSolver();
        String input = fieldInput.getText();
        String output = solver.matchesForm(input) ? solver.solve(input) : "정답을 찾지 못함";
        labelOutput.setText(output);
    }
}
