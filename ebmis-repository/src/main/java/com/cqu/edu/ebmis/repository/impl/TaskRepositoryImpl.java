package com.cqu.edu.ebmis.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.TaskDO;
import com.cqu.edu.ebmis.mapper.TaskMapper;
import com.cqu.edu.ebmis.repository.TaskRepository;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
	@Resource
	private TaskMapper taskMapper; 
	
	@Override
	public int insertTask(TaskDO task) {
		return taskMapper.insertTask(task);
	}

	@Override
	public List<TaskDO> findAll() {
		return taskMapper.findAll();
	}

	@Override
	public TaskDO findById(int taskId) {
		return taskMapper.findById(taskId);
	}

	@Override
	public List<TaskDO> findTaskByProjectId(int projectId) {
		return taskMapper.findTaskByProjectId(projectId);
	}

	@Override
	public void updateTask(TaskDO task) {
		taskMapper.updateTask(task);

	}

	@Override
	public int deleteTask(int taskId) {
		return taskMapper.deleteTask(taskId);
	}

	@Override
	public List<TaskDO> selectByPage(int size, int offset) {
		return taskMapper.selectByPage(size, offset);
	}

	@Override
	public int selectAllCount() {
		return taskMapper.selectAllCount();
	}

	@Override
	public HashMap<String, String> getTasksByProjectId(int projectId) {
		return taskMapper.getTasksByProjectId(projectId);
	}

	@Override
	public boolean insertTasksBatch(List<TaskDO> tasks) {
		return taskMapper.insertTasksBatch(tasks);
	}

	@Override
	public boolean updateKeyWord(List<TaskDO> tasks) {
		return taskMapper.updateKeyWord(tasks);
	}

	@Override
	public HashMap<String, String> getTasksByProjectIds(List<Integer> ids) {
		return taskMapper.getTasksByProjectIds(ids);
	}

}