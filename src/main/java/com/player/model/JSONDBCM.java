package com.player.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class JSONDBCM {
	List<Map<String, Object>> JSONDBResult = new ArrayList<Map<String, Object>>();
	
	
	public JSONDBCM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSONDBCM(List<Map<String, Object>> jSONDBResult) {
		super();
		JSONDBResult = jSONDBResult;
	}

	public List<Map<String, Object>> getJSONDBResult() {
		return JSONDBResult;
	}

	public void setJSONDBResult(List<Map<String, Object>> jSONDBResult) {
		JSONDBResult = jSONDBResult;
	}
	/**add to additional field to JSON 
	@parameter contains a new JSONDBCM value to add to the current JSONfields
	@return this return the existing json db fields with the added via parameter
	*/

	public JSONDBCM add(JSONDBCM other)
	{
		List<Map<String, Object>> concactJSONDBCM = Stream.concat(JSONDBResult.stream(), other.JSONDBResult.stream())
                .collect(Collectors.toList());
		JSONDBResult = concactJSONDBCM;
		return this;

	}
	public void newJSONDBCM()
	{
		JSONDBResult = new ArrayList<Map<String, Object>>();
	}
	 
}
