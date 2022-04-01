package com.ps.cloudcostinspector.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataCenterLocation implements Serializable {
	
	String eastRegionUS = "us-east"; 
	List<String> regions;
	List<Map> availabilityZones;

	public List<String> getRegions () {
		if (regions == null) {
			regions = new ArrayList<>();
			regions.add(eastRegionUS);
		}
		return regions;
	}
	
}
