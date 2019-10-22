package bean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyAcountBean implements Serializable{
	private boolean login;
	public MyAcountBean(){
	}
	public MyAcountBean(String name,String id,String pw) {
		Connection conn = null;
		Statement state = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:8889/test?user=root&password=root");
			state = conn.createStatement();
			String sql = "INSERT INTO users (id,pw,name) VALUES ('"+ id + "','" + pw + "','" + name + "')";
			state = conn.prepareStatement(sql);
			if(state.executeUpdate(sql) > 0) {
				//登録完了
				System.out.println("-------登録を感知-------");
				login = true;
			}else {
				//登録失敗
				System.out.println("!!!!!!!登録失敗!!!!!!!");
				login = false;
			}
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("!!!!!!!データーベースエラー!!!!!!!");
			login = false;
			e.printStackTrace();
		}finally {
			try {
		    state.close();
		    conn.close();
			}catch(SQLException e){
				System.out.println("!!!!!!!colose処理失敗!!!!!!!");
				login = false;
				e.printStackTrace();
			}
		}
	}
	public boolean getLogin() {
		return login;
	}
}