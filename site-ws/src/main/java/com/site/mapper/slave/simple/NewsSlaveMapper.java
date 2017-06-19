package com.site.mapper.slave.simple;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.site.entity.simple.News;
import com.site.mapper.SqlMapper;


/** 
 * @Description 新闻mapper接口
 * @author 王鑫 
 * @date Mar 16, 2017 3:35:19 PM  
 */
@Repository
public interface NewsSlaveMapper extends SqlMapper {

    List<News> findNewsByPage(@Param("keywords") String keywords);

    int insert(News news);

    int update(News news);

    int delete(String id);

    News findById(String id);

}
