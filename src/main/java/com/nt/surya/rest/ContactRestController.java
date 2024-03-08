package com.nt.surya.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.surya.bindings.ContactForm;
import com.nt.surya.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		System.out.println(form);
		return service.saveContact(form);
	}

	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts() {
		return service.viewContacts();
	}

	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}

	@GetMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		return service.deleteContact(contactId);
	}

}
