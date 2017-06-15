package com.site.mapper.simple;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.site.common.framework.mybatis.mapper.BaseMapper;
import com.site.entity.simple.News;


/** 
 * @Description 新闻mapper接口
 * @author 王鑫 
 * @date Mar 16, 2017 3:35:19 PM  
 */
@Repository
public interface NewsMapper extends BaseMapper<String, News> {

    List<News> findNewsByPage(@Param("keywords") String keywords);

}
