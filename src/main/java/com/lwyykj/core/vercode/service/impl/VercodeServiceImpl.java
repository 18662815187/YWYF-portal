package com.lwyykj.core.vercode.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.common.GetRealIp;
import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.bean.utils.SmsRecord;
import com.lwyykj.core.bean.utils.SmsUtils;
import com.lwyykj.core.bean.utils.Vercode;
import com.lwyykj.core.bean.utils.VercodeQuery;
import com.lwyykj.core.bean.utils.VercodeQuery.Criteria;
import com.lwyykj.core.dao.user.UserDao;
import com.lwyykj.core.dao.utils.SmsRecordDao;
import com.lwyykj.core.dao.utils.VercodeDao;
import com.lwyykj.core.sms.TemplateSms;
import com.lwyykj.core.sms.utils.RandomUtil;
import com.lwyykj.core.vercode.service.VercodeService;

@Service("vercodeService")
@Transactional
public class VercodeServiceImpl implements VercodeService {
	@Resource
	private VercodeDao vercodeDao;
	@Resource
	private SmsRecordDao SmsRecordDao;
	@Resource
	private UserDao userDao;

	// 查询
	@Override
	public Vercode selectByTel(String tel, HttpServletRequest request) throws Exception {
		// String ipAddr = GetRealIp.getIpAdrress(request);
		VercodeQuery vercodeQuery = new VercodeQuery();
		Criteria createCriteria = vercodeQuery.createCriteria();
		createCriteria.andTelEqualTo(tel);
		List<Vercode> selectByExample = vercodeDao.selectByExample(vercodeQuery);
		if (null != selectByExample && selectByExample.size() > 0) {
			return selectByExample.get(0);
		}
		return null;
	}

