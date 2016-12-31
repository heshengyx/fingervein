package com.grgbanking.fingervein.worker;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.fingervein.entity.Result;
import com.grgbanking.fingervein.enums.OptEnum;
import com.grgbanking.fingervein.server.WorkServer;
import com.grgbanking.fingervein.service.IRecognitionService;

/**
 * 注册指静脉
 */
@Service
public class RegisterFingerVeinWorker extends WorkServer {
	
	@Autowired
	private IRecognitionService recognitionService;
	
	@PostConstruct
	public void init() {
		this.req = OptEnum.CreateFgVeinReq.name().toUpperCase();
		this.res = OptEnum.CreateFgVeinResp.name();
	}
	
	@Override
	protected Result process(String json, String ipaddr) {
		return recognitionService.registerFingerVein(json, ipaddr);
	}
}
