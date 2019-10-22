package bean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTestBean implements Serializable{
	private boolean login;
	public MyTestBean(){
	}
	@SuppressWarnings("resource")
	public MyTestBean(String id,String pw,String te_name,String ja_num,String ma_num,String so_num,String si_num,String en_num) {
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:0000/test?user=root&password=root");
			state = conn.createStatement();
			    if(id == "No ID") {    //idの入力がない場合
				    String sql = "SELECT id FROM users WHERE pw='" + pw +  "'";
				    rs = state.executeQuery(sql);
				    if(rs.next()) {
					    id = rs.getString(1);
				    }
			    }

			String sql = "INSERT INTO test_num (id,pw,test_name,japanese,math,society,science,english) VALUES('" + id + "','" + pw + "','" + te_name + "'," + Integer.parseInt(ja_num) + "," + Integer.parseInt(ma_num) + ","
	    		      + Integer.parseInt(so_num) + "," + Integer.parseInt(si_num) + "," + Integer.parseInt(en_num)+ ")";
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
				rs.close();
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
