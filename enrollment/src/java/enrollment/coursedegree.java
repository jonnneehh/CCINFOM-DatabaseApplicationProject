package enrollment;
import java.sql.*;

public class coursedegree {
    
    public  String  coursedegreeid ;          
    public  String  coursedegreename;
    
    public coursedegree () {};
    
    public int modRecord(String oldcourseid, String olddegree, String newcourseid, String newdegree) throws Exception { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Check if newcourseid and newdegree exists in courses and degree table.
        boolean newCourseExists = false, newDegreeExists = false; 
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
            String queryCourses = "select courseid from courses";
            String queryDegree = "select degreeid from degree";
            
            //Check if newcourseid exists
            ResultSet rs = st.executeQuery(queryCourses);
            while (rs.next() || newCourseExists){
                String result = rs.getString(1);
                if (newcourseid != null){
                    if(newcourseid.equals(result)){
                        newCourseExists = true;
                    }
                }
            }
            
            //Check if newdegree exists
            rs = st.executeQuery(queryDegree);
            while (rs.next() || newDegreeExists){
                String result = rs.getString(1);
                if (newdegree != null){
                    if(newdegree.equals(result)){
                        newDegreeExists = true; 
                    }
                }  
            }
            
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        //Modify Data
        if(newCourseExists || newDegreeExists){
            try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
                
                String queryDegree = "update coursedegree set degree='" + newdegree + "' where courseid ='" + oldcourseid + "' and degree='"+ olddegree + "'";
                String queryCourseID = "update coursedegree set courseid='"+ newcourseid + "' where courseid ='" + oldcourseid + "' and degree='" + olddegree + "'";
                
                if(newdegree != null){
                    st.executeUpdate(queryDegree);
                    System.out.println("Successfully changed the degree of " + oldcourseid + ", " + olddegree + " to " + newdegree);
                }
                    
                if(newcourseid != null){
                    st.executeUpdate(queryCourseID);
                    System.out.println("Successfully changed the courseID of " + oldcourseid + ", " + olddegree + " to " + newcourseid);
                }

                return 1;
            } catch (SQLException e){
                System.out.println("SQL Exception");
                e.printStackTrace();
                return 0;
            }
        } 
        else{
            System.out.println("Could not modify record. Neither courseid " + newcourseid + " nor degree " + newdegree + " exists in courses and degree table");
            System.out.println("No records were modified");
            return 0;
        }
    };
    
    public int delRecord(String courseid, String degree) throws Exception { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "delete from coursedegree where courseid=? and degree=?";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                PreparedStatement st = con.prepareStatement(query)) {
            
            st.setString(1, courseid);
            st.setString(2, degree);
            st.executeUpdate();
            
            System.out.println("Record " + courseid + " of " + degree + " deleted successfully");
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public int addRecord(String courseid, String degree) throws Exception{ 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "insert into coursedegree values (?,?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                PreparedStatement st = con.prepareStatement(query)) {
            
            st.setString(1, courseid);
            st.setString(2, degree);
            
            int count  = st.executeUpdate();
            
            System.out.println(count + " row/s affected");
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public int viewRecord() throws Exception{ 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "select * from coursedegree order by degree";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                String courseid = rs.getString("courseid");
                String degree = rs.getString("degree");
                
                System.out.println(courseid + "  " + degree );
            }
            
            rs.close();
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public static void main(String args[]) throws Exception{
       coursedegree c = new coursedegree();
       
       String courseid = "CCPROG2";
       String degree = "BSCS";
       String newcourseid = "ITISORG";
       String newdegree = "BSCS";
       
       c.modRecord(courseid, degree, newcourseid, null);
       c.viewRecord();
    }
}
