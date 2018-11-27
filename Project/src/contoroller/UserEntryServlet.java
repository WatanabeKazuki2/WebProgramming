package contoroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;

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
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserEntry.jsp");
		dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメーターの文字コードを指定
		request.setCharacterEncoding("UTF-8");


		//jspのデータをセット
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String birthDate = request.getParameter("birthDate");

		Connection connn = null;
		try {
		//データベースへ接続
		connn = DBManager.getConnection();

		//INSERT文を準備
		String sql = "INSERT INTO user (login_id ,name,birth_date,password,create_date,update_date)VALUES(?,?,?,?,now(),now())";

		//INSERT文に内容を入れる
		PreparedStatement pStmt = connn.prepareStatement(sql);
		pStmt.setString(1, loginId);
		pStmt.setString(2, name);
		pStmt.setString(3, birthDate);
		pStmt.setString(4, password);


		pStmt.executeUpdate();

		pStmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		response.sendRedirect("UserListServlet");
	}

}