	//注册短信验证码
	@Override
	public SmsUtils sendSms(String tel, HttpServletRequest request) throws Exception {
		int now = (int) (new Date().getTime() / 1000);
		String ipAdrress = GetRealIp.getIpAdrress(request);
		SmsUtils smsUtils = new SmsUtils();
		SmsRecord smsRecord = new SmsRecord();
		// 获取请求是从哪里来的
//		String referer = request.getHeader("referer");
//		System.out.println(referer);
		int result = SmsRecordDao.selectByIp(ipAdrress, now - 120, now);
		int result1 = SmsRecordDao.selectByTel(tel, now - 120, now);
		if (null != tel && !"".equals(tel)) {
			if (result > 5 || result1 > 5) {
				// 识别码1002，短时间内操作次数过多
				smsUtils.setResult(1002);
				smsUtils.setMsg("系统检测到您在短时间内操作次数过多，请稍后重试!");
				return smsUtils;
			} else {
				User user = userDao.selectByTel(tel);
				if(null!=user){
					// 识别码1010，用户已存在
					smsUtils.setResult(1010);
					smsUtils.setMsg("用户已存在,请更换手机号重试!");
					return smsUtils;
				}else{
					Vercode vercode = vercodeDao.selectByTel(tel);
					if (null != vercode) {
						String code = RandomUtil.randomFor6();
						String randomUUID = UUID.randomUUID().toString();
						vercodeDao.deleteByPrimaryKey(vercode.getId());
						Vercode vercode2 = new Vercode();
						vercode2.setCode(code);
						vercode2.setTel(tel);
						vercode2.setSendTime(now);
						// 5分钟内有效
						vercode2.setExpireTime(now + 300);
						vercode2.setToken(randomUUID);
						smsRecord.setTel(tel);
						smsRecord.setAddtime(now);
						smsRecord.setIp(ipAdrress);
						smsRecord.setAddtime((int) (new Date().getTime() / 1000));
						SmsRecordDao.insertSelective(smsRecord);
						vercodeDao.insertSelective(vercode2);
						Object sendSms = TemplateSms.sendSms(tel, code);
						smsUtils.setRes_code(sendSms);
						smsUtils.setToken(randomUUID);
						// 识别码1000
						smsUtils.setResult(1000);
						smsUtils.setMsg("短信发送成功，请注意查收!");
						return smsUtils;
					} else {
						String code = RandomUtil.randomFor6();
						String randomUUID = UUID.randomUUID().toString();
						Vercode vercode2 = new Vercode();
						vercode2.setCode(code);
						vercode2.setTel(tel);
						vercode2.setSendTime(now);
						// 5分钟内有效
						vercode2.setExpireTime(now + 300);
						vercode2.setToken(randomUUID);
						vercodeDao.insertSelective(vercode2);
						Object sendSms = TemplateSms.sendSms(tel, code);
						smsUtils.setRes_code(sendSms);
						smsUtils.setToken(randomUUID);
						// 识别码1000
						smsUtils.setResult(1000);
						smsUtils.setMsg("短信发送成功，请注意查收!");
						return smsUtils;
					}
				}
				
			}
		} else {
			smsUtils.setMsg("手机号不能为空!");
			smsUtils.setResult(1005);
			return smsUtils;
		}
	}
	
	
	//重置密码
	@Override
	public SmsUtils czPwd(String tel, HttpServletRequest request) throws Exception {
		int now = (int) (new Date().getTime() / 1000);
		String ipAdrress = GetRealIp.getIpAdrress(request);
		SmsUtils smsUtils = new SmsUtils();
		SmsRecord smsRecord = new SmsRecord();
		// 获取请求是从哪里来的
//		String referer = request.getHeader("referer");
//		System.out.println(referer);
		int result = SmsRecordDao.selectByIp(ipAdrress, now - 120, now);
		int result1 = SmsRecordDao.selectByTel(tel, now - 120, now);
		if (null != tel && !"".equals(tel)) {
			if (result > 5 || result1 > 5) {
				// 识别码1002，短时间内操作次数过多
				smsUtils.setResult(1002);
				smsUtils.setMsg("系统检测到您在短时间内操作次数过多，请稍后重试!");
				return smsUtils;
			} else {
				User user = userDao.selectByTel(tel);
				if(null==user||"".equals(user)){
					// 识别码1010，用户存在
					smsUtils.setResult(1010);
					smsUtils.setMsg("用户不存在,请核对手机号重试!");
					return smsUtils;
				}else{
					Vercode vercode = vercodeDao.selectByTel(tel);
					if (null != vercode) {
						String code = RandomUtil.randomFor6();
						String randomUUID = UUID.randomUUID().toString();
						vercodeDao.deleteByPrimaryKey(vercode.getId());
						Vercode vercode2 = new Vercode();
						vercode2.setCode(code);
						vercode2.setTel(tel);
						vercode2.setSendTime(now);
						// 5分钟内有效
						vercode2.setExpireTime(now + 300);
						vercode2.setToken(randomUUID);
						smsRecord.setTel(tel);
						smsRecord.setAddtime(now);
						smsRecord.setIp(ipAdrress);
						smsRecord.setAddtime((int) (new Date().getTime() / 1000));
						SmsRecordDao.insertSelective(smsRecord);
						vercodeDao.insertSelective(vercode2);
						Object sendSms = TemplateSms.sendSms(tel, code);
						smsUtils.setRes_code(sendSms);
						smsUtils.setToken(randomUUID);
						// 识别码1000
						smsUtils.setResult(1000);
						smsUtils.setMsg("短信发送成功，请注意查收!");
						return smsUtils;
					} else {
						String code = RandomUtil.randomFor6();
						String randomUUID = UUID.randomUUID().toString();
						Vercode vercode2 = new Vercode();
						vercode2.setCode(code);
						vercode2.setTel(tel);
						vercode2.setSendTime(now);
						// 5分钟内有效
						vercode2.setExpireTime(now + 300);
						vercode2.setToken(randomUUID);
						vercodeDao.insertSelective(vercode2);
						Object sendSms = TemplateSms.sendSms(tel, code);
						smsUtils.setRes_code(sendSms);
						smsUtils.setToken(randomUUID);
						// 识别码1000
						smsUtils.setResult(1000);
						smsUtils.setMsg("短信发送成功，请注意查收!");
						return smsUtils;
					}
				}
				
			}
		} else {
			smsUtils.setMsg("手机号不能为空!");
			smsUtils.setResult(1005);
			return smsUtils;
		}
	}

}
