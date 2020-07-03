package trivia.HomeScreen;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import trivia.App;
import trivia.Config;
import trivia.Utilities;

public class HomeScreen {

    private ArrayList<String> categoryList = new ArrayList<String>();

    @FXML
    private HBox categoryButtons;

    public void initialize() {
        setCategoryNames();
        createButtons();
    }

    private void createButtons() {
        for (String category : categoryList) {
            Button categoryButton = new Button(category);
            categoryButton.setOnAction((ActionEvent event) -> {
                App.getInstance().setCategory(category);
                try {
                    App.getInstance().loadScene("QuestionScreen/QuestionScreen.fxml");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            categoryButtons.getChildren().add(categoryButton);
        }
    }

    private void setCategoryNames() {
        File questionsFolder = new File(Config.URL_QUESTION_SOURCE);
        File[] listOfFiles = questionsFolder.listFiles();

        for (File questionFile : listOfFiles) {
            String categoryName;
            if (questionFile.isFile()) {
                categoryName = Utilities.removeExtension(questionFile.getName());
                categoryList.add(Utilities.capitalize(categoryName));
            }
        }
    }

}
