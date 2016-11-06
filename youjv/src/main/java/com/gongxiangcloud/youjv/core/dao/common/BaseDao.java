package com.gongxiangcloud.youjv.core.dao.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by tianxiong on 16/10/9.
 */
public class BaseDao {
    private HibernateTemplate hibernateTemplate;

    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    protected Session getSession() {

        return hibernateTemplate.getSessionFactory().openSession();
    }
}
