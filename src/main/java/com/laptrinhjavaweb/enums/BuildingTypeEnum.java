package com.laptrinhjavaweb.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng_Trệt"),
    NGUYEN_CAN("NguyĂªn CÄƒn"),
    NOI_THAT("Ná»™i Tháº¥t");
    
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
