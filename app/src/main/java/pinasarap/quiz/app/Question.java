package pinasarap.quiz.app;

public class Question {
    private String image,correct,text,ans1,ans2,ans3;

    public Question(String image, String correct, String text, String ans1, String ans2, String ans3) {
        this.image = image;
        this.correct = correct;
        this.text = text;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
    }

    public String getImage() {
        return image;
    }

    public String getCorrect() {
        return correct;
    }

    public String  getText() {
        return text;
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

}
