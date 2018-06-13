package com.lwyykj.core.dao.user;

import com.lwyykj.core.bean.user.UserFavorite;
import com.lwyykj.core.bean.user.UserFavoriteQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFavoriteDao {
    int countByExample(UserFavoriteQuery example);

    int deleteByExample(UserFavoriteQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    List<UserFavorite> selectByExample(UserFavoriteQuery example);

    UserFavorite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFavorite record, @Param("example") UserFavoriteQuery example);

    int updateByExample(@Param("record") UserFavorite record, @Param("example") UserFavoriteQuery example);

    int updateByPrimaryKeySelective(UserFavorite record);

    int updateByPrimaryKey(UserFavorite record);
}