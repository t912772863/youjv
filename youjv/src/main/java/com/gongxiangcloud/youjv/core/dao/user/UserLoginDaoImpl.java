package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import com.gongxiangcloud.youjv.core.entity.user.UserLogin;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/10.
 */
@Repository
public class UserLoginDaoImpl extends BaseDao implements IUserLoginDao {
    public void insert(UserLogin userLogin) {
        this.getHibernateTemplate().save(userLogin);
    }

//    public void deleteById(Long id) {
//
//    }
//
    public void updateByUid(UserLogin userLogin) {
        UserLogin userLoginOld = queryByUid(userLogin.getUid());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(userLoginOld,userLogin));
    }

    public UserLogin queryByUid(Long uid) {
        return this.getHibernateTemplate().get(UserLogin.class,uid);
    }

    public UserLogin queryByMobile(String mobile) {
        String hql = "from UserLogin a where a.mobile = :mobile";
        return (UserLogin)this.getSession().createQuery(hql).setParameter("mobile",mobile).uniqueResult();
    }

    public UserLogin queryByMobileAndPassword(String mobile, String password) {
        String hql = "from UserLogin a where a.mobile = :mobile and a.password = :password";
        UserLogin userLogin = (UserLogin)this.getSession().createQuery(hql)//
            .setParameter("mobile",mobile)//
            .setParameter("password",password)//
            .uniqueResult();

        return userLogin;
    }

    public UserLogin queryByUidAndPassword(Long uid, String password) {
        String hql = "from UserLogin a where a.uid = :uid and a.password = :password";
        UserLogin userLogin = (UserLogin)this.getSession().createQuery(hql)//
            .setParameter("uid",uid)//
            .setParameter("password",password)//
            .uniqueResult();
        return userLogin;
    }
}
