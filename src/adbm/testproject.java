package adbm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testproject
 */
@WebServlet("/testproject")
public class testproject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testproject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			connect con = new connect();
			
			PrintWriter out = response.getWriter();
			
			
			String q = request.getParameter("q");
			
			
			if(Integer.parseInt(q) == 1)
			{
				out.print(con.getCountryRestaurants());
			}
			
			if(Integer.parseInt(q) == 2)
			{
				out.print(con.getZomatoAppUsageByCountry());
			}
			
			if(Integer.parseInt(q) == 3)
			{
				out.print(con.restaurantsByRating());
			}
			
			if(Integer.parseInt(q) == 4)
			{
				out.print(con.getPriceRange());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
