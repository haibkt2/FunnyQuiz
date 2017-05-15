package Result;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
@WebServlet("/_ShowResult")
public class _ShowResult extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Result result;
	public void Handle(String json){
		Gson gson = new Gson();
		this.result = gson.fromJson(json, Result.class);
		System.out.println(result.getIdQuiz());
		System.out.println(result.getQuestions());
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ggg");
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mgs = "hhh";
		System.out.println("chi");
//		req.setAttribute("result", mgs);
		String json = "{\"quiz\":[{\"idQuiz\":\"1\"},{\"questions\":\"4\",\"idchoice\":\"2\"},{\"questions\":\"4\",\"idchoice\":\"2\"},{\"questions\":\"4\",\"idchoice\":\"2\"}]}";
		PrintWriter out = resp.getWriter();
		Handle(json);
		out.println("co");
	}

}
