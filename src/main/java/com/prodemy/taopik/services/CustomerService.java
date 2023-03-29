package com.prodemy.taopik.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodemy.taopik.models.Customer;
import com.prodemy.taopik.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository repo;

	public List<Customer> getAll() {
		return (List<Customer>) repo.findAll();
	}

	public void save(Customer cs) {
		repo.save(cs);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public Customer getById(Long id) {
		return repo.findById(id).get();
	}
    public List<Customer> search(String keyword) {
        return repo.search(keyword);
    }
}
