package hello;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/employee")
    public employee greeting(@RequestParam(value="name", defaultValue="123") String name,
    						 @RequestParam(value="company", defaultValue="ICC") String company
    						 
    		) {
    	int id = 0;
		String Name=null;
		String email=null;
    	Connection conn=null;
    	employee employees[]=null;
    	
    	Statement stmt=null;
        ResultSet rs=null;
        
    	try{
    		conn=DB.getConn();
    		stmt=conn.createStatement();
    		rs=stmt.executeQuery("select * from Users where Uname="+name);
    		
    		if(rs.next()){
    			id=rs.getInt("id");
    			Name=rs.getString("UName");
    			email=rs.getString("eamil");
    			
    		}
    	}catch(SQLException e){
    		e.printStackTrace();	
    	}finally{
    		try {
				rs.close();
				stmt.close();
	    		conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    	}
        List<employee> em= new ArrayList<employee>();
    	em.add(new employee(id,Name,email));
    	em.add(new employee(id,Name,email));
    	System.out.println("vistor");
    	return new employee(id,Name,email);
    }
}
