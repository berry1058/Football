package com.FootBallServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanFranTeam.DAO;
import com.sanFranTeam.footBall;

/**
 * Servlet implementation class FootBallServlet
 */
@WebServlet("/FootBallServlet")
public class FootBallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FootBallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		footBall addTodb = new footBall();
		
		
		addTodb.setFirstName(request.getParameter("First"));
		addTodb.setLastName(request.getParameter("Last"));
		addTodb.setPosition(request.getParameter("Position"));
		addTodb.setTeam(request.getParameter("Team"));
		
		
		try {
			addTodb.setYearsOnTeam(Integer.parseInt(request.getParameter("Years")));
			addTodb.setJerseyNumber(Integer.parseInt(request.getParameter("Jersey")));
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		DAO.writeToDB(addTodb);
		request.getRequestDispatcher("FootBall.html").forward(request, response);
	}
	
	
}
