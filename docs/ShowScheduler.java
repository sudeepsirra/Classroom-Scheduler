import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShowScheduler extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
try
   {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/abc","root","");
	Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("Select * from def");
	out.println("<h1 align='center' style='font-family:perpetua;'>ALL EVENTS</h1>");
	out.println("<table border=1 align='center' style='border: 1px solid #f78536;'>");
	out.println("<tr><th style='background-color:#f78536;font-size:27px;color:white;font-family:perpetua;'>Teacher name</th><th style='background-color:#f78536;font-size:27px;color:white;font-family:perpetua;'>Event Name</th><th style='background-color:#f78536;font-size:27px;color:white;font-family:perpetua;'>Start Date</th><th style='background-color:#f78536;font-size:27px;color:white;font-family:perpetua;'>End Date</th><th style='background-color:#f78536;font-size:27px;color:white;font-family:perpetua;'>Description</th></tr>");
	while(rs.next()){
		String name = rs.getString("teachername");
		String eventname = rs.getString("eventname");
		String start = rs.getString("start");
		String end = rs.getString("end");
        String desc = rs.getString("descr");
		out.println("<tr><td style='background-color:#2b4450;font-size:27px;color:white;font-family:perpetua;'>"+ name + "</td><td style='background-color:#2b4450;font-size:27px;color:white;font-family:perpetua;'>"+ eventname + "</td><td style='background-color:#2b4450;font-size:27px;color:white;font-family:perpetua;'>"+ start + "</td><td style='background-color:#2b4450;font-size:27px;color:white;font-family:perpetua;'>"+ end + "</td><td style='background-color:#2b4450;font-size:27px;color:white;font-family:perpetua;'>"+ desc +"</td></tr>");
		
	}
	out.println("</table>");
	out.println("</body></html>");
	
}
  
catch(Exception ex)
{ 
 out.println(ex);
}
} 
}