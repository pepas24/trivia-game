package trivia.SplashScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import trivia.App;

public class SplashScreen {

    @FXML
    protected void handleNextScreen(ActionEvent event) throws Exception {
        App.getInstance().loadScene("HomeScreen/HomeScreen.fxml");
    }

}
