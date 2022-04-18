package com.projectboard.projectboard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectboard.projectboard.domain.ProjectTask;
import com.projectboard.projectboard.service.ProjectTaskService;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;

	@PostMapping("")
	public ResponseEntity<?> addPTToBoard(@RequestBody ProjectTask projectTask) {
		// ProjectTask newPT = new projectTaskService.saveOrUpdateProjectTask(projectTask);
		return null; // n<ew ResponseEntity<>(newPT, HttpStatus.CREATED);
	}
}
