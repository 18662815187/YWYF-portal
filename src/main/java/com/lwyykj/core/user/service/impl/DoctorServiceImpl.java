package com.lwyykj.core.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.core.bean.doctor.Doctor;
import com.lwyykj.core.dao.doctor.DoctorDao;
import com.lwyykj.core.user.service.DoctorService;

/**
 * 
 * @author yl 2018.4.27 医生服务
 *
 */
@Service("doctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {
	@Resource
	private DoctorDao doctorDao;

	@Override
	public Doctor selectByPrimary(Integer id) {
		return doctorDao.selectByPrimaryKey(id);
	}

}
