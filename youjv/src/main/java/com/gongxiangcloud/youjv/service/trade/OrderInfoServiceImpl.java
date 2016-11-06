package com.gongxiangcloud.youjv.service.trade;

import com.gongxiangcloud.youjv.core.dao.trade.IOrderInfoDao;
import com.gongxiangcloud.youjv.core.entity.trade.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
    @Autowired
    private IOrderInfoDao orderInfoDao;

    public boolean insertOrderInfo(OrderInfo orderInfo) {
        orderInfoDao.insert(orderInfo);
        return true;
    }

    public boolean deleteOrderInfoById(Long id) {
        orderInfoDao.deleteById(id);
        return true;
    }

    public boolean updateOrderInfoById(Long id, OrderInfo orderInfo) {
        orderInfo.setId(id);
        orderInfoDao.updateById(orderInfo);
        return true;
    }

    public OrderInfo queryOrderInfoById(Long id) {
        return orderInfoDao.queryById(id);
    }

    public List<OrderInfo> queryOrderInfoByIdList(List<Long> idList) {
        List<OrderInfo> list = orderInfoDao.queryByIdList(idList);
        if(list == null){
            return new ArrayList<OrderInfo>();
        }
        return list;
    }
}
