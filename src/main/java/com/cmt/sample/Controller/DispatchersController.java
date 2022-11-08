package com.cmt.sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmt.sample.APIResponse.APIResponse;
import com.cmt.sample.Entity.Dispatchers;
import com.cmt.sample.Exceptions.ResourceNotFound;
import com.cmt.sample.Service.DispatchersService;

@RestController
public class DispatchersController {
		@Autowired
		private DispatchersService dispatchersservice;
		
		public DispatchersController(DispatchersService dispatchersservice) {
			super();
			this.dispatchersservice=dispatchersservice;
		}
		
		@PostMapping("/adddispatchers")
		public APIResponse adddispatchers(@RequestBody Dispatchers dispatcher) {
			return dispatchersservice.adddispatchers(dispatcher);
		}
		@GetMapping("/dispatchersdata")
		public  APIResponse displayAll() {
			return (APIResponse) dispatchersservice.displayAll();				
		}
		@GetMapping("/dispatcherid/{id}")
		public  APIResponse findid(@PathVariable String id) {
			return dispatchersservice.findByid(id);
		}
			
		@GetMapping("/enterpincode/{dispatcherPincode}")
			public APIResponse findPincode(@PathVariable String dispatcherPincode){
				return dispatchersservice.findByPincode(dispatcherPincode);
		}
		@PutMapping("/updatedat")
		public  APIResponse updatedetails(@RequestBody Dispatchers dispatcherPincode) {
			return dispatchersservice.updatedetails(dispatcherPincode);
		}
		@DeleteMapping("/deleted/{id}")
		public APIResponse deletedispatcherdetails(@PathVariable String id) {
			return dispatchersservice.deletedetails(id);
		}

}
