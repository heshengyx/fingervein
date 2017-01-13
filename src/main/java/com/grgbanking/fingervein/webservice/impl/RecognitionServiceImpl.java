package com.grgbanking.fingervein.webservice.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.fingervein.entity.Result;
import com.grgbanking.fingervein.webservice.IRecognitionService;

@WebService
public class RecognitionServiceImpl implements IRecognitionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecognitionServiceImpl.class);
	
	@Autowired
	private com.grgbanking.fingervein.service.IRecognitionService recognitionService;
	
	
	@Override
	public Result recognitionFingerVeinOneToOne(String json, String ipaddr) {
		//return recognitionService.recognitionFingerVeinOneToOne(json, ipaddr);
		return null;
	}

}
