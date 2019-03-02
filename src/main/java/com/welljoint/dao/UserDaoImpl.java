package com.welljoint.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.welljoint.entity.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hbd(modify)
 * Dao实现
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    //HibernateDaoSupport来操作数据库更加方便

    /**
     * 用来注入sessionFactory（不注入会报错）
     *
     * @param sessionFactory
     */
    @Resource(name = "sessionFactory")
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public User find(String userName, String password) {
        //注意：以下是HQL语句
        List<?> users = getHibernateTemplate().find("from User where userName=? and password=?", userName, password);
        return users.size() > 0 ? (User) users.get(0) : null;

    }
}
