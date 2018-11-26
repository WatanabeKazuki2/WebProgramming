package contoroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserEntryServlet
 */
@WebServlet("/UserEntryServlet")
public class UserEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEntryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメーターの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメーターの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String birthday = request.getParameter("birthday");

		//リクエストパラメーターの入力項目を引数に渡して、Daoのメソッドを実行
		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo(loginId, password);
	}

}
