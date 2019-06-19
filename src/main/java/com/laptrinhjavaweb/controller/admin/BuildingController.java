package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

@WebServlet(urlPatterns = { "/admin-building" })
public class BuildingController extends HttpServlet {
	private static final long serialVersionUID = 2686801510247002166L;

	private IBuildingService buildingService;

	public BuildingController() {
		buildingService = new BuildingService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		BuildingDTO model = new BuildingDTO();
		String url = "";
		if(action.equals("EDIT")){
			url="/views/building/edit.jsp";
			//request.setAttribute("buildings",buildingService.findAll(builder, pageble));
			//model.setListResults(listResults);

		}else if (action.equals("LIST")){
			url="/views/building/list.jsp";
		}
		
		request.setAttribute("model", model);
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
