package trivia.QuestionScreen;

//import javax.swing.text.html.Option;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import trivia.App;
import trivia.Category;
import trivia.Question;

public class QuestionScreen {

    Category selectedCategory;
    Question currentQuestion;
    int indexQuestion;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Text points;

    public void initialize() {
        indexQuestion =0;
        selectedCategory = App.getInstance().getSelectedCategory();
        currentQuestion = selectedCategory.getQuestions().get(indexQuestion);
        setQuestion(currentQuestion);
    }

    private void setQuestion(final Question question) {
        final QuestionSubScene questionSubScene = new QuestionSubScene(question);
        mainPane.getChildren().add(questionSubScene);
        currentQuestion = selectedCategory.getQuestions().get(indexQuestion);
    }

    @FXML

    private void nextQuestion() {
        if (indexQuestion < selectedCategory.getQuestions().size()) {

            if (currentQuestion.validateAnswer(currentQuestion.getSelectedOption())) {
                App.getInstance().addPoints();
                points.setText(Integer.toString(App.getInstance().getPoints()));
            }
            // Set next question in category
            indexQuestion++;
        }

        if (indexQuestion == selectedCategory.getQuestions().size()) {
            try {
                App.getInstance().loadScene("ResultsScreen/ResultsScreen.fxml");
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        setQuestion(selectedCategory.getQuestions().get(indexQuestion));
    }

}
