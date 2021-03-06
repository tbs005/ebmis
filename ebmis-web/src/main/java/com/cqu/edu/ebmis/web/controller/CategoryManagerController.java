/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.service.CategoryManagerService;

@Controller
@RequestMapping("/categoryManager")
public class CategoryManagerController extends SuperController {
	
	@Autowired
	private CategoryManagerService categoryManagerService;
	@RequestMapping("/manager")
	public String list(Model model) {
	
		return "/categoryManager/treeManager";
	}
	@ResponseBody
	@RequestMapping("/getToolId")
	public List<CategoryManagerDO> getToolId(Model model) {
		CategoryManagerDO categoryManager=new CategoryManagerDO();
		List<CategoryManagerDO> list=null;
		list=categoryManagerService.getByParentId(-1);
		if(list.size()<1){
			categoryManager.setCategoryName("根目录");
			categoryManager.setParentId(-1);
			categoryManager.setVisiable(1);
			categoryManagerService.save(categoryManager);
			list=categoryManagerService.getByParentId(-1);
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("/getParentId")
	public List<CategoryManagerDO> getParentId(Model model) {
		List<CategoryManagerDO> list=null;
		String strParentId=request.getParameter("parentId");
		if(strParentId!=null&&!strParentId.equals("")&&!strParentId.equals("null")){
			int parentId=Integer.parseInt(strParentId);
			list=categoryManagerService.getByParentId(parentId);
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("/getById")
	public CategoryManagerDO getById(Model model) {
		String id = request.getParameter("id");
		Integer categoryId = Integer.parseInt(id);
		return categoryManagerService.getById(categoryId);
	}
	@ResponseBody
	@RequestMapping("/save")
	public String save(Model model,CategoryManagerDO categoryManagerDO) {
		JSONObject json = new JSONObject();
		try {
			String id = request.getParameter("id");
			Integer parentId = Integer.parseInt(id);
			categoryManagerDO.setParentId(parentId);
			categoryManagerService.save(categoryManagerDO);
			CategoryManagerDO categoryManagerDO1=categoryManagerService.getById(parentId);
			if(categoryManagerDO1!=null){
				if(categoryManagerDO1.getIsLeaf()!=1){
					categoryManagerDO1.setIsLeaf(1);
					categoryManagerService.update(categoryManagerDO1);
				}
			}
			json.put("success" , true);
			json.put("data" , "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "添加失败");
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping("/del")
	public String del(Model model) {
		JSONObject json = new JSONObject();
		try {
			String id = request.getParameter("id");
			String pId = request.getParameter("pId");
			Integer categoryId = Integer.parseInt(id);
			categoryManagerService.del(categoryId);
			if(!pId.equals("-2")){
				Integer categoryId1=Integer.parseInt(pId);
				CategoryManagerDO categoryManagerDO=categoryManagerService.getById(categoryId1);
				if(categoryManagerDO!=null){
					if(categoryManagerDO.getIsLeaf()==1){
						categoryManagerDO.setIsLeaf(0);
						categoryManagerService.update(categoryManagerDO);
					}
				}
			}
			json.put("success" , true);
			json.put("data" , "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "删除失败");
		}
		return json.toJSONString();
	}
	/**
	 * 转换表
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/transformTable",produces="html/text;charset=UTF-8")
	public String transformTable(Model model) {
		JSONObject json = new JSONObject();
		try {
			categoryManagerService.transformTable();
			categoryManagerService.transformTableDate();
			json.put("success" , true);
			json.put("data" , "转表成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "转表失败");
		}
		return json.toJSONString();
	}
	/**
	 *备份
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/copyTable",produces="html/text;charset=UTF-8")
	public String copyTable(Model model) {
		JSONObject json = new JSONObject();
		try {
			categoryManagerService.copyTruncateTable();
			categoryManagerService.copyTableDate();
			json.put("success" , true);
			json.put("data" , "备份成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "备份失败");
		}
		return json.toJSONString();
	}
	/**
	 * 还原
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/restoreTable",produces="html/text;charset=UTF-8")
	public String restoreTable(Model model) {
		JSONObject json = new JSONObject();
		try {
			categoryManagerService.restoreTruncateTable();
			categoryManagerService.restoreTableDate();
			json.put("success" , true);
			json.put("data" , "还原成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "还原失败");
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping("/update")
	public String update(Model model,CategoryManagerDO categoryManagerDO) {
		JSONObject json = new JSONObject();
		try {
			String id = request.getParameter("id");
			String pId = request.getParameter("pId");
			String Leaf = request.getParameter("Leaf");
			Integer categoryId = Integer.parseInt(id);
			Integer parentId = Integer.parseInt(pId);
			Integer isLeaf = Integer.parseInt(Leaf);
			categoryManagerDO.setCategoryId(categoryId);
			categoryManagerDO.setParentId(parentId);
			categoryManagerDO.setIsLeaf(isLeaf);
			categoryManagerService.update(categoryManagerDO);
			String success="修改成功";
			json.put("success" , true);
			json.put("data" , success);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String success="修改失败";
			json.put("success" , false);
			json.put("data" , success);
		}
		return json.toJSONString();
	}
	//拖拽修改父节点pId
	@ResponseBody
	@RequestMapping("/updatePId")
	public String updatePId(Model model) {
		JSONObject json = new JSONObject();
		try {
			String parentId1=request.getParameter("pId");
			Integer parentId=Integer.parseInt(parentId1);
			CategoryManagerDO categoryManagerDO=new CategoryManagerDO();
			categoryManagerDO.setParentId(parentId);
			String length1=request.getParameter("length");
			Integer length=Integer.parseInt(length1);
				for(int i=0;i<length;i++){
					String categoryId1=request.getParameter("categoryId"+i);
					Integer categoryId=Integer.parseInt(categoryId1);
					categoryManagerDO.setCategoryId(categoryId);
					categoryManagerService.updateById(categoryManagerDO);
				}
			//查询拖拽目的节点是否是展开的  即isleaf=1
			CategoryManagerDO categoryManagerDO1=categoryManagerService.getById(parentId);
			if(categoryManagerDO1.getIsLeaf()==0){
				categoryManagerDO1.setIsLeaf(1);
				categoryManagerService.update(categoryManagerDO1);
			}
			//查询拖拽后它的父目录下是否还有节点  有就不修改isleaf 否则修改isleaf=1
			String preParentId1=request.getParameter("parentId");
			Integer preParentId=Integer.parseInt(preParentId1);
			List<CategoryManagerDO> categoryManagerDOList=categoryManagerService.getByParentId(preParentId);
			if(categoryManagerDOList.size()<1){
				CategoryManagerDO categoryManagerDO2=categoryManagerService.getById(preParentId);
				categoryManagerDO2.setIsLeaf(0);
				categoryManagerService.update(categoryManagerDO2);
			}
			String success="拖拽成功";
			json.put("success" , true);
			json.put("data" , success);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String success="拖拽失败";
			json.put("success" , false);
			json.put("data" , success);
		}
		return json.toJSONString();
	}

}
