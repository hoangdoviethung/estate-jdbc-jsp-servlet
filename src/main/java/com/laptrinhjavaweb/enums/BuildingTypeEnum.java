package com.laptrinhjavaweb.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng_Trệt"),
    NGUYEN_CAN("Nguyên_Căn"),
    NOI_THAT("Nội_Thất");
    
	private String value;

	BuildingTypeEnum(String value){
		this.value= value;
	}
	
	public String value(){
		return value;
	}

	public String getValue() {
		return value;
	}

	
	
	
}
