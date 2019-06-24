package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {

	private String name;

	private String ward;

	private String street;
	
	private Integer numberOfBasement;
	
	private Integer costRentTo;

	private Integer costRentFrom;

	private Integer areaRentTo;

	private Integer areaRentFrom;

	private String[] buildingTypes = new String[] {};

	public String getName() {
		return name;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public Integer getCostRentTo() {
		return costRentTo;
	}

	public Integer getCostRentFrom() {
		return costRentFrom;
	}

	public Integer getAreaRentTo() {
		return areaRentTo;
	}

	public Integer getAreaRentFrom() {
		return areaRentFrom;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.ward = builder.ward;
		this.street = builder.street;
		this.numberOfBasement = builder.numberOfBasement;
		this.costRentTo = builder.costRentTo;
		this.costRentFrom = builder.costRentFrom;
		this.areaRentTo = builder.areaRentTo;
		this.areaRentFrom = builder.areaRentFrom;
		this.buildingTypes = builder.buildingTypes;
	}

	public static class Builder {
		private String name;
		private String ward;
		private String street;
		private Integer numberOfBasement;	
		private Integer costRentTo;
		private Integer costRentFrom;
		private Integer areaRentTo;
		private Integer areaRentFrom;
		private String[] buildingTypes = new String[] {};

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		
		
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setCostRentTo(Integer costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Builder setCostRentFrom(Integer costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Builder setAreaRentTo(Integer areaRentTo) {
			this.areaRentTo = areaRentTo;
			return this;
		}

		public Builder setAreaRentFrom(Integer areaRentFrom) {
			this.areaRentFrom = areaRentFrom;
			return this;
		}

		public Builder setBuildingTypes(String[] buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}
}
