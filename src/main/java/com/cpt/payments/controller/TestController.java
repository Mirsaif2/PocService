package com.cpt.payments.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.pojo.AddResponse;
import com.cpt.payments.pojo.JsonRequest;
import com.cpt.payments.pojo.JsonResponse;
import com.cpt.payments.service.TestService;
import com.cpt.payments.service.TestService2;




@RestController
@RequestMapping("/controller")
public class TestController {
	


	private static final Logger logger = LogManager.getLogger(TestController.class);
	@GetMapping("/hellow")
	public String SayHellow() {
		return"Hellow World";
	}
	
	@GetMapping("/addGet")
	
	public int addGet(@RequestParam(value="num1") int val1, @RequestParam(value= "num2") int val2) {
		
		logger.debug("Debug message");
        logger.info("Info message");
        logger.error("Error message");
		
		System.out.print("val 1" + val1 + "|val2" + val2);
	    int res = val1 + val2;
	    System.out.print("res" + res);
	    return res;
	}
	@PostMapping("/AddPost")
	public int addPost(@RequestParam(value="num1") int val1, @RequestParam(value= "num2") int val2) {
		System.out.print("val 1" + val1 + "|val2" + val2);
	    int res = val1 + val2;
	    System.out.print("res" + res);
	    return res;
	
	
}
	@PostMapping("/processJSON")
	@ResponseBody
	public AddResponse proessJSON(@RequestBody AddRequest request) {
		System.out.print("calling processJSON :: request"+ request); //request is the object
	   int res = request.getNum1() + request.getNum2();
	   AddResponse response = new AddResponse();
	   
	   response.setResVal(res);
	   
	   System.out.print("add response" + response);
	   return response;
	    
	    
	    
	
	
}
//	@Autowired
//	private JsonResponse jsonResponse;
//	
//	@Autowired
//	private TestService2 testService;
//	@PostMapping("/youngestAge")
//	@ResponseBody
//	public JsonResponse parseJson(@RequestBody JsonRequest jsonRequest) {
//		   
//		String res = testService.youngestEmployee(jsonRequest);
//		
//		jsonResponse.setName(res);
//		
//		return jsonResponse;
//	}
	
	@PostMapping("/validateAndProcess")
	@ResponseBody
	public AddResponse validateAndProcess(
			@RequestHeader("signature") String signature,
			@RequestBody AddRequest request) {
		System.out.print("calling processJSON :: request"+ request + "|signature" + signature); //request is the object
	 
		TestService service = new TestService();
		
		int res = service.validateAndRequest(request, signature);
	   AddResponse response = new AddResponse();
	   
	   response.setResVal(res);
	   
	   System.out.print("add response" + response);
	   return response;
	    
	
} 

	

	
}
