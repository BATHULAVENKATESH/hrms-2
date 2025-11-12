package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hr.entity.CreatePost;
import com.hr.entity.Employee;
import com.hr.repository.CreatePostRepo;
import com.hr.repository.EmployeeRepo;

@Service
public class HrService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private CreatePostRepo createPostRepo;

	public Employee addEmployee(Employee employee) {

		Employee save = employeeRepo.save(employee);

		return save;
	}

	public List<CreatePost> getAllPosts() {
		
		return createPostRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	public CreatePost addPost(CreatePost createPost) {

		CreatePost save = createPostRepo.save(createPost);

		return save;
	}

}
