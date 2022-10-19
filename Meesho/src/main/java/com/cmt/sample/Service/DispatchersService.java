package com.cmt.sample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmt.sample.APIResponse.APIResponse;
import com.cmt.sample.Entity.Dispatchers;
import com.cmt.sample.Exceptions.ResourceNotFound;
import com.cmt.sample.Repository.DispatchersRepository;
@Service
public class DispatchersService {
	@Autowired
	private DispatchersRepository dispatchersrepository; 

	public APIResponse adddispatchers(Dispatchers dispatcher) {
		    APIResponse apiresponse=new APIResponse();
		    apiresponse.setData1(dispatchersrepository.save(dispatcher));
			return apiresponse;
		}
	public APIResponse displayAll() {
		APIResponse apiresponse=new APIResponse();
		List<Dispatchers> dispatch=dispatchersrepository.findAll();
	    apiresponse.setData1(dispatch);											
		return apiresponse;
	}

	public APIResponse findById(int id) {
		APIResponse apiresponse=new APIResponse();
		//apiresponse.setData1(dispatchersrepository.findById(id).orElse(null));
		apiresponse.setData1(dispatchersrepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("id is Not found")));
		return apiresponse;
	}
	public APIResponse deletedetails(int id) {
		APIResponse apiresponse=new APIResponse();
		dispatchersrepository.deleteById(id);
		apiresponse.setData1("Data deleted");
		return apiresponse;
	}
	public APIResponse findByPincode(String dispatcherpincode){
		APIResponse apiresponse=new APIResponse();
		apiresponse.setData1(dispatchersrepository.findByPincode(dispatcherpincode));
		return apiresponse;
	}
	public APIResponse updatedetails(Dispatchers dispatcherdata) {
		APIResponse apiresponse=new APIResponse();
		//Dispatchers cc=dispatchersrepository.findById(dispatcherdata.getId()).orElse(null);
		Dispatchers cc=dispatchersrepository.findById(dispatcherdata.getId()).orElseThrow( () -> new ResourceNotFound("id Not found"));
		cc.setId(dispatcherdata.getId());
		cc.setDispatcher_pincode(dispatcherdata.getDispatcher_pincode());
		cc.setDispatcher_name(dispatcherdata.getDispatcher_name());
		cc.setDispatcher_phNo(dispatcherdata.getDispatcher_phNo());
		apiresponse.setData1(dispatchersrepository.save(cc));
		return apiresponse;
	}
	

}
