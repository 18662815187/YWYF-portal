package com.lwyykj.core.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwyykj.core.bean.doctor.Doctor;
import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.solr.service.SolrService;
import com.lwyykj.core.user.service.DoctorService;

/**
 * 
 * @author yl 2018.4.27 医生控制器
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Resource
	private DoctorService doctorService;
	@Resource
	private SolrService solrService;
	
	//按id查询
	@RequestMapping("/query")
	public String query(Integer id, Model model) {
		Doctor doctor = doctorService.selectByPrimary(id);
		if (null != doctor) {
			model.addAttribute("doctor", doctor);
			return "/other/non_existent";
		} else {
			List<DisProduct> disProducts = solrService.queryByTypeId(null, true, 5);
			model.addAttribute("disProducts", disProducts);
			model.addAttribute("msg", "很抱歉，您搜索的医生不存在，可能已删除或者被转移。");
			return "/other/non_existent";
		}

	}
}
