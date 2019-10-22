package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyDBBean;

 @WebServlet("/login")

public class home extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = null;
		List<String> name_list = new ArrayList<String>();
		List<Integer> ja_list = new ArrayList<Integer>();
		List<Integer> mo_list = new ArrayList<Integer>();
		List<Integer> so_list = new ArrayList<Integer>();
		List<Integer> sc_list = new ArrayList<Integer>();
		List<Integer> en_list = new ArrayList<Integer>();
		String id = request.getParameter("id");
		String pw = request.getParameter("pass");
		String name;
		try {
			if(id == null | pw == null) {
				url = "login.jsp";
			}else {
			    MyDBBean mb = new MyDBBean(id,pw);
			    if(!mb.getLogin()) {
			    	url = "login.jsp";
			    }else{
			        name_list = mb.getTest_name();
			        ja_list = mb.getJa_list();
			        mo_list = mb.getMo_list();
			        so_list = mb.getSo_list();
			        sc_list = mb.getSc_list();
			        en_list = mb.getEn_list();
			        request.setAttribute("name_list",name_list);
			        request.setAttribute("ja_list", ja_list);
			        request.setAttribute("mo_list", mo_list);
			        request.setAttribute("so_list", so_list);
			        request.setAttribute("sc_list", sc_list);
			        request.setAttribute("en_list", en_list);
			        url = "WEB-INF/jsp/home.jsp";
			        name = mb.getName();
			        request.setAttribute("name",name);
			    }
			}
		}catch(Exception e) {
			url =  "login.jsp";
			System.out.println("catch");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}