package com.lwyykj.core.user.service;

import java.util.List;

import com.lwyykj.core.bean.user.Msg;

public interface MsgService {
	//查询发给用户或者所有人的信息
	List<Msg> selectAll(Integer uid);
	//修改已读状态
	int msgStatus(Integer msgId);
	//统计用户未读信息
	int counMsg(Integer uid);
}
