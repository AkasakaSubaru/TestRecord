package bean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDBBean implements Serializable{
	private List<String> name_list = new ArrayList<String>();
	private List<Integer> ja_list = new ArrayList<Integer>();
	private List<Integer> mo_list = new ArrayList<Integer>();
	private List<Integer> so_list = new ArrayList<Integer>();
	private List<Integer> sc_list = new ArrayList<Integer>();
	private List<Integer> en_list = new ArrayList<Integer>();
	private boolean login;
	private String name;
	public MyDBBean() {
	}
	public MyDBBean(String id,String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:0000/test?user=root&password=root");
		    Statement state = conn.createStatement();
		    String sql = "SELECT * FROM users, test_num WHERE users.id = test_num.id AND users.id = '" + id + "' AND users.pw='" + pw + "'";
		    ResultSet rs = state.executeQuery(sql);
		    if(rs.next()) {
		        String test_name = rs.getString(7);
	            int ja = rs.getInt(8);
	            int mo = rs.getInt(9);
	            int so = rs.getInt(10);
	            int sc = rs.getInt(11);
	            int en = rs.getInt(12);
	            ja_list.add(ja);
	            name_list.add(test_name);
	            mo_list.add(mo);
                so_list.add(so);
		        sc_list.add(sc);
		        en_list.add(en);
			    while(rs.next()) {
			        String Test_name = rs.getString(7);
		            int Ja = rs.getInt(8);
		            int Mo = rs.getInt(9);
		            int So = rs.getInt(10);
		            int Sc = rs.getInt(11);
		            int En = rs.getInt(12);
		            ja_list.add(Ja);
		            name_list.add(Test_name);
		            mo_list.add(Mo);
                    so_list.add(So);
			        sc_list.add(Sc);
			        en_list.add(En);
		        }
		    }
		    sql = "SELECT name FROM users WHERE id= '" + id + "' AND pw= '" + pw + "'";
		    rs = state.executeQuery(sql);
		    rs.next();
		    name = rs.getString(1);
		    login = true;
		    rs.close();
		    state.close();
		    conn.close();
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("Eroor");
			login = false;
		}
		System.out.println(name_list.size());
	}
	public ArrayList<String> getTest_name() {
		return (ArrayList<String>) name_list;
	}
	public ArrayList<Integer> getJa_list(){
		return (ArrayList<Integer>) ja_list;
	}
	public ArrayList<Integer> getMo_list(){
		return (ArrayList<Integer>) mo_list;
	}
	public ArrayList<Integer> getSo_list(){
		return (ArrayList<Integer>) so_list;
	}
	public ArrayList<Integer> getSc_list(){
		return (ArrayList<Integer>) sc_list;
	}
	public ArrayList<Integer> getEn_list(){
		return (ArrayList<Integer>) en_list;
	}
	public boolean getLogin() {
		return login;
	}
	public String getName() {
		return name;
	}

}
