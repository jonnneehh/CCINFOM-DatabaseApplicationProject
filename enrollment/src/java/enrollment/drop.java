/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class drop {
  
    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<enrollment>    DropList        = new ArrayList<> ();

    public drop() {};                                   // perform all the necessary data loading from DB
    public int clearDrop (){
        
        EnrollmentList.clear();
        DropList.clear();
        
        return 1;  
    }   // clears dropping data of the student
    public int loadEnrollment (int studentid, String courseid, int term, int schoolyear)    {
        
        enrollment e_temp = new enrollment();
        
        e_temp.studentid = studentid;
        e_temp.courseid = courseid;
        e_temp.term = term;
        e_temp.schoolyear = schoolyear;
    
        EnrollmentList.add(e_temp);
        return 1;
    }   // load enrollment data of the student 
    public int confirmDrop()  {  
        Student.viewRecord();
        try{
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, term, schoolyear FROM enrollment WHERE studentid =?");
            pstmt.setInt(1, Student.studentid);
            // 5. Supply the statement with values
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();   
            
            // 7. Get the results
            clearDrop();
            
            while (rs.next()) {
                enrollment d_temp = new enrollment();
                d_temp.courseid = rs.getString("courseid");
                d_temp.term = rs.getInt("term");
                d_temp.schoolyear = rs.getInt("schoolyear");
                d_temp.studentid = Student.studentid;
                DropList.add(d_temp);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
        }catch(SQLException e){
             System.out.println(e.getMessage());
            return 0;
      }   // saves dropping data into the Database
    
    }
    public static void main(String args[]) {
        enroll e = new enroll();
        e.Student.studentid = 10100013;
        e.Student.completename = "Jego Lazaro";
        e.Student.degreeid = "CS-ST";
        e.Student.addRecord();
    }
}
