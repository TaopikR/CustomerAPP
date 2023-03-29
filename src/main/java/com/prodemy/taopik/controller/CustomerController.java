package com.prodemy.taopik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodemy.taopik.models.Customer;
import com.prodemy.taopik.services.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@GetMapping("/customerList")
	public ResponseEntity<List<Customer>> getCompanyList() {
		return new ResponseEntity<List<Customer>>(cs.getAll(), HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCompany(@PathVariable Long id) {
		return new ResponseEntity<Customer>(cs.getById(id), HttpStatus.OK);
	}

	@PostMapping("/customer/save")
	public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Customer customer) {
		cs.save(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/customer/delete/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		cs.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
