package com.nt.surya.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.surya.bindings.ContactForm;
import com.nt.surya.entities.Contact;
import com.nt.surya.repository.ContactRepository;

@Service // to make as a spring bean use this annotaton
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(ContactForm form) {
		// we have recieved form binding object as parameter
		// Repository save(entity) method expecting entity object
		// so copy the data from form binding object to entity object
		// BeanUtils used to copy one object to other
		Contact entity = new Contact();
		
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("Y");
		contactRepository.save(entity);
		if (entity.getContactId() != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepository.findAll();
		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			Contact entity=findById.get();
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepository.deleteById(contactId);
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepository.findAll();
		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
		}
		return dataList;

	}
}
