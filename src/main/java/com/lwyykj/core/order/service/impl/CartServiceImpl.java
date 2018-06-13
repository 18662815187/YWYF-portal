package com.lwyykj.core.order.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.product.Sku;
import com.lwyykj.core.bean.shop.BuyerCart;
import com.lwyykj.core.bean.shop.BuyerItem;
import com.lwyykj.core.bean.shop.OrderUtil;
import com.lwyykj.core.bean.shop.ProShop;
import com.lwyykj.core.bean.shop.ShopCart;
import com.lwyykj.core.bean.shop.ShopCartQuery;
import com.lwyykj.core.bean.shop.ShopCartQuery.Criteria;
import com.lwyykj.core.bean.text.MailFee;
import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.dao.order.OrderDao;
import com.lwyykj.core.dao.order.OrderProductDao;
import com.lwyykj.core.dao.pharmacy.PharmacyDao;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.product.SkuDao;
import com.lwyykj.core.dao.shop.ShopCartDao;
import com.lwyykj.core.dao.text.MailFeeDao;
import com.lwyykj.core.dao.user.MailListDao;
import com.lwyykj.core.order.service.CartService;

/**
 * 
 * @author yl 2018.5.14 购物车服务
 *
 */

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {
	@Resource
	private ProductDao productDao;
	@Resource
	private SkuDao skuDao;
	@Resource
	private PharmacyDao pharmacyDao;
	@Resource
	private ShopCartDao shopCartDao;
	@Resource
	private MailFeeDao mailFeeDao;
	@Resource
	private OrderProductDao orderProductDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private MailListDao mailListDao;

	// 添加进购物车
	@Override
	public void addToCart(Integer skuId, Integer amount, Integer preId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Jedis jedis = jedisPool.getResource();
		// @RequestBody、@ResponseBody JSON与对象互转,声明ObjectMapper对象
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		// 声明购物车
		BuyerCart buyerCart = null;
		// 1.从Request中取Cookies,遍历Cookie 取出之前的购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			// 遍历Cookie 取出之前的购物车
			for (Cookie cookie : cookies) {
				// 2.判断cookie中有没有购物车,如果购物车的name和cookie中name一样则表示有购物车
				if (Constants.BUYER_CART.equals(cookie.getName())) {
					// 转回对象
					buyerCart = om.readValue(cookie.getValue(), BuyerCart.class);
					// 节省性能找到直接结束
					break;
				}
			}
		}
		// 判断购物车是否为null
		if (null == buyerCart) {
			buyerCart = new BuyerCart();
		}
		// 追加当前款商品
		Sku sku1 = new Sku();
		Sku sku = skuDao.selectByPrimaryKey(skuId);
		sku1.setId(skuId);
		sku1.setSpec(sku.getSpec());
		sku1.setPrice(sku.getPrice());
		sku1.setProId(sku.getProId());
		sku1.setStock(sku.getStock());
		BuyerItem buyerItem = new BuyerItem();
		Product product = productDao.selectByPrimaryKey(sku.getProId());
		if (null != product) {
			buyerItem.setPhId(product.getPhId());
			// System.out.println(product.getPhId()+"**********phid");
		} else {
			buyerItem.setPhId(0);
		}
		buyerItem.setPreId(preId);
		buyerItem.setSku(sku1);
		// Amount数量
		buyerItem.setAmount(amount);
		// 追加商品到购物车
		buyerCart.addItem(buyerItem);
		// 用户是否登录
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		// 判断是否登录
		if (null != uid && uid > 0) {
			// 有 把购物车内商品添加到redis的购物车中，
			// 判断购物项的长度大于0
			// List<BuyerItem> items = buyerCart.getItems();
			// if (items.size() > 0) {
			// for (BuyerItem buyerItem1 : items) {
			// // 判断是否已经存在
			// if (jedis.hexists("buyerCart:" + uid,
			// String.valueOf(buyerItem1.getSku().getId()))) {
			// // 如果已存在则同款加数量
			// jedis.hincrBy("buyerCart:" + uid,
			// String.valueOf(buyerItem1.getSku().getId()),
			// buyerItem1.getAmount());
			// } else {
			// // 如果redis不存在相同商品则直接添加
			// jedis.hset("buyerCart:" + uid,
			// String.valueOf(buyerItem1.getSku().getId()),
			// String.valueOf(buyerItem1.getAmount()));
			// }
			// }
			this.insertToSql(buyerCart, uid);
			// }
			// jedis.bgsave();
			// jedis.flushAll();
			// jedis.close();
			// 清理cookie
			Cookie cookie = new Cookie(Constants.BUYER_CART, null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		} else {
			// 如果没有创建购物车
			// 创建cookie
			Writer w = new StringWriter();
			om.writeValue(w, buyerCart);
			Cookie cookie = new Cookie(Constants.BUYER_CART, w.toString());
			// 设置时间,开发期间设置为1天,以秒计算
			cookie.setMaxAge(60 * 60 * 24);
			// 设置路径
			cookie.setPath("/");
			// 跨域
			// cookie.setDomain(Constants.DOMAIN);
			// 保存cookie写回浏览器
			response.addCookie(cookie);
		}
	}

	// 提取redis的购物车
	@Override
	public List<ProShop> selectFromRedis(Integer uid) throws JsonParseException, JsonMappingException, IOException {
		// Jedis jedis = jedisPool.getResource();
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		BuyerCart buyerCart = new BuyerCart();
		List<ProShop> proShops = new ArrayList<>();
		// Map<String, String> hgetAll = jedis.hgetAll("buyerCart:" + uid);
		// if (null != hgetAll) {
		// Set<Entry<String, String>> entrySet = hgetAll.entrySet();
		// for (Entry<String, String> entry : entrySet) {
		// // 追加当前商品到购物车
		// Sku sku = new Sku();
		// // id
		// sku.setId(Integer.parseInt(entry.getKey()));
		// BuyerItem buyerItem = new BuyerItem();
		// buyerItem.setSku(sku);
		// // Amount
		// buyerItem.setAmount(Integer.parseInt(entry.getValue()));
		// // 塞进购物车
		// buyerCart.addItem(buyerItem);
		// }
		// }
		ShopCart shopCart = this.findByUId(uid);
		if (null != shopCart) {
			buyerCart = om.readValue(shopCart.getCarInfo(), BuyerCart.class);
			List<BuyerItem> items = buyerCart.getItems();
			// System.out.println(items.size());
			Map<Integer, List<BuyerItem>> map = new HashMap<>();
			for (BuyerItem buyerItem : items) {
				List<BuyerItem> tempList = map.get(buyerItem.getPhId());
				if (tempList == null) {
					tempList = new ArrayList<>();
					tempList.add(buyerItem);
					map.put(buyerItem.getPhId(), tempList);
				} else {
					tempList.add(buyerItem);
				}
			}
			List<List<BuyerItem>> lists = new ArrayList<>();
			for (Object key : map.keySet()) {
				lists.add(map.get(key));
			}

			for (List<BuyerItem> buyerItem : lists) {
				for (BuyerItem buyerItem2 : buyerItem) {
					buyerItem2.setProduct(productDao
							.selectByPrimaryKey(skuDao.selectByPrimaryKey(buyerItem2.getSku().getId()).getProId()));
				}
				ProShop proShop = new ProShop();
				proShop.setBuyerItems(buyerItem);
				// System.out.println(buyerItem.size()+"购物车数据长度"+buyerItem.get(0).getAmount());
				proShop.setPhId(buyerItem.get(0).getPhId());
				// System.out.println(buyerItem.get(0).getPhId());
				proShop.setPhName((pharmacyDao.selectByPrimaryKey(buyerItem.get(0).getPhId())).getPharmacyName());
				proShops.add(proShop);
			}
			return proShops;
		} else {
			return null;
		}

	}

	// 保存到数据库
	@Override
	public int saveToCart(ShopCart shopCart) {
		return shopCartDao.insertSelective(shopCart);
	}

	// 通过用户ID查询购物车
	@Override
	public ShopCart findByUId(Integer id) {
		ShopCartQuery shopCartQuery = new ShopCartQuery();
		Criteria createCriteria = shopCartQuery.createCriteria();
		createCriteria.andUidEqualTo(id);
		List<ShopCart> shopCarts = shopCartDao.selectByExample(shopCartQuery);
		if (shopCarts.size() > 0 && null != shopCarts) {
			return shopCarts.get(0);
		}
		return null;
	}

	// 更新购物车
	@Override
	public int update(ShopCart shopCart) {
		return shopCartDao.updateByPrimaryKey(shopCart);
	}

	// 插入数据
	@Override
	public int insertToSql(BuyerCart buyerCart, Integer uid) throws Exception {
		List<BuyerItem> buyerItems = buyerCart.getItems();
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		Integer result = 0;
		ShopCart shopCart = this.findByUId(uid);
		if (null != shopCart) {
			String carInfo = shopCart.getCarInfo();
			BuyerCart buyerCart2 = om.readValue(carInfo, BuyerCart.class);
			List<BuyerItem> items = buyerCart2.getItems();
			for (BuyerItem buyerItem : buyerItems) {
				// 判断同款
				if (items.contains(buyerItem)) {
					// 如果现在的购物项包含准备加入的购物项则合并添加数量
					for (BuyerItem it : items) {
						if (it.equals(buyerItem)) {
							// 叠加数量
							Integer r = buyerItem.getAmount() + it.getAmount();
							// 重新设置数量
							it.setAmount(r);
						}
					}
				} else {
					items.add(buyerItem);
				}
			}

			buyerCart2.setItems(items);
			String json1 = JSON.toJSONString(buyerCart2);
			shopCart.setCarInfo(json1);
			result = shopCartDao.updateByPrimaryKeySelective(shopCart);
		} else {
			String Jstring = JSON.toJSONString(buyerCart);
			ShopCart shopCart2 = new ShopCart();
			shopCart2.setCarInfo(Jstring);
			shopCart2.setUid(uid);
			result = shopCartDao.insertSelective(shopCart2);
		}
		return result;
	}

	// 删除购物车内指定产品(单删、批删)都OK
	@Override
	public int delBySkuId(Integer[] skuIds, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		int result = 0;
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		// String username = (String)
		// request.getSession().getAttribute(Constants.USER_NAME);
		if (uid != null && uid > 0) {
			if (null != skuIds && !"".equals(skuIds)) {
				ShopCart shopCart = this.findByUId(uid);
				String carInfo = shopCart.getCarInfo();
				BuyerCart bCart = om.readValue(carInfo, BuyerCart.class);
				List<BuyerItem> items = bCart.getItems();
				for (int i = 0; i < items.size(); i++) {
					for (Integer id : skuIds) {
						if (items.get(i).getSku().getId().equals(id)) {
							items.remove(i);
						}
					}
				}
				bCart.setItems(items);
				shopCart.setCarInfo(JSONObject.toJSONString(bCart));
				result = shopCartDao.updateByPrimaryKey(shopCart);
			} else {
				result = -2;
			}

		} else {
			result = -1;
		}
		return result;
	}

	// 清空购物车
	@Override
	public int delAll(Integer uid) {
		ShopCartQuery shopCartQuery = new ShopCartQuery();
		Criteria createCriteria = shopCartQuery.createCriteria();
		createCriteria.andUidEqualTo(uid);
		return shopCartDao.deleteByExample(shopCartQuery);
	}

	// 修改购物车内产品数量
	@Override
	public int modify(Integer skuId, Integer amount, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		// System.out.println(amount);
		int result = 0;
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		// String username = (String)
		// request.getSession().getAttribute(Constants.USER_NAME);
		if (uid != null && uid > 0) {
			ShopCart shopCart = this.findByUId(uid);
			String carInfo = shopCart.getCarInfo();
			BuyerCart bCart = om.readValue(carInfo, BuyerCart.class);
			List<BuyerItem> items = bCart.getItems();
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getSku().getId() == skuId) {
					items.get(i).setAmount(amount);
				}
			}
			bCart.setItems(items);
			shopCart.setCarInfo(JSONObject.toJSONString(bCart));
			result = shopCartDao.updateByPrimaryKey(shopCart);
		} else {
			result = -1;
		}
		return result;
	}

	// 购物车去确认页
	@Override
	public OrderUtil selectBySkuIds(Integer[] ids, Integer uid, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {

		OrderUtil orderUtil = new OrderUtil();
		// Integer uid = (Integer) request.getSession().getAttribute("uid");
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		BuyerCart buyerCart = new BuyerCart();
		List<ProShop> proShops = new ArrayList<>();
		ShopCart shopCart = this.findByUId(uid);
		buyerCart = om.readValue(shopCart.getCarInfo(), BuyerCart.class);
		List<BuyerItem> items = buyerCart.getItems();
		List<BuyerItem> items2 = new ArrayList<>();
		Map<Integer, List<BuyerItem>> map = new HashMap<>();
		// 判断是否为空
		// System.out.println(items.size() + "数据库中购物车数据量");
		if (null != items && items.size() > 0) {
			// skuid相等了重新组合进一个list
			for (BuyerItem buyerItem : items) {
				for (Integer id : ids) {
					// System.out.println(buyerItem.getSku().getId()+"----"+id);
					if (buyerItem.getSku().getId().equals(id)) {
						// System.out.println(buyerItem.getSku().getId());
						items2.add(buyerItem);
					}
				}
			}
			// System.out.println(ids.length + "传入的ID");
			// System.out.println(items2.size() + "根据ID搜索后提取的购物车数据");
			// 分组
			Boolean flag = true;
			if (null != items2 && items2.size() > 0) {
				for (BuyerItem buyerItem : items2) {
					if (buyerItem.getAmount() > buyerItem.getSku().getStock()) {
						buyerItem.setIsHave(false);
						flag = false;
					}
					List<BuyerItem> tempList = map.get(buyerItem.getPhId());
					if (tempList == null) {
						tempList = new ArrayList<>();
						tempList.add(buyerItem);
						map.put(buyerItem.getPhId(), tempList);
					} else {
						tempList.add(buyerItem);
					}
				}
				List<List<BuyerItem>> lists = new ArrayList<>();
				for (Object key : map.keySet()) {
					lists.add(map.get(key));
				}
				// 补全回显信息
				for (List<BuyerItem> buyerItem : lists) {
					Double totalfee = 0d;
					String msg = null;
					for (BuyerItem buyerItem2 : buyerItem) {
						buyerItem2.setProduct(productDao
								.selectByPrimaryKey(skuDao.selectByPrimaryKey(buyerItem2.getSku().getId()).getProId()));
						totalfee += buyerItem2.getSku().getPrice() * buyerItem2.getAmount();
					}
					List<MailFee> mailFees = mailFeeDao.selectByPhId(buyerItem.get(0).getProduct().getPhId());
					Double mailfee1 = 0d;
					if (null != mailFees && mailFees.size() > 0) {
						MailFee mailFee = mailFees.get(0);
						if (mailFee.getTopUp() > 0d && totalfee >= mailFee.getTopUp()) {
							mailfee1 = 0d;
							msg = "满" + mailFee.getTopUp() + "包邮";
						} else {
							mailfee1 = mailFee.getMoney();
							if (mailfee1 > 0d) {
								msg = "需要运费";
							} else {
								msg = "包邮";
							}
						}
					} else {
						msg = "包邮";
						mailfee1 = 0d;
					}

					ProShop proShop = new ProShop();
					if (flag == false) {
						orderUtil.setStatus(-1);
					} else {
						orderUtil.setStatus(0);
					}
					proShop.setBuyerItems(buyerItem);
					proShop.setMailFee(mailfee1);
					proShop.setMsg(msg);
					// System.out.println(buyerItem.size()+"购物车数据长度"+buyerItem.get(0).getAmount());
					proShop.setPhId(buyerItem.get(0).getPhId());
					// System.out.println(buyerItem.get(0).getPhId());
					proShop.setPhName((pharmacyDao.selectByPrimaryKey(buyerItem.get(0).getPhId())).getPharmacyName());
					proShops.add(proShop);
				}
				// System.out.println(proShops.size() + "----");
				orderUtil.setProShops(proShops);
			}else{
				//回显集合为空请检查是否为ID不相等,可以考虑使用integer.intValue()
				orderUtil.setStatus(-2);
				orderUtil.setMsg("没有找到相符的产品");
			}

		}
		return orderUtil;
	}

	// 购物车提交订单
	@Override
	public OrderUtil catrtApply(Integer sendId, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		HttpSession session = request.getSession();
		Integer[] ids = (Integer[]) session.getAttribute("ids");
		Integer uid = (Integer) session.getAttribute("uid");
		OrderUtil orderUtil = new OrderUtil();
		ObjectMapper om = new ObjectMapper();
		List<String> ons = new ArrayList<>();
		List<Integer> oids = new ArrayList<>();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		BuyerCart buyerCart = new BuyerCart();
		ShopCart shopCart = this.findByUId(uid);
		buyerCart = om.readValue(shopCart.getCarInfo(), BuyerCart.class);
		List<BuyerItem> items = buyerCart.getItems();
		List<BuyerItem> items2 = new ArrayList<>();
		Map<Integer, List<BuyerItem>> map = new HashMap<>();
		Boolean flag = true;
		// 判断是否为空
		// System.out.println(items.size() + "数据库中购物车数据量");
		if (null != items && items.size() > 0) {
			// skuid相等了重新组合进一个list
			for (BuyerItem buyerItem : items) {
				for (Integer id : ids) {
					if (buyerItem.getAmount() > skuDao.selectByPrimaryKey(buyerItem.getSku().getId()).getStock()) {
						flag = false;
						break;
					} else if (buyerItem.getSku().getId().equals(id)) {
						items2.add(buyerItem);
					}
				}
			}
			// 判断库存标签是否为false
			if (flag == false) {
				// -1库存不足跳转确认页并显示库存不足
				orderUtil.setStatus(-1);
				orderUtil.setMsg("库存不足!");
				session.setAttribute("ids", ids);
				return orderUtil;
			} else {
				for (BuyerItem buyerItem : items2) {
					List<BuyerItem> tempList = map.get(buyerItem.getPhId());
					if (tempList == null) {
						tempList = new ArrayList<>();
						tempList.add(buyerItem);
						map.put(buyerItem.getPhId(), tempList);
					} else {
						tempList.add(buyerItem);
					}
				}
				List<List<BuyerItem>> lists = new ArrayList<>();
				for (Object key : map.keySet()) {
					lists.add(map.get(key));
				}

				Boolean flag1 = true;
				Double totalFee = 0d;
				Double totals = 0d;
				if (null != lists && lists.size() > 0) {
					for (List<BuyerItem> bis : lists) {
						Order order = new Order();
						order.setAddtime((int) (new Date().getTime() / 1000));
						order.setStoreId(bis.get(0).getPhId());
						order.setIsDel(false);
						// 订单号前携带uid确保高并发不重复
						order.setOrderNum(uid + Constants.getOrderNum());
						// 支付统一流水号即支付商家订单号
						// order.setPayNum(uid+Constants.getOrderNum());
						order.setOrderStatus(0);
						order.setUid(uid);
						order.setSendId(sendId);
						int b = orderDao.insertSelective(order);
						// 用于在支付选择页面回显的订单号
						ons.add(order.getOrderNum());
						// 用于传输给支付平台的订单串
						oids.add(order.getId());
						if (b > 0) {
							Double total = 0d;
							for (BuyerItem buyerItem : bis) {
								OrderProduct orderProduct = new OrderProduct();
								orderProduct.setAddtime((int) (new Date().getTime() / 1000));
								orderProduct.setOid(order.getId());
								orderProduct.setDocId(buyerItem.getDocId());
								orderProduct.setNum(buyerItem.getAmount());
								orderProduct.setPreId(buyerItem.getPreId());
								orderProduct.setPrice(buyerItem.getSku().getPrice());
								orderProduct.setIsOnline(true);
								orderProduct.setIsDel(false);
								orderProduct.setRefundStatus(0);
								orderProduct.setSkuid(buyerItem.getSku().getId());
								int a = orderProductDao.insertSelective(orderProduct);
								total += buyerItem.getAmount() * buyerItem.getSku().getPrice();
								// 处理库存
								if (a > 0) {
									Sku sku = skuDao.selectByPrimaryKey(buyerItem.getSku().getId());
									sku.setStock(sku.getStock() - buyerItem.getAmount());
									int c = skuDao.updateByPrimaryKey(sku);
									if (c < 0) {
										orderUtil.setStatus(7);
										// 暂时先通过msg记录，之后需要给后台发送信息
										orderUtil.setMsg("库存处理失败!");
									}
									orderUtil.setStatus(1);
									orderUtil.setMsg("订单生成成功!");
								} else {
									flag1 = false;
									// 小单生成异常
									orderUtil.setStatus(4);
									orderUtil.setMsg("详单生成异常!");
								}
							}
							// 计算是否需要运费或是否满足免运费条件
							List<MailFee> mailFees = mailFeeDao.selectByPhId(lists.get(0).get(0).getPhId());
							Double mailfee1 = 0d;
							if (null != mailFees && mailFees.size() > 0) {
								MailFee mailFee = mailFees.get(0);
								if (mailFee.getTopUp() > 0d && total >= mailFee.getTopUp()) {
									totalFee = total;

								} else {
									mailfee1 = mailFee.getMoney();
									if (mailfee1 > 0d) {
										totalFee = total + mailfee1;
									} else {
										totalFee = total;
									}
								}
							} else {
								totalFee = total;
							}
							// System.out.println(totalFee);
							// 更新主单的总金额
							int d = orderDao.updateByOid(order.getId(), totalFee);
							if (d > 0) {
								totals += totalFee;

							}

						} else {
							flag1 = false;
							// 订单大单生成异常
							orderUtil.setStatus(5);
							orderUtil.setMsg("主订单生成异常!");
						}

					}
				} else {
					flag1 = false;
					// 新生成的分组信息为空,订单生成失败
					orderUtil.setStatus(2);
					orderUtil.setMsg("获取商品信息失败!");

				}
				// 订单生成成功移除购物车中商品
				// System.out.println(ids);
				if (flag1 == true) {
					for (Integer id : ids) {
						for (int i = 0; i < items.size(); i++) {
							if (items.get(i).getSku().getId().equals(id)) {
								items.remove(i);
							}
						}
					}
					MailList mailList = mailListDao.selectByPrimaryKey(sendId);
					String ons1 = StringUtils.join(ons.toArray(), ",");
					String oids1 = StringUtils.join(oids.toArray(), ",");
					orderUtil.setProName("处方外配平台订单支付");
					orderUtil.setMailList(mailList);
					orderUtil.setTotalFee(totals);
					orderUtil.setOids(oids1);
					orderUtil.setOns(ons1);
					buyerCart.setItems(items);
					shopCart.setCarInfo(JSONObject.toJSONString(buyerCart));
					shopCartDao.updateByPrimaryKey(shopCart);
				}

			}

		} else {
			// 3购物车为空
			orderUtil.setMsg("购物车为空!");
			orderUtil.setStatus(3);

		}
		return orderUtil;
	}
}
