package com.gongxiangcloud.youjv.service.other;

import com.gongxiangcloud.youjv.core.dao.other.IOpinionInfoDao;
import com.gongxiangcloud.youjv.core.entity.other.OpinionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class OpinionInfoServiceImpl implements IOpinionInfoService {
    @Autowired
    private IOpinionInfoDao opinionInfoDao;

    public boolean insertOpinionInfo(OpinionInfo opinionInfo) {
        opinionInfoDao.insert(opinionInfo);
        return true;
    }

    public boolean deleteOpinionInfoById(Long id) {
        opinionInfoDao.deleteById(id);
        return true;
    }

    public boolean updateOpinionInfoById(Long id, OpinionInfo opinionInfo) {
        opinionInfo.setId(id);
        opinionInfoDao.updateById(opinionInfo);
        return true;
    }

    public OpinionInfo queryOpinionInfoById(Long id) {
        return opinionInfoDao.queryById(id);
    }
}
