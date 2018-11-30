package contoroller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		UserDao userDao = new UserDao();
		try {
			User user = userDao.findByLoginInfo(id);

			request.setAttribute("userUpdate", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao userDao = new UserDao();

		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("userName");
		String birthDate = request.getParameter("birthDate");


		//入力ミスの条件文
		if( name.equals("") || password.equals("") || birthDate.equals("")|| !(password.equals(password2))){
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// ログインjspにフォワード
			doGet(request, response);
			//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			//dispatcher.forward(request, response);
			return;
		}

		userDao.updateuser(name,password,birthDate,id);


		response.sendRedirect("UserListServlet");
	}
}

