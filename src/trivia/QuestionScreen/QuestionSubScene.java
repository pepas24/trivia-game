package trivia.QuestionScreen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.SubScene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import trivia.Question;

public class QuestionSubScene extends SubScene {

    private Question currentQuestion;
    private ToggleGroup radioButtonGroup;
    private VBox optionsContainer;

    public QuestionSubScene(Question question) {
        super(new AnchorPane(), 350, 250);
        prefWidth(350);
        prefHeight(250);

        currentQuestion = question;

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setStyle("-fx-background-color: lightblue");

        Text senteceText = new Text(currentQuestion.getSentece());
        senteceText.setLayoutX(10);
        senteceText.setLayoutY(10);
        root2.getChildren().add(senteceText);


        createOptionContainer();
        createOptions();

        root2.getChildren().add(optionsContainer);
    }

    private void createOptionContainer() {
        optionsContainer = new VBox();
        optionsContainer.setLayoutX(20);
        optionsContainer.setLayoutY(20);
    }

    private void createOptions() {
        radioButtonGroup = new ToggleGroup();

        for (String answerOption : currentQuestion.getAnswerOptions()) {
            RadioButton radioButton = new RadioButton(answerOption);
            radioButton.setToggleGroup(radioButtonGroup);
            optionsContainer.getChildren().add(radioButton);
        }

        radioButtonGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle) {
                currentQuestion.setAnswer(((RadioButton)newToggle).getText());
            }
        });
    }

}
