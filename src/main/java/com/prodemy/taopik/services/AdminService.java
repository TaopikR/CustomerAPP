package com.prodemy.taopik.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.prodemy.taopik.models.Admin;
import com.prodemy.taopik.repository.AdminRepository;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminRepository repo;
	public void save(Admin an) {
		repo.save(an);
	}
	
	public Admin getAdmin(String username) {
		return repo.getAdmin(username);
	}
}
