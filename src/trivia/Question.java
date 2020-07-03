package trivia;

/**
 * Question object
 */
public class Question {

    private String sentence;
    private String[] answerOptions;
    private String selectedOption;
    private int correctOption;
    private boolean asserted;


    /**
     * Question constructor
     * @param sentece The sentence of the question
     * @param answerOptions Posible ansers to question
     * @param correctOption The correct answer for question
     */
    public Question (String sentece, String[] answerOptions, int correctOption) {
        this.sentence = sentece;
        this.answerOptions = answerOptions;
        this.correctOption = correctOption;
    }


    /**
     * Get the sentence of question
     * @return String sentence of the question
    */
    public String getSentece() {
        return sentence;
    }

    /**
     * Get the posible aswers of question
     * @return String[] of posible asnwers
     */
    public String[] getAnswerOptions() {
        return answerOptions;
    }

    /**
     * Get the option selected by player
     * @return String of selected option by player
     */
    public String getSelectedOption() {
        return selectedOption;
    }


    /**
     * Set selected option by player
     * @param selectedOption
     */
    public void setAnswer(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    /**
     * Check if the answer is correct
     * @param selectedOption
     * @return
     */
    public boolean validateAnswer(String selectedOption) {
        setAnswer(selectedOption);
        if (selectedOption == answerOptions[correctOption]) {
            asserted = true;
        }
        else {
            asserted = false;
        }
        return asserted;
    }

}
