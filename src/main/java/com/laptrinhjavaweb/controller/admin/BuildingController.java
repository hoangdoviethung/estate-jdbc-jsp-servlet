package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-building" })
public class BuildingController extends HttpServlet {
	private static final long serialVersionUID = 2686801510247002166L;

	private static IBuildingService buildingService;

	// public static IBuildingService getBuildingService() {
	// if (buildingService == null) {
	// buildingService = new BuildingService();
	// }
	// return buildingService;
	// }

	public BuildingController() {
		if (buildingService == null) {
			buildingService = new BuildingService();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		BuildingDTO model = FormUtil.toModel(BuildingDTO.class, request);
		String url = "";
		if (action.equals("LIST")) {
			url = "/views/building/list.jsp";
			BuildingSearchBuilder builder = initBuildingBuilder(model);
			Pageble pageble = new PageRequest(null, null, null);
			request.setAttribute("buildings", buildingService.findAll(builder, pageble));
			// model.setListResults(listResults);

		} else if (action.equals("EDIT")) {
			url = "/views/building/edit.jsp";
		}

		request.setAttribute("model", model);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private BuildingSearchBuilder initBuildingBuilder(BuildingDTO model) {
		BuildingSearchBuilder build = new BuildingSearchBuilder.Builder().setAreaRentFrom(model.getAreaRentFrom())
				.setAreaRentTo(model.getAreaRentTo()).setName(model.getName()).setCostRentFrom(model.getCostRentFrom())
				.setCostRentTo(model.getCostRentTo()).setNumberOfBasement(model.getNumberOfBasement())
				.setStreet(model.getStreet()).setWard(model.getWard()).build();

		return build;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
