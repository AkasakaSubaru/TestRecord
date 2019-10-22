package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyTestBean;


@WebServlet("/new_ts")

public class new_ts extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String url = null;
		String id = request.getParameter("add_id");
		String pw = request.getParameter("add_pw");
		String te_name  = request.getParameter("test_name");
		String ja_num = request.getParameter("ja_num");
		String ma_num = request.getParameter("ma_num");
		String so_num = request.getParameter("so_num");
		String si_num = request.getParameter("si_num");
		String en_num = request.getParameter("en_num");
		try {
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);

			if(id == "" | pw =="" | te_name == "") {
				System.out.println("----追加の試みを検知----");
				System.out.println("登録失敗の理由 :  id、pw、te_nameが空白だったから");
				url = "new_ts.jsp";
				request.setAttribute("null","");
			}else {
			    if(ja_num == "") {
				    ja_num = "0";
			    }
			    if(ma_num == "") {
			    	ma_num = "0";
			    }
			    if(so_num == "") {
			    	so_num = "0";
			    }
			    if(si_num == "") {
			    	si_num = "0";
			    }
			    if(en_num == "") {
			    	en_num ="0";
			    }
			    MyTestBean mt = new MyTestBean(id,pw,te_name,ja_num,ma_num,so_num,si_num,en_num);
				if(!mt.getLogin()) {
					url = "new_ts.jsp";
				}else {
					url = "login.jsp";
				}
			}
		}catch(NullPointerException e){
			url = "login.jsp";
			request.setAttribute("miss", "");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}