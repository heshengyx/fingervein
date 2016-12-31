package com.grgbanking.fingervein.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grgbanking.fingervein.param.RecognitionLogQueryParam;
import com.grgbanking.fingervein.service.IRecognitionLogService;
import com.grgbanking.fingervein.util.DateUtil;

@Controller
@RequestMapping("/manager/report")
public class ReportController extends BaseController {

	@Autowired
    private IRecognitionLogService recognitionLogService;
	
	@RequestMapping("/list")
    public String list(ModelMap model) {
		Date date = new Date();
    	model.put("dateBegin", DateUtil.getDay(date));
    	model.put("dateEnd", DateUtil.getDay(date));
        return "reportList";
    }
	
	@RequestMapping("/query")
    @ResponseBody
    public Object query(RecognitionLogQueryParam param) {
        return recognitionLogService.queryReport(param);
    }
}
