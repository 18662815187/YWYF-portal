package com.lwyykj.core.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.core.bean.product.OrderVerfiy;
import com.lwyykj.core.bean.product.Sku;
import com.lwyykj.core.bean.text.MailFee;
import com.lwyykj.core.dao.pharmacy.PharmacyDao;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.product.SkuDao;
import com.lwyykj.core.dao.text.MailFeeDao;
import com.lwyykj.core.product.service.SkuService;

/**
 * 
 * @author yl 2018.5.8 sku服务
 *
 */

@Service("skuService")
@Transactional
public class SkuServiceImpl implements SkuService {
	@Resource
	private SkuDao skuDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private PharmacyDao pharmacyDao;
	@Resource
	private MailFeeDao mailFeeDao;

	// 主键查询
	@Override
	public Sku selectByPrimary(Integer id) {
		return skuDao.selectByPrimaryKey(id);
	}

	// 立即下单
	@Override
	public List<OrderVerfiy> orderApply(Integer skuId, Integer amount) {
		OrderVerfiy orderVerfiy = new OrderVerfiy();
		List<OrderVerfiy> orderVerfiys = new ArrayList<>();
		List<Sku> skus = new ArrayList<>();
		Sku sku = skuDao.selectByPrimaryKey(skuId);
		sku.setNum(amount);
		if (amount > sku.getStock()) {
			sku.setIsHave(false);
			if (null != sku.getProId() && sku.getProId() > 0) {
				sku.setProduct(productDao.selectByPrimaryKey(sku.getProId()));
			}
			skus.add(sku);
			if (null != sku.getProduct().getPhId() && sku.getProduct().getPhId() > 0) {
				orderVerfiy.setPhId(sku.getProduct().getPhId());
				orderVerfiy.setPhName(pharmacyDao.selectByPrimaryKey(sku.getProduct().getPhId()).getPharmacyName());
				List<MailFee> mails = mailFeeDao.selectByPhId(sku.getProduct().getPhId());
				if (null != mails && mails.size() > 0) {
					MailFee mailFee = mails.get(0);
					if (sku.getProduct().getWhetherFee()) {
						orderVerfiy.setMailFee(0.00);
						orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
					} else {
						if (null != mailFee) {
							if (mailFee.getTopUp() > 0) {
								Double fee = sku.getPrice() * amount;
								if (fee >= mailFee.getTopUp()) {
									orderVerfiy.setMailFee(0.00);
									orderVerfiy.setMsg("(" + "<span style='color:red'>" + "满" + mailFee.getTopUp()
											+ "包邮" + "</span>" + ")");
								} else {
									orderVerfiy.setMailFee(mailFee.getMoney());
									orderVerfiy.setMsg("(" + "<span style='color:red'>" + "满" + mailFee.getTopUp()
											+ "包邮" + "</span>" + ")");
								}
							} else {
								orderVerfiy.setMailFee(0.00);
								orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
							}
						} else {
							orderVerfiy.setMailFee(0.00);
							orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
						}

					}
				} else {
					orderVerfiy.setMailFee(0.00);
					orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
				}

			}
		} else {
			sku.setIsHave(true);
			if (null != sku.getProId() && sku.getProId() > 0) {
				sku.setProduct(productDao.selectByPrimaryKey(sku.getProId()));
			}
			skus.add(sku);
			if (null != sku.getProduct().getPhId() && sku.getProduct().getPhId() > 0) {
				orderVerfiy.setPhId(sku.getProduct().getPhId());
				orderVerfiy.setPhName(pharmacyDao.selectByPrimaryKey(sku.getProduct().getPhId()).getPharmacyName());
				List<MailFee> mails = mailFeeDao.selectByPhId(sku.getProduct().getPhId());
				if (null != mails && mails.size() > 0) {
					MailFee mailFee = mails.get(0);
					if (sku.getProduct().getWhetherFee()) {
						orderVerfiy.setMailFee(0.00);
						orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
					} else {
						if (null != mailFee) {
							if (mailFee.getTopUp() > 0) {
								Double fee = sku.getPrice() * amount;
								if (fee >= mailFee.getTopUp()) {
									orderVerfiy.setMailFee(0.00);
									orderVerfiy.setMsg("(" + "<span style='color:red'>" + "满" + mailFee.getTopUp()
											+ "包邮" + "</span>" + ")");
								} else {
									orderVerfiy.setMailFee(mailFee.getMoney());
									orderVerfiy.setMsg("(" + "<span style='color:red'>" + "满" + mailFee.getTopUp()
											+ "包邮" + "</span>" + ")");
								}
							} else {
								orderVerfiy.setMailFee(0.00);
								orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
							}
						} else {
							orderVerfiy.setMailFee(0.00);
							orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
						}

					}
				} else {
					orderVerfiy.setMailFee(0.00);
					orderVerfiy.setMsg("(" + "<span style='color:red'>" + "包邮" + "</span>" + ")");
				}

			}
		}
		orderVerfiy.setSkus(skus);
		orderVerfiys.add(orderVerfiy);
		return orderVerfiys;
	}

	@Override
	public Sku findById(Integer id) {
		Sku sku = skuDao.selectByPrimaryKey(id);
		if(null!=sku){
			sku.setProduct(productDao.selectByPrimaryKey(sku.getProId()));
		}
		return sku;
	}

}
