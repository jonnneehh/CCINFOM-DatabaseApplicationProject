package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
 
    public enroll() {};                                 // perform all the necessary data loading from DB
    public int clearEnrollment ()   {   return 0;   }   // clears enrollment data of the student 
    public int loadCourses ()       {   return 0;   }   // load valid courses into the course list
    public int confirmEnrollment()  {   return 0;   }   // saves enrollment data into the Database
    
}
