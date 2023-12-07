package com.cpt.payments.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256Utils {
	
	
	/**
	 * Generates an HMAC-SHA256 signature for a given JSON string using a secret key.
	 *
	 * @param secretKey The secret key used for generating the HMAC signature.
	 * @param jsonString The JSON string to be signed.
	 * @return The HMAC-SHA256 signature as a Base64-encoded string.
	 */

	public static String generateSignature(String secretKey, String jsonString){
		String signature = null;

        try {
            // Create a secret key object
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

            // Initialize HMAC with SHA-256
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            // Calculate the HMAC-SHA256 signature
            byte[] hmacBytes = mac.doFinal(jsonString.getBytes(StandardCharsets.UTF_8));

            // Encode the signature in Base64
           signature = Base64.getEncoder().encodeToString(hmacBytes);

            System.out.println("JSON String: " + jsonString);
            System.out.println("HMAC-SHA256 Signature: " + signature);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
		
		return signature;
	}
}
