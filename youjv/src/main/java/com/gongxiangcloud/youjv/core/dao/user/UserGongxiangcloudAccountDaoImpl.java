package com.gongxiangcloud.youjv.core.dao.user;

import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.user.UserGongxiangcloudAccount;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxiong on 16/10/10.
 */
@Repository
public class UserGongxiangcloudAccountDaoImpl extends BaseDao implements IUserGongxiangcloudAccountDao {
    public UserGongxiangcloudAccount queryByUid(Long uid) {
        String hql = "from UserGongxiangcloudAccount a where a.uid = :uid";
        UserGongxiangcloudAccount gongxiangcloudAccount = (UserGongxiangcloudAccount) this.getSession().createQuery(hql)//
            .setParameter("uid",uid)//
            .uniqueResult();
        return gongxiangcloudAccount;
    }

    public void updateByUid(UserGongxiangcloudAccount account) {
        String hql = "update UserGongxiangcloud a set a.confirmedMoney = :confirmedMoney,a.unconfirmedMoney = unconfirmedMoney where a.uid = :uid";
        this.getSession().createQuery(hql)//
            .setParameter("confirmedMoney",account.getConfirmedMoney())//
            .setParameter("unconfirmedMoney",account.getUnconfirmedMoney())//
            .setParameter("uid",account.getUid())//
            .executeUpdate();
    }
}
