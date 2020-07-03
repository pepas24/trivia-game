package trivia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * App
 */
public class App extends Application {

    private Stage stage;
    private static App instance;
    private int points;
    private Category selectedCategory;

    public App() {
        instance = this;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        loadScene("SplashScreen/SplashScreen.fxml");
        primaryStage.setTitle(Config.APP_TITLE);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    /**
     * Get the current points in game
     * @return int Current points in the game
     */
    public int getPoints() {
        return points;
    }

    /**
     * Get the category selected by player
     * @return Category Current category selected by player
     */
    public Category getSelectedCategory() {
        return selectedCategory;
    }


    /**
     *  Setters
     */

    public void setCategory(String category) {
        selectedCategory = new Category(category);
    }


    /**
     *  Methods
     */

    /**
     * Instance of App to get access from other classes
     * @return An instance of the App to access from outside
     */
    public static App getInstance() {
        return instance;
    }

    /**
     * Ingrement points based on Config.CORRECT_POINTS
     * @see Config
     * @return
     */
    public int addPoints() {
        points = points + Config.CORRECT_POINTS;
        return points;
    }

    /**
     * Set a new scene from an fxml file
     * @param url of fxml file
     * @throws Exception
     */
    public void loadScene(String url) throws Exception {
        Parent root = (Parent) FXMLLoader.load(App.class.getResource(url), null, new JavaFXBuilderFactory());
        Scene scene = new Scene(root, Config.WIDTH, Config.HEIGHT);
        stage.setScene(scene);
    }

}
