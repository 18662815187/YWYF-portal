package com.lwyykj.core.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.core.bean.user.Msg;
import com.lwyykj.core.dao.user.MsgDao;
import com.lwyykj.core.user.service.MsgService;

@Service("/msgService")
@Transactional
public class MsgServiceImpl implements MsgService {
	@Resource
	private MsgDao msgDao;

	// 查询指定用户和没有指定的所有信息
	@Override
	public List<Msg> selectAll(Integer uid) {
		List<Msg> msgs = msgDao.selectByUid(uid);
		return msgs;
	}

	// 更改已读休息状态
	@Override
	public int msgStatus(Integer msgId) {
		Msg msg = msgDao.selectByPrimaryKey(msgId);
		msg.setIsRead(1);
		return msgDao.updateByPrimaryKeySelective(msg);
	}
	//统计用户未读信息数量
	@Override
	public int counMsg(Integer uid) {
		return msgDao.countMsg(uid);
	}

}
