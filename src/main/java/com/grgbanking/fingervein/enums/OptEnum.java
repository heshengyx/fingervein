package com.grgbanking.fingervein.enums;

public enum OptEnum {

	// 创建人
	CreatePplReq, 
	CreatePplResp,
	// 创建指纹
	CreateFgVeinReq, 
	CreateFgVeinResp,
	// 匹配指纹
	MatchFgVeinReq, 
	MatchFgVeinResp,

	// 时间同步
	SyncTime,
	// 心跳
	HeartBeat,
	// 只用密码
	OnlyPwdCheck,
	// 指纹
	FINGER,

	// 传送消息
	Ftping,

	// 确认消息
	FtpEnd,

	// 升级消息
	UpgradeFile,

	// 升级开始
	UpgradeStart,

	// 升级结束
	UpgradeOver,

	// 文件开始
	UpgradeFileStart,

	// 文件结束
	UpgradeFileEnd,
	
	SYSTEM;
}
