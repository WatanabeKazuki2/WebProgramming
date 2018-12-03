package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import contoroller.UserEntryServlet;
import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public User findByLoginInfo(String loginId, String password) throws NoSuchAlgorithmException {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
          //ハッシュを生成したい元の文字列
            String source = password;
            //ハッシュ生成前にバイト配列に置き換える際のCharset
            Charset charset = StandardCharsets.UTF_8;
            //ハッシュアルゴリズム
            String algorithm = "MD5";

            //ハッシュ生成処理
            byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
            String result = DatatypeConverter.printHexBinary(bytes);

            pStmt.setString(2, result);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int id = rs.getInt("id");
            loginId= rs.getString("login_id");
            String name = rs.getString("name");
            return new User(id,loginId, name);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }



    public User findByLoginInfo(String loginId) throws NoSuchAlgorithmException {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int id = rs.getInt("id");
            loginId = rs.getString("login_id");
            String name = rs.getString("name");

            return new User(id,loginId, name);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public User findByLoginInfo(int id) throws NoSuchAlgorithmException {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginId = rs.getString("login_id");
            String name = rs.getString("name");
            Date birthDate = rs.getDate("birth_date");
            String password = rs.getString("password");
            String createDate = rs.getString("create_date");
            String updateDate = rs.getString("update_date");
            return new User(id, loginId, name, birthDate, password, createDate, updateDate);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public void updateByLogin(String name,String password,String birthDate,int id) {
  		 // データベースへ接続
    }


    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する


            String sql = "SELECT * FROM user WHERE id != 1 ";


             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");

                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }


    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll(String loginIdData,String nameData,Date birthDateData) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する


            String sql = "SELECT * FROM user WHERE id != 1 ";

            if(!loginIdData.isEmpty()) {
            	sql += ",login_id="+loginIdData ;
            }

            if(!nameData.isEmpty()) {
            	sql += ",name %"+ nameData + "%";
            }

            if(birthDateData.isEmpty()) {

            }

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");

                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }


    public void entlyUser() {

    }

    //更新用メソッド
	public void updateuser(String name, String password, String birthDate, int id) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn =  DBManager.getConnection();


		//UPDATE文を準備
		String sql =  "UPDATE user SET name = ?,password = ?,birth_date=?,update_date = now() WHERE id = ?";


		try {
			//UPDATE文に値をセット
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, UserEntryServlet.angou(password));
			pStmt.setString(3, birthDate);
			pStmt.setInt(4, id);

			pStmt.executeUpdate();

			pStmt.close();
		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}



	//新規作成用メソッド
	public void entlyUser(String loginId, String name, String birthDate, String password) {
		try {

			Connection conn = DBManager.getConnection();


			//INSERT文を準備
			String sql = "INSERT INTO user (login_id ,name,birth_date,password,create_date,update_date)VALUES(?,?,?,?,now(),now())";

			//INSERT文に内容を入れる
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, UserEntryServlet.angou(password));


			pStmt.executeUpdate();

			pStmt.close();
		}catch(SQLException | NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}


	//削除用メソッド
	public void userDelete(int id) {
		//DBへ接続
		Connection conn = DBManager.getConnection();

		//DELETE文
		String sql = "DELETE FROM user WHERE id = ?";

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,id);

			pStmt.executeUpdate();

			pStmt.close();
		}catch(SQLException e) {
		}
	}
}

