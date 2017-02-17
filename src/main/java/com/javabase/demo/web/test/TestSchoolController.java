package com.javabase.demo.web.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.base.core.obj.Pagination;
import com.application.base.utils.common.StringDefaultValue;
import com.application.base.utils.common.UUIDProvider;
import com.application.base.core.common.BaseController;
import com.application.base.core.constant.Constants;
import com.javabase.demo.entity.test.TestSchool;
import com.javabase.demo.service.test.TestSchoolService;

/**
 * TestSchoolController实现
 * 
 * @author 系统生成
 *
 */

@Controller
@RequestMapping("/background/testSchool/")
public class TestSchoolController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TestSchoolService testSchoolService;
	
	@RequestMapping("find")
	public String find(Model model) {
		Map<String, Object> param = getRequestParams(request);
		Pagination<TestSchool> resultPage = testSchoolService.paginationObjects(param, StringDefaultValue.intValue(param.get("pageNo")), StringDefaultValue.intValue(param.get("pageSize")));
		model.addAttribute("pageView", resultPage);
		return "/background/testSchool/list";
	}
	
	
	@RequestMapping("findByName")
	public void findByName(Model model, String objName) {
		String data = null;
		try {
			TestSchool object = new TestSchool();
			//object.setName(objName);
			object = testSchoolService.findObjectByPros(object);
			if (object != null) {
				data = "({msg:'Y',content:'该对象名字已经存在,请重新添加!'})";
			}
			else {
				data = "({msg:'N',content:'可以放心使用!'})";
			}
			// 返回.
			ajaxJson(data);
		}
		catch (Exception e) {
			logger.info("查找出错!" + e.getLocalizedMessage());
		}
	}
	
	
	@RequestMapping("findByProps")
	public void findByProps(Model model, TestSchool object ) {
		String data = null;
		try {
			object = testSchoolService.findObjectByPros(object);
			if (object.getId() > 0 ) {
				data = "({msg:'Y',content:'按需求填写!'})";
			}
			else {
				data = "({msg:'N',content:'按需求填写!'})";
			}
			// 返回.
			ajaxJson(data);
		}
		catch (Exception e) {
			logger.info("查找出错!" + e.getLocalizedMessage());
		}
	}
		
	@RequestMapping("addUI")
	public String addUI(Model model) {
		return "/background/testSchool/add";
	}
	
	@RequestMapping("addOne")
	public String addOne(Model model, TestSchool object) {
		object.setUuid(UUIDProvider.uuid());
		object.setIsDelete(Constants.DeleteStatus.ENABLED);
		object.setCreateTime(new Date());
		object.setUpdateTime(new Date());
		testSchoolService.saveObject(object);
		return "redirect:find.html";
	}	
	
	@RequestMapping("findById")
	public String findById(Model model, String objId, int type) {
		TestSchool object = testSchoolService.getObjectByID(Integer.parseInt(objId));
		model.addAttribute("object", object);
		if (type == 1) {
			return "/background/testSchool/edit";
		}
		else {
			return "/background/testSchool/show";
		}
	}
	

	@RequestMapping("deleteById")
	public void deleteById(Model model, String objId) {
		int count = testSchoolService.deleteObjectByID(objId);
		// 记录日志
		String data = null;
		if (count > 0) {
			data = "({msg:'Y',content:'删除成功!'})";
		}
		else {
			data = "({msg:'N',content:'删除失败!'})";
		}
		// 返回.
		ajaxJson(data);
	}

	@RequestMapping("updateById")
	public String updateById(Model model, TestSchool object) {
		testSchoolService.updateObjectByID(object, object.getId());
		return "redirect:find.html";
	}
	
}


