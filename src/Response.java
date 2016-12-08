

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response
 */
@WebServlet("/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Response() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String response1 = request.getParameter("Q1");
		String response2 = request.getParameter("Q2");
		String response3 = request.getParameter("Q3");
		String response4 = request.getParameter("Q4");
		String response5 = request.getParameter("Q5");
		String response6 = request.getParameter("Q6");
		String response7 = request.getParameter("Q7");
		String response8 = request.getParameter("Q8");
		String response9 = request.getParameter("Q1");
		String response10 = request.getParameter("Q10");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into responses (response1,response2,response3,response4,response5,response6,response7,response8,response9,response10) values (?,?,?,?,?,?,?,?,?,?)";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			ps = con.prepareStatement(sql);
			int i=1;
			ps.setString(i++, response1);
			ps.setString(i++, response2);
			ps.setString(i++, response3);
			ps.setString(i++, response4);
			ps.setString(i++, response5);
			ps.setString(i++, response6);
			ps.setString(i++, response7);
			ps.setString(i++, response8);
			ps.setString(i++, response9);
			ps.setString(i++, response10);
			int count = ps.executeUpdate();
			System.out.println("Your query updated "+count+" row.");

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null)
					rs.close();
				if (ps!=null)
					ps.close();
				if (con!=null)
					con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
