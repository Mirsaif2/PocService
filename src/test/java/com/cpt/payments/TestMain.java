package com.cpt.payments;


import com.cpt.payments.pojo.AddRequest;
import com.google.gson.Gson;

public class TestMain {
   
	
	public static void main(String Args[]) {
		Gson gson = new Gson();
		AddRequest  req = new AddRequest();
		req.setNum1(10);
		req.setNum2(20);
		System.out.println(gson.toJson(req));
		
	//******************************************	
		
//		// Input JSON string
//        String jsonString = "{\"message\":\"Hello, World!\",\"timestamp\":\"2023-09-16T12:00:00Z\"}";
//
//        // Secret key
//        String secretKey = "ecom-ct-secret123";
//
//        try {
//            // Create a secret key object
//            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
//
//            // Initialize HMAC with SHA-256
//            Mac mac = Mac.getInstance("HmacSHA256");
//            mac.init(secretKeySpec);
//
//            // Calculate the HMAC-SHA256 signature
//            byte[] hmacBytes = mac.doFinal(jsonString.getBytes(StandardCharsets.UTF_8));
//
//            // Encode the signature in Base64
//            String signature = Base64.getEncoder().encodeToString(hmacBytes);
//
//            System.out.println("JSON String: " + jsonString);
//            System.out.println("HMAC-SHA256 Signature: " + signature);
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            e.printStackTrace();
//        }
		
	}
}
