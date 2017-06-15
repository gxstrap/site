package com.site.service.simple.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.site.common.constants.Constants;
import com.site.common.framework.datasource.DataSource;
import com.site.common.framework.datasource.DataSourceEnum;
import com.site.common.framework.key.FactoryAboutKey;
import com.site.common.framework.key.table.TableNameEnum.Master;
import com.site.common.framework.key.table.TableNameEnum.Slave;
import com.site.entity.simple.News;
import com.site.mapper.simple.NewsMapper;
import com.site.service.simple.NewsService;

/** 
 * @Description 新闻接口实现类
 * @author 王鑫 
 * @date Mar 16, 2017 5:19:24 PM  
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsMapper newsMapper;

    // ---- master

    @DataSource(DataSourceEnum.MASTER)
    @Transactional
    @Override
    public boolean addNews(News news) {
        if (news != null) {
            news.setId(FactoryAboutKey.getPkByMasterDB(Master.T_NEWS));
            news.setIsDel(Constants.IS_DEL_N);
            news.setCreateTime(Calendar.getInstance().getTime());
            int flag = newsMapper.insert(news);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @DataSource(DataSourceEnum.MASTER)
    @Override
    public boolean editNews(News news) {
        if (news != null && StringUtils.isNotBlank(news.getId())) {
            int flag = newsMapper.update(news);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @DataSource(DataSourceEnum.MASTER)
    @Override
    public boolean deleteNewsById(String id) {
        if (StringUtils.isNotBlank(id)) {
            int flag = newsMapper.delete(id);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @DataSource(DataSourceEnum.MASTER)
    @Override
    public News findNewsById(String id) {
        if (StringUtils.isBlank(id))
            return null;
        else
            return newsMapper.findById(id);
    }

    @DataSource(DataSourceEnum.MASTER)
    @Override
    public PageInfo<News> findNewsByPage(Integer pageNum, String keywords) {
        if (pageNum == null)
            pageNum = 1;
        PageHelper.startPage(pageNum, Constants.defaultPageSize);
        List<News> news = newsMapper.findNewsByPage(keywords);
        PageInfo<News> page = new PageInfo<News>(news);
        log.info("# 查询默认数据库 page.toString()={}", page.toString());
        return page;
    }

    // ---- slave

    @DataSource(DataSourceEnum.SLAVE)
    @Transactional
    @Override
    public boolean addSlaveNews(News news) {
        if (news != null) {
            news.setId(FactoryAboutKey.getPkBySlaveDB(Slave.T_NEWS));
            news.setIsDel(Constants.IS_DEL_N);
            news.setCreateTime(Calendar.getInstance().getTime());
            int flag = newsMapper.insert(news);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @DataSource(DataSourceEnum.SLAVE)
    @Override
    public boolean editSlaveNews(News news) {
        if (news != null && StringUtils.isNotBlank(news.getId())) {
            int flag = newsMapper.update(news);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @DataSource(DataSourceEnum.SLAVE)
    @Override
    public boolean deleteSlaveNewById(String id) {
        if (StringUtils.isNotBlank(id)) {
            int flag = newsMapper.delete(id);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @DataSource(DataSourceEnum.SLAVE)
    @Override
    public News findSlaveNewsById(String id) {
        if (StringUtils.isBlank(id))
            return null;
        else
            return newsMapper.findById(id);
    }

    @DataSource(DataSourceEnum.SLAVE)
    @Override
    public PageInfo<News> findSlaveNewsByPage(Integer pageNum, String keywords) {
        if (pageNum == null)
            pageNum = 1;
        PageHelper.startPage(pageNum, Constants.defaultPageSize);
        List<News> news = newsMapper.findNewsByPage(keywords);
        PageInfo<News> page = new PageInfo<News>(news);
        log.info("# 查询默认数据库 page.toString()={}", page.toString());
        return page;
    }

}
