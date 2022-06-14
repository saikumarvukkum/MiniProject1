package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.entity.Contact;
import com.nt.repository.ContactRepository;


@Service
public class ContactServiceimpl implements IContactService {
	   
	  @Autowired
	  private ContactRepository repo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact save = repo.save(contact);
		if(save.getContactId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getContact() {
		 Contact contact=new Contact();
		 contact.setActiveSw("Y");
		 List<Contact> list = repo.findAll(Example.of(contact));
		return list;
	}

	@Override
	public Contact editContactbyId(Integer id) {
		   Optional<Contact> findById = repo.findById(id);
		   if(findById.isPresent()) {
			   return findById.get();
		   }
		return null;
	}

	@Override
	public boolean deleteContactbyId(Integer id) {
		 Optional<Contact> findById = repo.findById(id);
		   if(findById.isPresent()) {
			  
					   Contact contact = findById.get();
					   contact.setActiveSw("N");
					   repo.save(contact);
					   return true;
		   }
		return false;
	}

}
