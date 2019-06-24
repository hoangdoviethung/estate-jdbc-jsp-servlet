package com.laptrinhjavaweb.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO> {

	private String name;

	private String ward;

	private String street;

	private String structure;

	private Integer numberOfBasement;

	private Integer buildingArea;

	private Integer costRent;

	private String costDescription;

	private String serviceCost;

	private String carCost;

	private String overtimeCost;
	private String motorbikeCost;

	private String electricCost;

	private String deposit;

	private String payment;

	private String timeRent;

	private String timeDecorate;

	private String manageName;

	private String managePhone;
	private String timeContract;
	private String type;

	private String direction;
	private String level;

	private Integer costRentTo;

	private Integer costRentFrom;

	private Integer areaRentTo;

	private Integer areaRentFrom;

	
	private String[] buildingTypes = new String[] {};
	
	public Integer getAreaRentTo() {
		return areaRentTo;
	}

	public void setAreaRentTo(Integer areaRentTo) {
		this.areaRentTo = areaRentTo;
	}

	public Integer getAreaRentFrom() {
		return areaRentFrom;
	}

	public void setAreaRentFrom(Integer areaRentFrom) {
		this.areaRentFrom = areaRentFrom;
	}

	public Integer getCostRentTo() {
		return costRentTo;
	}

	public void setCostRentTo(Integer costRentTo) {
		this.costRentTo = costRentTo;
	}

	public Integer getCostRentFrom() {
		return costRentFrom;
	}

	public void setCostRentFrom(Integer costRentFrom) {
		this.costRentFrom = costRentFrom;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	

	public String getTimeContract() {
		return timeContract;
	}

	public void setTimeContract(String timeContract) {
		this.timeContract = timeContract;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Integer getCostRent() {
		return costRent;
	}

	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}

	public String getCostDescription() {
		return costDescription;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}

	public String getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getCarCost() {
		return carCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public String getOvertimeCost() {
		return overtimeCost;
	}

	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}

	public String getMotorbikeCost() {
		return motorbikeCost;
	}

	public void setMotorbikeCost(String motorbikeCost) {
		this.motorbikeCost = motorbikeCost;
	}

	public String getElectricCost() {
		return electricCost;
	}

	public void setElectricCost(String electricCost) {
		this.electricCost = electricCost;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTimeRent() {
		return timeRent;
	}

	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}

	public String getTimeDecorate() {
		return timeDecorate;
	}

	public void setTimeDecorate(String timeDecorate) {
		this.timeDecorate = timeDecorate;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getManagePhone() {
		return managePhone;
	}

	public void setManagePhone(String managePhone) {
		this.managePhone = managePhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}

}
