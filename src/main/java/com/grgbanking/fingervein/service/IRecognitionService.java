package com.grgbanking.fingervein.service;

import com.grgbanking.fingervein.entity.Result;

public interface IRecognitionService {

	/**
     * 心跳检测
     * @param json
     * @param ipaddr
     * @return
     */
    Result heartbeat(String json, String ipaddr);
    
    /**
     * 时间同步
     * @param json
     * @param ipaddr
     * @return
     */
    Result syncTime(String json, String ipaddr);
    
    /**
     * 注册人员
     * @param json
     * @param ipaddr
     * @return
     */
    Result registerEmployee(String json, String ipaddr);
    
    /**
     * 注册指静脉
     * @param json
     * @param ipaddr
     * @return
     */
    Result registerFingerVein(String json, String ipaddr);
    
    /**
     * 识别指静脉
     * @param json
     * @param ipaddr
     * @return
     */
    Result recognitionFingerVein(String json, String ipaddr);
    
    /**
     * 识别密码
     * @param json
     * @param ipaddr
     * @return
     */
    Result recognitionPassword(String json, String ipaddr);
}
