package Result;
import java.util.HashMap;

/**
 * Created by MyComputer on 5/14/2017.
 */
public class Result {
    private int idQuiz;
    HashMap<Integer, Integer> questions;

    public Result() {
        questions = new HashMap<>();
    }

    public void setQuestion(Integer idQuestion, Integer idChoice) {
        questions.put(idQuestion, idChoice);
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

	public HashMap<Integer, Integer> getQuestions() {
		return questions;
	}

	public void setQuestions(HashMap<Integer, Integer> questions) {
		this.questions = questions;
	}
}
