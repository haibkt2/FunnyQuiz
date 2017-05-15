package _DB_Quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _Funny_Quiz.ConnectionUtils;

@WebServlet("/_quizv2")
public class _quizv2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void getAll(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IOException {
		String sql = "SELECT quiz.quiz_id,quiz.quiz,quiz.question, quiz.description, quiz.image ,quiz.view,quiz._like,question.question_id,choices_ques.choice_id,question.question,choices_ques.choice FROM((question JOIN choices_ques ON question.question_id=choices_ques.question_id) JOIN quiz ON quiz.quiz_id = question.quiz_id) ORDER BY quiz.quiz_id,question.question_id,choices_ques.choice_id";
		System.out.println("okkkkk");
		Connection con = ConnectionUtils.getMyConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("KKK");
		StringBuffer jsonQuiz = new StringBuffer();
		jsonQuiz.append("{\"quizs\" : [");
		int idQuiz = 0;
		int idQues = 0;
		int idChoi = 0;
		while (rs.next()) {
			int id_quiz = rs.getInt(1);
			String quiz = rs.getString(2);
			String desc = rs.getString(4);
			int view = rs.getInt(6);
			int like = rs.getInt(7);
			int id_ques = rs.getInt(8);
			int id_choi = rs.getInt(9);
			String ques = rs.getString(10);
			String choie = rs.getString(11);
			if (idQuiz != id_quiz) {
				jsonQuiz.append("{\"id\":\"");
				jsonQuiz.append(id_quiz + "\",");
				jsonQuiz.append("\"quiz\":\"");
				jsonQuiz.append(quiz + "\",");
				jsonQuiz.append("\"description\":\"");
				jsonQuiz.append(desc + "\",");
				jsonQuiz.append("\"view\":\"");
				jsonQuiz.append(view + "\",");
				jsonQuiz.append("\"like\":\"");
				jsonQuiz.append(like + "\",");
				jsonQuiz.append("\"link_image\":\"");
				jsonQuiz.append("http://192.168.0.137:8080/Funny_Quiz/images/p" + id_quiz + ".jpg" + "\",");
				jsonQuiz.append("\"questions\":[");
				idQuiz = id_quiz;
			}
			if (idQues != id_ques) {
				jsonQuiz.append("{\"id\":\"");
				jsonQuiz.append(id_ques + "\",");
				jsonQuiz.append("\"question\":\"");
				jsonQuiz.append(ques + "\",");
				jsonQuiz.append("\"link_image\":\"");
				jsonQuiz.append("http://192.168.0.137:8080/Funny_Quiz/images/p" + id_ques + ".jpg" + "\",");
				jsonQuiz.append("\"choices\":[");
				idQues = id_ques;
			}
			if (idChoi != id_choi) {
				jsonQuiz.append("{\"id\":\"");
				jsonQuiz.append(id_choi + "\",");
				jsonQuiz.append("\"choice\":\"");
				jsonQuiz.append(choie + "\"}");
				if(id_choi !=2) jsonQuiz.append(",");
				if(id_choi==2){
					jsonQuiz.append("]}");
					if(id_ques == 10) jsonQuiz.append("]}");
					if(id_ques!=20) jsonQuiz.append(",");
				}
				idChoi = id_choi;
			}
			
		}
		jsonQuiz.append("]}]}");
		PrintWriter out = resp.getWriter();
		out.println(jsonQuiz);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_quizv2 quizv2 = new _quizv2();
		try {
			quizv2.getAll(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
