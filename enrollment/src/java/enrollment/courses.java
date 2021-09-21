package enrollment;
import java.sql.*;

public class courses {
    
    public courses () {};
    public int modRecord(String oldcourseid, String newcourseid, String newcoursename, String newdepartment) throws Exception { 
        int success = 0;
        
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String query = "select * from enrolldb where course_id=" + oldcourseid;
            
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
            
            ResultSet rs = st.executeQuery(query);
                    
            String oldcoursename = rs.getString("coursename"),
                   olddepartment = rs.getString("department");
            
            String queryCourseID = "update courses set courseid="+ newcourseid + " where course_id in ('" + oldcourseid + "')";
            String queryCourseName = "update courses set coursename="+ newcoursename + " where course_id in ('" + oldcourseid + "')";
            String queryDepartment = "update courses set department="+ newdepartment + " where course_id in ('" + oldcourseid + "')";
            
            if(newcourseid != null)
                st.executeQuery(queryCourseID);
            
            if(newcoursename != null)
                st.executeQuery(queryCourseName);
            
            if(newdepartment != null)
                st.executeQuery(queryDepartment);
            
            success = 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return success; 
    };
    
    public int delRecord(String courseid) throws Exception  { 
        int success = 0;
        
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "delete from enrolldb where courseid=?";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                PreparedStatement st = con.prepareStatement(query)) {
            
            st.setString(1, courseid);
            st.executeUpdate();
            
            System.out.println("Record " + courseid + " deleted successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return success; 
    };
    
    public int addRecord(String courseid, String coursename, String department) throws Exception  { 
        int success = 0;
        
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "insert into courses values (?,?,?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(url, un, pw); 
                PreparedStatement st = con.prepareStatement(query)) {
            
            st.setString(1, courseid);
            st.setString(2, coursename);
            st.setString(3, department);
            
            int count  = st.executeUpdate();
            
            System.out.println(count + " row/s affected");
            
            success = 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return success; 
    };
    
    public int viewRecord() { return 0; };
    
    public static void main(String args[]) {
        
    }
}
