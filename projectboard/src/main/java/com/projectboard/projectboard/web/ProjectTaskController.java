package com.projectboard.projectboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectboard.projectboard.domain.ProjectTask;
import com.projectboard.projectboard.service.ProjectTaskService;

@RestController
@RequestMapping("/api/board")
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;

	@PostMapping("")
	public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		}
		ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);
		return new ResponseEntity<>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<ProjectTask> getAllPts() {
		return projectTaskService.findAll();
	}

	@GetMapping("/{ptId}")
	public ResponseEntity<?> getById(@PathVariable Integer ptId) {
		ProjectTask projectTask = projectTaskService.findById(ptId);
		return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
	}
}
