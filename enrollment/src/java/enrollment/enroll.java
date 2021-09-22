package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();

    public ArrayList<courses>       CourseList      = new ArrayList<> ();
    
    public enroll() {					// perform all the necessary data loading from DB
        EnrollmentList.clear();
        CourseList.clear();
    }  
    
    public int resetEnroll() {		// clears all enrollment in memory
    	EnrollmentList.clear();
    	return 1;
    }
    
//    public int clearEnrollment ()   {   // clears enrollment data of the student  
//      EnrollmentList.clear();  
//    	return 1;
//    }
    
    public int loadCourses () throws Exception{   // load valid courses into the course list
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "12345";
        
        String query = "SELECT * FROM courses";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try(Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()){
            
            ResultSet rs = st.executeQuery(query); 

            CourseList.clear();
            while (rs.next()) {
                courses c 	= new courses();
                c.setCourseid(rs.getString("courseid"));
                CourseList.add(c);
            }
            rs.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }   
    }

    public int submitEnroll()  {   // saves enrollment data into the Database
        try {
            for (int i = 0; i < EnrollmentList.size(); i++) {
                EnrollmentList.get(i).addRecord();
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
    
    public static void main(String args[]) throws Exception {
       enroll e = new enroll();
       
       e.EnrollmentList.add(new enrollment(10100005, "ISINFOM", 2, 20192020));
       System.out.println(e.EnrollmentList.size());
       e.submitEnroll();
    }
}
