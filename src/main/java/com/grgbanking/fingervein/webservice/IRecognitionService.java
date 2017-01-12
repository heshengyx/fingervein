package com.grgbanking.fingervein.webservice;

import javax.jws.WebService;

import com.grgbanking.fingervein.entity.Result;

@WebService
public interface IRecognitionService {

	/**
     * 识别指静脉(one-to-one)
     * @param json
     * @param ipaddr
     * @return
     */
    Result recognitionFingerVeinOneToOne(String json, String ipaddr);
}
