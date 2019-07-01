package com.laptrinhjavaweb.utils;

import java.util.HashMap;
import java.util.Map;

import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;

public class DataUtil {
	public static Map<String, String> getDistrics(){
		 Map<String, String>  results = new HashMap<>();
		 for ( DistrictEnum item : DistrictEnum.values()) {
			results.put(item.name(), item.getValue());
		}
		 return results;
	}
	public static Map<String, String> getBuildingTypes(){
		 Map<String, String>  results = new HashMap<>();
		 for ( BuildingTypeEnum item : BuildingTypeEnum.values()) {
			results.put(item.name(), item.getValue());
		}
		 return results;
	}
}
