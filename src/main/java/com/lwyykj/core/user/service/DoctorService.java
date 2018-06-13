package com.lwyykj.core.user.service;

import com.lwyykj.core.bean.doctor.Doctor;

public interface DoctorService {
	//主键查询
	Doctor selectByPrimary(Integer id);
}
