package com.gongxiangcloud.youjv.core.dao.trade;

import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.trade.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class OrderInfoDaoImpl extends BaseDao implements IOrderInfoDao {
    public void insert(OrderInfo orderInfo) {
        this.getHibernateTemplate().save(orderInfo);
    }

    public void deleteById(Long id) {
        String hql = "update OrderInfo a set a.status = -1 where a.id = :id";
        this.getSession().createQuery(hql)//
            .setParameter("id",id)//
            .executeUpdate();
    }

    public void updateById(OrderInfo orderInfo) {
        OrderInfo orderInfoOld = queryById(orderInfo.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(orderInfoOld,orderInfo));
    }

    public OrderInfo queryById(Long id) {
        return this.getHibernateTemplate().get(OrderInfo.class,id);
    }

    public List<OrderInfo> queryByIdList(List<Long> idList) {
        String hql = "from OrderInfo a where a.id in :idList";

        List<OrderInfo> list = this.getSession().createQuery(hql)//
            .setParameterList("idList",idList)//
            .list();

        return list;
    }
}

