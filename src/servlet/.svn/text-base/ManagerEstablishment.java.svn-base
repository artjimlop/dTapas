package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessEstablishment;
import business.IBusinessEstablishment;
import domain.IEstablishment;

/**
 * Servlet implementation class ManagerEstablishment
 */
@WebServlet("/ManagerEstablishment")
public class ManagerEstablishment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerEstablishment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			showEstablishment(request,response);
	}
	

	private void showEstablishment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		IBusinessEstablishment businessEstablishment = new BusinessEstablishment();
		
		List<IEstablishment> establishments = businessEstablishment.getAllEstablishments();
		out.println("Todos los establecimientos: " + "<br>");
		
		
		for(IEstablishment establishment: establishments){
			out.println("Nombre: " + establishment.getNameEstablishment() + "Día de registro: " + establishment.getRegistryDate() + "<br>");
			
		}
		
		
	}

}
