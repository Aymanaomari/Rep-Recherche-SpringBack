package com.ngr.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngr.app.entity.GroupAccount;
import com.ngr.app.entity.Proposition;
import com.ngr.app.services.GroupAccountService;
import com.ngr.app.services.PropositionService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public ResponseEntity<String> helloRUser() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("hello");
	}
}
