package com.gongxiangcloud.youjv.core.dao.trade;

import com.gongxiangcloud.youjv.core.entity.trade.OrderInfo;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IOrderInfoDao {
    /**
     * 新增一条数据
     * @param orderInfo
     */
    public void insert(OrderInfo orderInfo);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param orderInfo
     */
    public void updateById(OrderInfo orderInfo);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public OrderInfo queryById(Long id);

    /**
     * 根据ID集合查询出所有订单
     * @param idList
     * @return
     */
    public List<OrderInfo> queryByIdList(List<Long> idList);
}
