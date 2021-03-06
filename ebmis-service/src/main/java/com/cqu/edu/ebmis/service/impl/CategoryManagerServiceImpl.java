/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.repository.CategoryManagerRepository;
import com.cqu.edu.ebmis.service.CategoryManagerService;

@Service
public class CategoryManagerServiceImpl implements CategoryManagerService {
	
	
	@Resource
	private CategoryManagerRepository catetoryManagerRepository;

	public void save(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.save(categoryManager);
	}

	public void update(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.update(categoryManager);
	}

	public void del(int categoryId) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.del(categoryId);
	}

	public List<CategoryManagerDO> getByParentId(int parentId) {
		// TODO Auto-generated method stub
		return catetoryManagerRepository.getByParentId(parentId);
	}

	public CategoryManagerDO getById(int categoryId) {
		// TODO Auto-generated method stub
		return catetoryManagerRepository.getById(categoryId);
	}

	public void updateById(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.updateById(categoryManager);
	}

	public void transformTable() {
		// TODO Auto-generated method stub
		catetoryManagerRepository.transformTable();
	}

	public void transformTableDate() {
		// TODO Auto-generated method stub
		catetoryManagerRepository.transformTableDate();
	}

	public void copyTruncateTable() {
		// TODO Auto-generated method stub
		catetoryManagerRepository.copyTruncateTable();
	}

	public void copyTableDate() {
		// TODO Auto-generated method stub
		catetoryManagerRepository.copyTableDate();
	}

	public void restoreTruncateTable() {
		// TODO Auto-generated method stub
		catetoryManagerRepository.restoreTruncateTable();
	}

	public void restoreTableDate() {
		// TODO Auto-generated method stub
		catetoryManagerRepository.restoreTableDate();
	}


	
}
