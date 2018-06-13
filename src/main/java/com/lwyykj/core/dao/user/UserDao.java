package com.lwyykj.core.dao.user;

import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.bean.user.UserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
	int countByExample(UserQuery example);

	int deleteByExample(UserQuery example);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserQuery example);

	User selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

	int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	// 单删更新删除状态
	int upById(Integer id);

	// 批量删除
	int upByIds(Integer[] ids);
	//批量已审
	int auditByIds(Integer[] ids);
	//批量屏蔽
	int shieldByIds(Integer[] ids);
	//根据主键查询部分字段昵称、头像
	User selectById(Integer id);
	//根据手机号查询
	User selectByTel(String tel);
}