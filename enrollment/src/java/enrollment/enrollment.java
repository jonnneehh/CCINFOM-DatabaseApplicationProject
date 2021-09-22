package enrollment;
import java.sql.*;

public class enrollment {
    
    public int studentid;
    public String courseid;
    public int term;
    public int schoolyear;
    
    public enrollment () {};
    public int modRecord()  {
           try {
    		// 1. Instantiate a connection variable
    		Connection conn;
    		// 2. Connect to your DB
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345");
    		// 3. Indicate a notice of successful connection
    		System.out.println("Connection successful!");
    		// 4. Prepare our INSERT Statement
    		PreparedStatement pstmt = conn.prepareStatement("UPDATE enrollment SET courseid=?, term=?, schoolyear=? WHERE studentid =?");
    		// 5. Supply the statement with values
    		pstmt.setString(1, courseid);
    		pstmt.setInt(2, term);
    		pstmt.setInt(3, schoolyear);
                pstmt.setInt(4, studentid);
    		// 6. Execute the SQL Statement
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    		return 1;
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    		return 0;
    	}
    };
    public int delRecord()  {
        try {
    		// 1. Instantiate a connection variable
    		Connection conn;
    		// 2. Connect to your DB
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345");
    		// 3. Indicate a notice of successful connection
    		System.out.println("Connection successful!");
    		// 4. Prepare our INSERT Statement
    		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM enrollment WHERE studentid=?");
    		// 5. Supply the statement with values
    		pstmt.setInt(1, studentid);
    		// 6. Execute the SQL Statement
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    		return 1;
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    		return 0;
    	}
    }
    public int addRecord()  {
        try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO enrollment VALUES (?,?,?,?)");
            // 5. Supply the statement with values
            pstmt.setInt    (1, studentid );
            pstmt.setString (2, courseid);
            pstmt.setInt    (3, term);
            pstmt.setInt    (4, schoolyear);
            // 6. Execute the SQL Statement
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        } 
    }
    public int viewRecord() {
        try {
    		// 1. Instantiate a connection variable
    		Connection conn;
    		// 2. Connect to your DB
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345");
    		// 3. Indicate a notice of successful connection
    		System.out.println("Connection successful!");
    		// 4. Prepare our INSERT Statement
    		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enrollment WHERE studentid=?");
    		// 5. Supply the statement with values
    		pstmt.setInt(1, studentid);
    		// 6. Execute the SQL Statement
    		ResultSet rs = pstmt.executeQuery();
    		
    		// 7. Get the results
    		while (rs.next()) {
    			studentid = rs.getInt("studentid");
                        courseid = rs.getString("courseid");
                        term = rs.getInt("term");
                        schoolyear = rs.getInt("schoolyear");
    		}
    		
    		rs.close();
    		pstmt.close();
    		conn.close();
    		return 1;
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    		return 0;
    	}
    }
    
    public static void main(String args[]) {
       
    }
}
