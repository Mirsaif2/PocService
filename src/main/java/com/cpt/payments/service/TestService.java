package com.cpt.payments.service;

import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.util.HmacSha256Utils;
import com.google.gson.Gson;

public class TestService {

	private String secretKey = "ecom-ct-secret123";
	public int validateAndRequest(AddRequest req, String clientsignature) {
		
		Gson gson = new Gson();
		String jsonRequest = gson.toJson(req);
		System.out.println("jsonRequest:" + jsonRequest);
		String generatedSig = HmacSha256Utils.generateSignature(secretKey,jsonRequest);
		System.out.println("generatedSig: " + generatedSig);
		if(generatedSig.equals(clientsignature)) {
			//process logic
			return req.getNum1() + req.getNum2();
		}
		
		return -1;
	}
}
