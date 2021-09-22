package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
 
    public enroll() {					// perform all the necessary data loading from DB
        EnrollmentList.clear();
        CourseList.clear();
    };  
    
    public int resetEnroll() {			// clears all enrollment in memory
    	EnrollmentList.clear();
    	return 1;
    }
    
//    public int clearEnrollment ()   {   // clears enrollment data of the student  
//      EnrollmentList.clear();  
//    	return 1;
//    }
    
    public int loadCourses ()       {   // load valid courses into the course list
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses"); // Edit
            // 5. Supply the statement with values
            ResultSet rs = pstmt.executeQuery(); 
            
            // 6. Execute the SQL Statement  
            // 7. Get the results
            CourseList.clear();
            while (rs.next()) {
                coursedegree CD 	= new coursedegree();
//                CD.coursedegreeid 	= rs.getString("courseid");
//                CD.coursedegreename     = rs.getString("degree");
                CourseList.add(CD);
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

    public int submitEnroll()  {   // saves enrollment data into the Database
        try {
            Student.addRecord();     
            
            for (int i = 0; i < EnrollmentList.size(); i++) {
                // Retrieve every orderdetails stored in the ArrayList
                orderdetails odrecord = new orderdetails();
                odrecord = (orderdetails)OD.get(i);

                // Retrieve product record to update the quantity
                products precord = new products();
                precord.pcode = odrecord.pcode;
                precord.viewRecord();
                precord.qty   = precord.qty - odrecord.qty;
                
                // Update the Database
                odrecord.addRecord();
                precord.modRecord();
            }
            return 1;
         } catch (Exception e) {
             System.out.println(e.getMessage());  
             return 0;               
         }     
    }
    
//    public int confirmEnrollment()  {   // saves enrollment data into the Database
//    	return 1;
//    }
    
}
