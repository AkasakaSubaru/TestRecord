package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyAcountBean;

@WebServlet("/new_ac")

public class new_ac extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = null;
		String name = request.getParameter("new_name");
		String id = request.getParameter("new_id");
		String pw = request.getParameter("new_pw");
		String pw2 = request.getParameter("ag_new_pw");
		if(!pw.equals(pw2) || name == null || id == null || pw == null || pw2 == null) {
			url = "new_ac.jsp";
			String error = "error";
			request.setAttribute("error",error);
		}else {
			MyAcountBean ab = new MyAcountBean(name,id,pw);
			if(!ab.getLogin()) {
				url = "new_ac.jsp";
				String error = "error";
				request.setAttribute("error", error);
			}else {
				url = "login.jsp";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
