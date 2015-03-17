package hello;
import java.sql.*;


public class DB {
		private static DB db;
		
		static{
			db=new DB();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		private DB(){};
		public static Connection getConn(){
			Connection conn=null;
			try{
				conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?"
						+ "user=root&password=yeapp123");
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			 return conn;
		}
		
		public static void closeConection(Connection conn){
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
			
		}
		
		public static Statement getstmt(Connection conn){
			if(conn!=null){
				Statement stmt=null;
				try {
					stmt = conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return stmt;
			}
			return null;
		}
		public static void closeStmt(Statement stmt){
			
			try {
				if(stmt!=null)
				stmt.close();
				stmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public static PreparedStatement getPstmt(Connection conn,String sql){
			if(conn!=null){
				PreparedStatement pstmt=null;
				try {
					pstmt =conn.prepareStatement(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return pstmt;
			}
			return null;
		}
		
		public static ResultSet returnRS(Statement stmt,String sql){
			ResultSet rs=null;
			try{
				if(stmt!=null)
				stmt.executeQuery(sql);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
		
		
public static void closeStmt(ResultSet rs){
			
			try {
				if(rs!=null)
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
}
