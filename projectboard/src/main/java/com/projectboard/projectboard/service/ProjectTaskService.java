package com.projectboard.projectboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectboard.projectboard.domain.ProjectTask;
import com.projectboard.projectboard.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {

		if (projectTask.getStatus() == null || "".equals(projectTask.getStatus())) {
			projectTask.setStatus("TO_DO");
		}
		return projectTaskRepository.save(projectTask);
	}

	public Iterable<ProjectTask> findAll() {
		return projectTaskRepository.findAll();
	}

	public ProjectTask findById(Integer id) {
		return projectTaskRepository.getById(id);
	}
}
