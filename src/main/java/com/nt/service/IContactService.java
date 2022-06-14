package com.nt.service;

import java.util.List;

import com.nt.entity.Contact;

public interface IContactService {
        
	public boolean saveContact(Contact contact);
	
	public List<Contact> getContact();
	
	public Contact editContactbyId(Integer id);
	
	public boolean deleteContactbyId(Integer id);
	
}//inte
