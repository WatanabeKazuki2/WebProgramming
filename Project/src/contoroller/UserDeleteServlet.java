package contoroller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインセッションがない場合ログイン画面にリダイレクト
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("LoginServlet");
		}else {

			int id = Integer.parseInt(request.getParameter("id"));
			UserDao userDao = new UserDao();
			try {
				User user = userDao.findByLoginInfo(id);

				request.setAttribute("userDelete", user);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDelete.jsp");
				dispatcher.forward(request, response);

			}catch(NoSuchAlgorithmException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		UserDao userDao = new UserDao();
		userDao.userDelete(id);

		response.sendRedirect("UserListServlet");
		//doGet(request, response);
	}

}
