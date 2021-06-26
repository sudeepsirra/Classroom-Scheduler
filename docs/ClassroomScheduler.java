import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ClassroomScheduler extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String teacher=req.getParameter("teachername");
String event=req.getParameter("eventname");
String startdate=req.getParameter("startdate");
String startdate1=startdate.replace('T', ' ');
String enddate=req.getParameter("enddate");
String enddate1=enddate.replace('T', ' ');
String details=req.getParameter("det");

try
   {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/abc","root","");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("Select * from def where start='"+startdate1+"'");
	if(rs.next()){
		out.println("<center><h1>An Event Already Exists</h1>");
	}
	else
	{

PreparedStatement ps=con.prepareStatement("INSERT INTO def values(?,?,?,?,?)");
ps.setString(1,teacher);
ps.setString(2,event);
ps.setString(3,startdate1);
ps.setString(4,enddate1);
ps.setString(5,details);
int i=ps.executeUpdate();
if(i>0){
	out.println("<center><h1>Event has been added</h1></center>");
}
	}
}
catch(Exception ex)
{  out.println(ex);
}
} 
}