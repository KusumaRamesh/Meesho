package com.cmt.sample.Service;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmt.sample.APIResponse.APIResponse;
import com.cmt.sample.Entity.Dispatchers;
import com.cmt.sample.Exceptions.ResourceNotFound;
import com.cmt.sample.Repository.DispatchersRepository;
@Service
public class DispatchersService {
	private static final String String = null;
	@Autowired
	private DispatchersRepository dispatchersrepository; 
	    private static int lastidnum=0;
	    private static char lastidchar='A';
	    public static String customId(){
	        if(lastidnum==99 ){
	            lastidchar++;
	            lastidnum=0;
	            
	        }
	        lastidnum++;
	        if(lastidnum<10) {
	        	 return '0'+String.valueOf(lastidnum)+lastidchar;
	        }
	        return String.valueOf(lastidnum)+lastidchar;
	    }

	public APIResponse adddispatchers(Dispatchers dispatcher) {
		    APIResponse apiresponse=new APIResponse();
		    String s=customId();
		    dispatcher.setId(s);
		    apiresponse.setData1(dispatchersrepository.save(dispatcher));
		    return apiresponse;
	}

	public APIResponse displayAll() {
		APIResponse apiresponse=new APIResponse();
		List<Dispatchers> dispatch=dispatchersrepository.findAll();
	    apiresponse.setData1(dispatch);											
		return apiresponse;
	}

	public APIResponse findByid(String id) {
		APIResponse apiresponse=new APIResponse();
		//apiresponse.setData1(dispatchersrepository.findByid(id));
		//apiresponse.setData1(dispatchersrepository.findById(id).orElse(null));
		//apiresponse.setData1(dispatchersrepository.findByid(id).orElseThrow(
			 // ()-> new ResourceNotFound("id is Not found")));
		Dispatchers c=dispatchersrepository.findByid(id);
		if(c==null)
			throw new ResourceNotFound("id not found");
		else
			apiresponse.setData1(dispatchersrepository.findByid(id));
		    return apiresponse;
	}
	
	public APIResponse deletedetails(String id) {
		APIResponse apiresponse=new APIResponse();
		dispatchersrepository.deleteid(id);
		apiresponse.setData1("Data deleted");
		return apiresponse;
	}
	public APIResponse findByPincode(String dispatcherpincode){
		APIResponse apiresponse=new APIResponse();
			//apiresponse.setData1(dispatchersrepository.findByPincode(dispatcherpincode));
		    //return apiresponse;
		Dispatchers pincode=dispatchersrepository.findByPincode(dispatcherpincode);
		if(pincode==null)
			throw new ResourceNotFound("dispatcher not found at this pincode");
		else
			apiresponse.setData1(dispatchersrepository.findByPincode(dispatcherpincode));
		    return apiresponse;
	}
	public APIResponse updatedetails(Dispatchers dispatcherdata) {
		APIResponse apiresponse=new APIResponse();
		//Dispatchers cc=dTNPSC Group 2 Eligibilityispatchersrepository.findByid(dispatcherdata.getId()).orElseThrow( () -> new ResourceNotFound("id Not found"));
		//Dispatchers cc=dispatchersrepository.findById(dispatcherdata.getId()).orElse(null);
	  Dispatchers cc=dispatchersrepository.findById(dispatcherdata.getId()).orElseThrow(null);// () -> new ResourceNotFound("id Not found"));
	  cc.setId(dispatcherdata.getId());
	  cc.setDispatcherPincode(dispatcherdata.getDispatcherPincode());
	  cc.setDispatcherName(dispatcherdata.getDispatcherName());
	  cc.setDispatcherPhno(dispatcherdata.getDispatcherPhno());
	  apiresponse.setData1(dispatchersrepository.save(cc));
	  return apiresponse;
	
	}
}
