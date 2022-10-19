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
		public  APIResponse findById(@PathVariable int id) {
			return dispatchersservice.findById(id);
		}
			
		@GetMapping("/enterpincode/{dispatcher_pincode}")
			public APIResponse findPincode(@PathVariable String dispatcher_pincode) throws Exception {
				return dispatchersservice.findByPincode(dispatcher_pincode);
		}
		@PutMapping("/updated_at/{dispatcher_pincode}")
		public  APIResponse updatedetails(@RequestBody Dispatchers dispatcher_pincode) {
			return dispatchersservice.updatedetails(dispatcher_pincode);
		}
		@DeleteMapping("/deleted/{id}")
		public APIResponse delete_dispatcherdetails(@PathVariable int id) {
			return dispatchersservice.deletedetails(id);
		}

}
