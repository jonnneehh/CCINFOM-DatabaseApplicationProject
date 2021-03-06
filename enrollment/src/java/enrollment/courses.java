package enrollment;
import java.sql.*;

public class courses {
    
    private String courseid;
    private String coursename;
    private String department;
    
    public courses () {};
    public int modRecord(String oldcourseid, String newcourseid, String newcoursename, String newdepartment) throws Exception { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "12345";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
            
        try (Connection con = DriverManager.getConnection(url, un, pw); 
                Statement st = con.createStatement()) {
            
            String queryCourseName = "update courses set coursename='"+ newcoursename + "' where courseid in ('" + oldcourseid + "')";
            String queryDepartment = "update courses set department='"+ newdepartment + "' where courseid in ('" + oldcourseid + "')";
            String queryCourseID = "update courses set courseid='"+ newcourseid + "' where courseid in ('" + oldcourseid + "')";
            
            if(newcoursename != null)
                st.executeUpdate(queryCourseName);
            
            if(newdepartment != null)
                st.executeUpdate(queryDepartment);
            
            if(newcourseid != null)
                st.executeUpdate(queryCourseID);
            
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delRecord(String courseid) throws Exception  { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "12345";
        
        String query = "delete from courses where courseid=?";
        
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
    }
    
    public int addRecord(String courseid, String coursename, String department) throws Exception  { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "12345";
        
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
    }
    
    public int viewRecord() throws Exception { 
        String url = "jdbc:mysql://localhost:3310/enrolldb", un = "root", pw = "12345";
        
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
    }
    
    public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
    
    public static void main(String args[]) throws Exception {
        courses c = new courses();
        String courseid = "GEMATMW";
        String coursename = "Mathematics in a Modern World";
        String department = "College of Mathematics";
        
        c.viewRecord();
    }
}