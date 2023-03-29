package com.prodemy.taopik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prodemy.taopik.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Query(value = "SELECT c FROM Customer c WHERE c.name ILIKE '%' || :keyword || '%'"
			+ " OR c.email ILIKE '%' || :keyword || '%'" + " OR c.address ILIKE '%' || :keyword || '%'")
	public List<Customer> search(String keyword);
}
