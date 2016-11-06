package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.user.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianxiong on 16/10/7.
 */
@Repository
public class UserInfoDaoImpl extends BaseDao implements IUserInfoDao {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public UserInfo queryById(Long id) {
        UserInfo UserInfo = this.getHibernateTemplate().get(UserInfo.class,id);
        return UserInfo;
    }

    public void insert(UserInfo UserInfo) {
        this.getHibernateTemplate().save(UserInfo);
    }

    public void deleteById(Long id) {
        String hql = "update UserInfo a set a.statsu = -1 where a.id = :id";
        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();

    }

    public void updateById(UserInfo userInfo) {
        UserInfo userInfoOld = queryById(userInfo.getUid());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(userInfoOld,userInfo));
    }

    public List<UserInfo> queryByUidList(List<Long> uidList) {
        // 当参数是一个集合时
        List list = this.getSession().createQuery("from UserInfo a where a.uid in (:uidList)")//
                .setParameterList("uidList",uidList)//
                .list();

        return list;
    }
}
