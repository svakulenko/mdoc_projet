package dbHandlers;

import java.sql.*;



public class dbController {

	String dbname = "test";
	String url = "jdbc:mysql://localhost:3306/" + dbname;
	String login = "3151569";
	String pwd   = "";
	
	Connection con;

	public boolean connectionExist() {
		if (con == null)
			System.out.println("error, no connection!");
		return con != null;
	}

	public void  updateStatement(String sql_query) throws SQLException {
		System.out.println(sql_query);
		Statement st = con.createStatement();
		st.executeUpdate(sql_query);
		if (st != null) {
			st.close();
		}

 
	}

	public boolean checkIfRecordExist(Integer id) throws SQLException {
		boolean retValue = false;
		if (connectionExist()) {
		//check if id exist in table
		String sql_query = "SELECT * FROM contact WHERE id="
				+ id.toString();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_query);

		
		if (rs.next())
			retValue= true;//row exist
		rs.close();
		st.close();

		
		}
		return retValue;
	}
	
	
		
	
	public boolean addContact(Integer id, String FirstName, String LastName,
			String Email) throws SQLException {
		if (connectionExist()) {
	
			String sql_query = "INSERT INTO contact" + " VALUES ("
					+ id.toString() + ",'" + FirstName + "','" + LastName
					+ "','" + Email + "')";
			updateStatement(sql_query);
			
			return true;

		}
		return false;
	}

	public boolean removeContact(Integer id) throws SQLException {
		boolean retValue = true;
		if (connectionExist()) {
			String sql_query = "DELETE FROM contact WHERE id=" + id.toString();
			updateStatement(sql_query);
		}
		return retValue;
	}

	public void updateContact(Integer id, String FirstName, String LastName,
			String Email) throws SQLException {
		if (connectionExist()) {
			String sql_query = "UPDATE contact " + "SET " + " ," + "firstName="
					+ FirstName + " ," + "lastName=" + LastName + " ,"
					+ "email=" + Email + " WHERE id=" + id.toString();
			updateStatement(sql_query);

		}
	}

//	public String getContact(Integer id) throws SQLException {
//		String rvalue = null;
//		if (connectionExist()) {
//			String sql_query = "SELECT * FROM contact WHERE id="
//					+ id.toString();
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql_query);
//			List<Contact> lst = new ArrayList<Contact>();
//			while (rs.next()) {
//				Integer ID = rs.getInt("id");
//				String FirstName = rs.getString("firstName");
//				String LastName = rs.getString("lastName");
//				String Email = rs.getString("email");
//
//				lst.add(new Contact(ID, FirstName, LastName, Email));
//			}
//			System.out.println("lst.size()=" + lst.size() + ", rvalue=" + rvalue);
//			if (lst.size() > 0)
//				rvalue = serverUtils.generateTable(lst);
//			
//
//			if(rs != null)
//				rs.close();
//			if (st != null)
//				st.close();
//		}
//		return rvalue;
//	}

	public boolean getConnection() {
		try {
			System.out.println("invoke mysql driver .. ");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Good to go");



			con = DriverManager.getConnection(url, login, pwd);
			
			System.out.println("::getConnection we have  connection!");

			// addContact(1, "sergey", "vakulenko", "s@set.net");
			// removeContact(1);
			return true;
		} catch (Exception E) {
			E.printStackTrace();

		}
		return false;
	}
	public void closeConnection() throws SQLException{
		if (con != null)
			con.close();
		
		System.out.println("::closeConnection no more connection");
	}

}
