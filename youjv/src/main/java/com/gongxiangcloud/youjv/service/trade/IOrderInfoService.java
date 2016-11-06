package com.gongxiangcloud.youjv.service.trade;

import com.gongxiangcloud.youjv.core.entity.trade.OrderInfo;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IOrderInfoService {
    /**
     * 新增一个
     * @param orderInfo
     * @return
     */
    public boolean insertOrderInfo(OrderInfo orderInfo);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteOrderInfoById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param orderInfo
     * @return
     */
    public boolean updateOrderInfoById(Long id,OrderInfo orderInfo);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public OrderInfo queryOrderInfoById(Long id);

    /**
     * 根据ID集合,批量查询出对应的订单信息
     * @param idList
     * @return
     */
    public List<OrderInfo> queryOrderInfoByIdList(List<Long> idList);

}
