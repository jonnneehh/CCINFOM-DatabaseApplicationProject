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
    public int clearDrop ()         {   return 0;   }   // clears dropping data of the student
    public int loadEnrollment ()    {   return 0;   }   // load enrollment data of the student 
    public int confirmDrop()        {   return 0;   }   // saves dropping data into the Database
    
}
