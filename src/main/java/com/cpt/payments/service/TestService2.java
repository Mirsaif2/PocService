package com.cpt.payments.service;

import java.util.List;

import com.cpt.payments.pojo.Employees;
import com.cpt.payments.pojo.JsonRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestService2 {
  
	
	public String youngestEmployee(JsonRequest request) {
//	    Gson json = new Gson();
//		String Strrequest = json.toJson(request);
		List<Employees> employees = request.getEmployees();
		
		  Employees youngestEmployee = employees.get(0);
		if(employees.isEmpty()) {
			return "no employee in the list";
		}
		for(Employees employee : employees ) {
			 if (employee.getAge() < youngestEmployee.getAge()) {
	                youngestEmployee = employee;
	                
		}
		}
			 ObjectMapper objectMapper = new ObjectMapper();
			 try {
		            return objectMapper.writeValueAsString(youngestEmployee);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "Error converting to JSON.";
		        }
		
//		return res;
  }
}

