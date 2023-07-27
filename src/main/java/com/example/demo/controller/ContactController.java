package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@RestController

public class ContactController {
	@Autowired
	private ContactService contactService;
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
 		String status = contactService.saveContact(contact);
		return status;
		
	}
	@GetMapping("/contacts")
	public List<Contact> getAllContact(){
		/*
		 * List<Contact> allContact = contactService.getAllContact(); 
		 * return allContact;
		 */
		return contactService.getAllContacts();
	}
	@GetMapping("/contact/{contactId}")
	public Contact getContactbyId( @PathVariable Integer contactId) {
		/*
		 * Contact contactById = contactService.getContactById(contactId); return
		 * contactById;
		 */
		return contactService.getContactById(contactId);
	}
	@PutMapping("/contact")
	public String update(@RequestBody Contact contact) {
		/*
		 * String updateContact = contactService.updateContact(contact); return
		 * updateContact;
		 */
		return contactService.updateContact(contact);
	}
	@DeleteMapping("/contact/{contactId}")
	
	public String deleteContact(@PathVariable Integer contactId) {
		
		return contactService.deleteContact(contactId);
		
	}
	

}
