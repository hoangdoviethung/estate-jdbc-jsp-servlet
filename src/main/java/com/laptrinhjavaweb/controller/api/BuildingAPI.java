package com.laptrinhjavaweb.controller.api;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.HttpUtils;

@WebServlet(urlPatterns = "/api-admin-building")
public class BuildingAPI extends HttpServlet {

	private IBuildingService buildingService;

	public BuildingAPI() {
		buildingService = new BuildingService();
	}

	private static final long serialVersionUID = -915988021506484384L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ObjectMapper mapper = new ObjectMapper();
		// request.setCharacterEncoding("UTF-8");
		// response.setContentType("application/json");
		// BuildingDTO buildingDTO =
		// HttpUtils.of(request.getReader()).toModel(BuildingDTO.class);
		// buildingDTO = buildingService.save(buildingDTO);
		// mapper.writeValue(response.getOutputStream(), buildingDTO);

		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// BuildingDTO buildingDTO = buildingService.findById(new Long(2));
		// mapper.writeValue(response.getOutputStream(), buildingDTO);

		// ObjectMapper mapper = new ObjectMapper();
		// request.setCharacterEncoding("UTF-8");
		// response.setContentType("application/json");
		// List<BuildingDTO> list = buildingService.findAll();
		// mapper.writeValue(response.getOutputStream(), list);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO buildingDTO = HttpUtils.of(request.getReader()).toModel(BuildingDTO.class);

		// buildingDTO = buildingService.update(buildingDTO);
		mapper.writeValue(response.getOutputStream(), buildingDTO);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// buildingService.delete(new Long(4));
	}

}
