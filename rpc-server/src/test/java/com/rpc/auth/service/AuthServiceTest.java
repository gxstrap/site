package com.rpc.auth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rpc.auth.model.User;
import com.rpc.framework.base.Page;
import com.rpc.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-dao-datasource.xml", "classpath*:spring/applicationContext-dao-transaction.xml", "classpath*:spring/applicationContext-mybatis.xml", "classpath*:spring/applicationContext.xml" })
@ActiveProfiles("development")
public class AuthServiceTest {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceTest.class);

    @Autowired
    private AuthService authService;

    @Test
    public void paginateUser() {
        try {
            Page<User> page = new Page<User>();
            Map<String, Object> paramMap = new HashMap<String, Object>();

            Date endTime = DateUtil.getSystemDateTime();
            Date startTime = DateUtil.addDate(endTime, -100);

            paramMap.put("startTime", startTime);
            paramMap.put("endTime", endTime);
            page.setParamMap(paramMap);
            page = authService.paginateUser(page);
            if (page != null) {
                log.warn("#  taotalPage = {}", page.getTotalPage());
                log.warn("#  taotalCount = {}", page.getTotalCount());
                List<User> users = page.getResultList();
                for (User u : users) {
                    log.warn("# id={} , userName={}", u.getId(), u.getUserName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void user() {
        try {
            List<User> list1 = new ArrayList<User>();
            list1.add(new User("1000100400000000003","wangxin","王鑫","infowangxin@139.com","123456"));
            User wx = new User();
            wx.setId("1000100400000000003");
            wx.setLoginName("wangxin");
            wx.setUserName("王鑫");
            wx.setEmail("infowangxin@139.com");
            wx.setPassword("123456");

            User zs = new User();
            zs.setId("1000100400000000004");
            zs.setLoginName("zhangsan");
            zs.setUserName("张三");
            zs.setEmail("zhangsan@139.com");
            zs.setPassword("123456");
            authService.add(wx, zs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
