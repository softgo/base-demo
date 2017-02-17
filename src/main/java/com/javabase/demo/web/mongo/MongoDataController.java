package com.javabase.demo.web.mongo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javabase.demo.entity.mongo.MongoData;
import com.javabase.demo.service.mongo.MongoDataService;
import com.application.base.core.common.BaseController;
import com.application.base.core.constant.Constants;
import com.application.base.core.utils.CommonBeanUtils;
import com.application.base.utils.common.JSONUtils;
import com.application.base.utils.page.PageView;

/**
 * Controller
 * @author bruce
 */
@Controller
@RequestMapping("/background/mongoData/")
public class  MongoDataController extends BaseController {

	private final static Logger logger= LoggerFactory.getLogger(MongoDataController.class.getName());
	
	// Servrice start
	@Autowired
	private MongoDataService  mongoDataService; 
    
	@RequestMapping("findObjPage")
	public String findObjPage(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params =  nullAbleValidation(request, "");
	    PageView pageView = findByPage(params.get(Constants.SQLConstants.PAGE_NO).toString(),params.get(Constants.SQLConstants.PAGE_SIZE).toString());  
        pageView = mongoDataService.findObjsByPage(pageView, params);
		return "/background/mongoData/list";
	}
	
	@RequestMapping("findObjById")
    public void findObjById(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params =  nullAbleValidation(request, "id");
		MongoData mongoData =mongoDataService.findObjById(params.get("id"));
		//返回.
		ajaxJson(response,JSONUtils.toJson(mongoData));
    }
	
	@RequestMapping("findObjByProps")
	public void findObjByProps(HttpServletRequest request,HttpServletResponse response) {
		String data = null;
		try {
    		Map<String, Object> params =  nullAbleValidation(request, "");
            MongoData object = mongoDataService.findObjByProps(params);
            if (object != null) {
				data = "({msg:'Y',content:'按需求填写!'})";
			}else {
				data = "({msg:'N',content:'按需求填写!'})";
			}
			//返回.
			ajaxJson(response,data);
		} catch (Exception e) {
			logger.info("查找出错!"+e.getLocalizedMessage());
		}
	}
	
    @RequestMapping("addObjUI")
    public String addObjUI() {
        return "/background/mongoData/add";
    }
	
	@RequestMapping("addObjOne")
	public String addObjOne(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params = nullAbleValidation(request, "");
		MongoData mongoData = CommonBeanUtils.transMap2Bean(params, MongoData.class);
		mongoDataService.addObjOne(mongoData);
		return "redirect:find.html";
	}
	
	@RequestMapping("deleteObjById")
	public void deleteObjById(HttpServletRequest request,HttpServletResponse response) {
		String data = null;
        try {
        	Map<String, Object> params = nullAbleValidation(request, "id");
            boolean result = mongoDataService.deleteByObjId(params.get("id"));
            if (result ) {
                data = "({msg:'Y',content:'删除成功!'})";
            }else {
                data = "({msg:'N',content:'删除失败!'})";
            }
            //返回.
            ajaxJson(response,data);
        } catch (Exception e) {
            logger.info("查找出错!"+e.getLocalizedMessage());
        }
	}
	
	@RequestMapping("updateObjById")
	public String updateObjById(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params = nullAbleValidation(request, "id");
        mongoDataService.updateObjOne(params, params.get("id"));
		return "redirect:find.html";
	}
	
}
