package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user-api")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	// ======= Get All Member =======
	@GetMapping("/list")
	public Map<String, Object> getListUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<User> userList = new ArrayList<User>();
			userList = userRepo.findAll();
			map.put("status", "Success");
			map.put("data", userList);
			return map;
		} catch (Exception error) {
			map.put("status", "Failed");
			map.put("message", "Internal Error");
			map.put("messageError", error.getMessage());
			return map;
		}
	}

	// ======= Get Member by ID =======
	@GetMapping("/detail/{id}")
	public Map<String, Object> getUser(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Optional<User> userData = userRepo.findById(id);

			if (userData.isPresent()) {
				map.put("status", "Success");
				map.put("data", userData);
			} else {
				map.put("status", "Failed");
				map.put("data", userData);
				map.put("message", "Member not exist");
			}
			return map;
		} catch (Exception error) {
			map.put("status", "Failed");
			map.put("message", "Internal Error");
			map.put("messageError", error.getMessage());
			return map;
		}
	}

	// ======= Create / Register Member ========
	@PostMapping("/create")
	public Map<String, Object> createUser(@RequestBody User dataUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("status", "Success");
			map.put("message", "User Created");
			userRepo.save(dataUser);
			return map;
		} catch (Exception e) {
			map.put("status", "Failed");
			map.put("message", "Internal Error");
			map.put("messageError", e.getMessage());
			return map;
		}
	}

	// ======= Edit Member ========
	@PostMapping("/edit/{id}")
	public Map<String, Object> editUser(@PathVariable("id") String id, @RequestBody User userData) {
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<User> data = userRepo.findById(id);
		try {
			User dataEdit = data.get();
			dataEdit.setName(userData.getName());
			dataEdit.setPassword(userData.getPassword());
			map.put("status", "Success");
			map.put("message", "Data member edited");
			userRepo.save(dataEdit);

			return map;
		} catch (Exception e) {
			map.put("status", "Failed");
			map.put("message", "Internal Error");
			map.put("messageError", e.getMessage());
			return map;
		}
	}

	// ======= Delete Member ========
	@GetMapping("/delete/{id}")
	public Map<String, Object> deleteUser(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<User> data = userRepo.findById(id);
		try {
			if (data.isPresent()) {
				User dataDelete = data.get();
				map.put("status", "Success");
				map.put("message", "Data member Deleted");
				userRepo.delete(dataDelete);
			} else {
				map.put("status", "Failed");
				map.put("message", "Data member not exist");
			}
			return map;

		} catch (Exception e) {
			map.put("status", "Failed");
			map.put("message", "Internal Error");
			map.put("messageError", e.getMessage());
			return map;
		}
	}
}
