package com.grgbanking.fingervein.worker;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.fingervein.entity.Result;
import com.grgbanking.fingervein.enums.OptEnum;
import com.grgbanking.fingervein.server.WorkServer;
import com.grgbanking.fingervein.service.IRecognitionService;

/**
 * 心跳
 */
@Service
public class HeartbeatWorker extends WorkServer {

	@Autowired
	private IRecognitionService recognitionService;

	@PostConstruct
	public void init() {
		this.req = OptEnum.HeartBeat.name().toUpperCase();
		this.res = OptEnum.HeartBeat.name();
	}

	@Override
	protected Result process(String json, String ipaddr) {
		recognitionService.heartbeat(json, ipaddr);
		return null;
	}

}
