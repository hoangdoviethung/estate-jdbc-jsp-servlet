package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "ward")
	private String ward;

	@Column(name = "street")
	private String street;

	@Column(name = "structure")
	private String structure;

	@Column(name = "numberofbasement")
	private Integer numberOfBasement;

	@Column(name = "buildingarea")
	private Integer buildingArea;

	@Column(name = "costrent")
	private Integer costRent;

	@Column(name="district")
	private String district;
	
	@Column(name = "costdescription")
	private String costDescription;

	@Column(name = "servicecost")
	private String serviceCost;

	@Column(name = "carcost")
	private String carCost;

	@Column(name = "overtimecost")
	private String overtimeCost;

	@Column(name = "motorbikecost")
	private String motorbikeCost;

	@Column(name = "electriccost")
	private String electricCost;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "payment")
	private String payment;

	@Column(name = "timerent")
	private String timeRent;

	@Column(name = "timedecorate")
	private String timeDecorate;

	@Column(name = "managername")
	private String managerName;

	@Column(name = "managerphone")
	private String managerPhone;

	@Column(name = "type")
	private String type;

	@Column(name = "timecontract")
	private String timeContract;

	@Column(name = "direction")
	private String direction;

	@Column(name = "level")
	private String level;

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

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCostRent() {
		return costRent;
	}

	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}

	public String getTimeContract() {
		return timeContract;
	}

	public void setTimeContract(String timeContract) {
		this.timeContract = timeContract;
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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	

}
