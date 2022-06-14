package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.constants.AppConstants;
import com.nt.entity.Contact;
import com.nt.props.AppProperties;
import com.nt.service.IContactService;

@RestController
@CrossOrigin
public class ContactRestController {
      
	  @Autowired
	  private IContactService service;
	  
	  @Autowired
	  private AppProperties props;
	      
	      @PostMapping("/contact")
	     public String postData(@RequestBody Contact contact) {
	    	 boolean status = service.saveContact(contact);
	    	 
	    	 Map<String, String> messages = props.getMessages();
	    	 if(status) {
	    		 return messages.get(AppConstants.Contact_Save_Success);
	    	 }else {
	    		 
	    		 return messages.get(AppConstants.Contact_Save_Fail);
	    	 }
	    	 
	     }//post(-)
	  
	       @GetMapping("/contacts")  
	      public List<Contact> getContactData(){
	    	  return service.getContact();
	      }//get(-)

	       
	       @GetMapping("/edit/{cid}")
	       public Contact editContact(@PathVariable("cid") Integer id) {
	    	   return service.editContactbyId(id);
	       }//get(-)
	      
	       
	       @DeleteMapping("/delete/{cid}")
	       public String deleteContact(@PathVariable("cid") Integer id) {
	    	   boolean status = service.deleteContactbyId(id);
	    	   Map<String, String> messages = props.getMessages();
	    	   
	    	   if(status) {
		    		 return messages.get(AppConstants.Contact_Delete_Success);
		    	 }else {
		    		 
		    		 return messages.get(AppConstants.Contact_Delete_Fail);
		    	 }
	    	   
	       }//delete(-)
	  
}//class
