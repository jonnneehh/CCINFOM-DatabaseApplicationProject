package enrollment;
import java.sql.*;

public class courses {
    
    public courses () {};
    public int modRecord(String oldcourseid, String newcourseid, String newcoursename, String newdepartment) throws Exception { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
            
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
            
            String queryCourseName = "update courses set coursename="+ newcoursename + " where course_id in ('" + oldcourseid + "')";
            String queryDepartment = "update courses set department="+ newdepartment + " where course_id in ('" + oldcourseid + "')";
            String queryCourseID = "update courses set courseid="+ newcourseid + " where course_id in ('" + oldcourseid + "')";
            
            if(newcoursename != null)
                st.executeQuery(queryCourseName);
            
            if(newdepartment != null)
                st.executeQuery(queryDepartment);
            
            if(newcourseid != null)
                st.executeQuery(queryCourseID);
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public int delRecord(String courseid) throws Exception  { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "delete from enrolldb where courseid=?";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                PreparedStatement st = con.prepareStatement(query)) {
            
            st.setString(1, courseid);
            st.executeUpdate();
            
            System.out.println("Record " + courseid + " deleted successfully");
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public int addRecord(String courseid, String coursename, String department) throws Exception  { 
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
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public int viewRecord() throws Exception{ 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "p@ssword";
        
        String query = "select * from courses order by courseid";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                String courseid = rs.getString("courseid");
                String coursename = rs.getString("coursename");
                String department = rs.getString("department");
                
                System.out.println(courseid + "  " + coursename + "  " + department);
            }
            
            rs.close();
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    };
    
    public static void main(String args[]) {
        
    }
}