package com.zw.malldemo.dao;

import com.zw.malldemo.entity.LocalAuth;
import com.zw.malldemo.entity.PersonInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LocalAuthDaoTest {
    @Autowired
    private LocalAuthDao localAuthDao;
    private static final String username = "testusername";
    private static final String password = "testpassword";

    @Test
    public void testInsertLocalAuth(){
        // 新增一条平台帐号信息
        LocalAuth localAuth=new LocalAuth();
        PersonInfo personInfo=new PersonInfo();
        personInfo.setUserId(1L);
        // 给平台帐号绑定上用户信息
        localAuth.setPersonInfo(personInfo);
        // 设置上用户名和密码
        localAuth.setUsername(username);
        localAuth.setPassword(password);
        localAuth.setCreateTime(new Date());
        int effectNum=localAuthDao.insertLocalAuth(localAuth);
        assertEquals(1, effectNum);
    }

    @Test
    public void testQueryLocalByUserNameAndPwd(){
        // 按照帐号和密码查询用户信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
        assertEquals("测试", localAuth.getPersonInfo().getName());
    }

    @Test
    public void testQueryLocalByUserId(){
        // 按照用户Id查询平台帐号，进而获取用户信息
        LocalAuth localAuth=localAuthDao.queryLocalByUserId(1L);
        assertEquals("测试",localAuth.getPersonInfo().getName());
    }

    @Test
    public void testUpdateLocalAuth(){
        // 依据用户Id,平台帐号，以及旧密码修改平台帐号密码
        Date now=new Date();
        int effectNum=localAuthDao.updateLocalAuth(1L,username,password,password+"new",now);
        assertEquals(1, effectNum);
        // 查询出该条平台帐号的最新信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
        System.out.println(localAuth.getPassword());
    }
}
