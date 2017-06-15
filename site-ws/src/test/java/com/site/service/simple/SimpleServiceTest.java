package com.site.service.simple;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.site.entity.simple.News;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-dao-datasource.xml", "classpath*:spring/applicationContext-dao-transaction.xml", "classpath*:spring/applicationContext-mybatis.xml", "classpath*:spring/applicationContext.xml" })
public class SimpleServiceTest {

    private static final Logger log = LoggerFactory.getLogger(SimpleServiceTest.class);

    @Autowired
    private SimpleService simpleService;

    @Test
    public void testSaveNews() {
        try {
            News n = new News();
            n.setTitle("test");
            n.setDescription("test");
            n.setAddress("test");
            n.setNewsTime(Calendar.getInstance().getTime());
            boolean flag = simpleService.saveNews(n);
            log.debug("# flag={}", flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
