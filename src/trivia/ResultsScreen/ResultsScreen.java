package trivia.ResultsScreen;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
import javafx.scene.text.Text;
import trivia.App;
import trivia.Category;
import trivia.Question;

public class ResultsScreen {

    Image checkIcon = new Image("file:bx_bx-check.png");
    Image xIcon = new Image("file:bx_bx-x.png");

    @FXML
    AnchorPane mainPane;

    @FXML
    VBox answersList;

    @FXML
    Text playerPoints;

    public void initialize() {
        Category category = App.getInstance().getSelectedCategory();

        playerPoints.setText(String.valueOf(App.getInstance().getPoints()));

        for (Question question : category.getQuestions()) {
            createResultItem(question);
        }
    }

    @FXML
    private void goToHome() throws Exception {
        App.getInstance().loadScene("HomeScreen/HomeScreen.fxml");
    }

    /**
     * Create an ui element with the result of answer
     * @param question The question to display
     */
    private void createResultItem(Question question) {
        HBox questionItem = new HBox();
        questionItem.setAlignment(Pos.TOP_CENTER);
        questionItem.setPrefWidth(200);
        questionItem.setLayoutX(10);
        questionItem.setLayoutX(224);

        VBox sentenceContainer = new VBox();
        sentenceContainer.setPrefWidth(509);

        Text sentenceText = new Text(question.getSentece());
        sentenceText.setFill(Color.web("#3c3e42"));
        sentenceText.setStyle("-fx-font-size: 16px");

        Text answerText = new Text(question.getSelectedOption());
        answerText.setFill(Color.web("#3c3e42"));
        answerText.setStyle("-fx-font-size: 16px");


        ImageView icon = new ImageView();

        icon.setImage(checkIcon);
        icon.setFitWidth(100);
        icon.setPreserveRatio(true);

        sentenceContainer.getChildren().addAll(sentenceText, answerText);
        questionItem.getChildren().addAll(sentenceContainer, icon);
        answersList.getChildren().add(questionItem);
    }
}
