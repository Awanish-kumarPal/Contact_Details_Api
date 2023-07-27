package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepoistory;

@Service

public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepoistory contactRepoistory;

	@Override
	public String saveContact(Contact contact) {
		contact = contactRepoistory.save(contact);
		if (contact.getContactId() != null) {

			return "Contact are saved";
		} else {
			return "Contact already present";
		}

	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepoistory.findAll();
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> conId = contactRepoistory.findById(contactId);
		if (conId.isPresent()) {
			Contact contact = conId.get();
			return contact;
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (contactRepoistory.existsById(contact.getContactId())) {
			contactRepoistory.save(contact);
			// if (contact.getContactId() != null) {
			return "UPDATE are done";

		} else {

			return "update are not possible";
		}
	}

	@Override
	public String deleteContact(Integer contactId) {
		if (contactRepoistory.existsById(contactId)) {
			contactRepoistory.deleteById(contactId);
			return "Record are deleted";
		} else {
			return "no record found";
		}
	}

}
