package trivia;

import java.util.ArrayList;

/**
 * Category of questions in Trivia
 */
public class Category {

    private String name;
    private ArrayList<Question> questions;


    public Category(String name) {
        this.name = name;
        this.questions = new ArrayList<Question>();
        loadQuestions();
    }


    /**
     *  Get category name
     * @return String Name of category
     */
    public String getName() {
        return name;
    }

    /**
     * Get questions
     * @return ArrayList of questions in category
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Load questions for category from text file
     */
    private void loadQuestions() {
        /* TODO: load questions from text file */
        for (int i = 1; i <= 5; i++) {
            String questionName = i + ". Enunciado de pregunta número " + i;
            String[] options = {"Respuesta a", "Respuesta b", "Respuesta c"};
            questions.add(new Question(questionName, options, 1));
        }
    }

}
