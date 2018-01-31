package Button_MVC;

import javafx.event.ActionEvent;

import java.util.Random;

public class MainController {

    public void generateRandom(ActionEvent event) {
        Random rand = new Random();
        int myrand = rand.nextInt(50) + 1;
        System.out.println(Integer.toString(myrand));
    }
}
