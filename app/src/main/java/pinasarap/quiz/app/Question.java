package pinasarap.quiz.app;

public class Question {
    private String image,correct;

    public Question(String image, String correct) {
        this.image = image;
        this.correct = correct;
    }

    public String getImage() {
        return image;
    }

    public String getCorrect() {
        return correct;
    }

}
