package com.grgbanking.fingervein.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grgbanking.fingervein.entity.User;
import com.grgbanking.fingervein.param.OrganizationQueryParam;
import com.grgbanking.fingervein.param.PermissionQueryParam;
import com.grgbanking.fingervein.param.RoleQueryParam;
import com.grgbanking.fingervein.service.ITreeService;
import com.grgbanking.fingervein.tree.Tree;

@Controller
@RequestMapping("/manager")
public class OperationContoller extends BaseController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(OperationContoller.class);
	
	@Autowired
	private ITreeService treeService;
	
	@RequestMapping("/organization/tree")
	@ResponseBody
	public Object tree(OrganizationQueryParam param) {
		User user = getCurrentUser();
		List<Tree> data = null;
		try {
			param.setUserId(user.getId());
			param.setAdmin(user.getAdmin());
			data = treeService.treeOrganization(param);
		} catch (Exception e) {
			LOGGER.error("获取数据失败", e);
		}
		return data;
	}
	
	@RequestMapping("/permission/tree")
	@ResponseBody
	public Object tree(PermissionQueryParam param) {
		List<Tree> data = null;
		try {
			data = treeService.treePermission(param);
		} catch (Exception e) {
			LOGGER.error("获取数据失败", e);
		}
		return data;
	}
	
	@RequestMapping("/role/tree")
	@ResponseBody
	public Object tree(RoleQueryParam param) {
		List<Tree> data = null;
		try {
			data = treeService.treeRole(param);
		} catch (Exception e) {
			LOGGER.error("获取数据失败", e);
		}
		return data;
	}
	
	/**
	 * 关联终端
	 * @return
	 */
	@RequestMapping("/associate/list")
	public String associate() {
		return "associateList";
	}
	
	/**
	 * 实时数据查询
	 * @return
	 */
	@RequestMapping("/timeliness/list")
	public String timeliness() {
		return "timelinessList";
	}
	
	/**
	 * 采集任务配置
	 * @return
	 */
	@RequestMapping("/sampleJob/list")
	public String sampleJob() {
		return "sampleJobList";
	}
	
	/**
	 * 监测点参数实时维护
	 * @return
	 */
	@RequestMapping("/monitor/list")
	public String monitor() {
		return "monitorList";
	}
	
	/**
	 * 集中采集器参数实时维护
	 * @return
	 */
	@RequestMapping("/collector/list")
	public String collector() {
		return "collectorList";
	}
	
	/**
	 * 终端软件升级管理
	 * @return
	 */
	@RequestMapping("/upgraded/list")
	public String upgraded() {
		return "upgradedList";
	}
}
