package com.gongxiangcloud.youjv.service.label;

import com.gongxiangcloud.youjv.common.business.SystemConstantInside;
import com.gongxiangcloud.youjv.core.dao.label.ILabelInfoDao;
import com.gongxiangcloud.youjv.core.entity.label.LabelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianxiong on 16/10/10.
 */
@Service
public class LabelInfoServiceImpl implements ILabelInfoService {
    @Autowired
    private ILabelInfoDao labelInfoDao;

    public LabelInfo insertLabelIfNeed(LabelInfo labelInfo) {
        //根据标签的名字判断该标签是否存在,如果存在,把原来的返回,就不要插入重复的了
        LabelInfo label = labelInfoDao.queryLabelInfoByLalelName(labelInfo.getLabelName());
        if(label == null){
            labelInfo.setColorCode(SystemConstantInside.LABEL_COLOR_DEFAULT);
            labelInfo.setLevel(2);
            labelInfoDao.insert(labelInfo);

            return labelInfoDao.queryLabelInfoByLalelName(labelInfo.getLabelName());
        }

        return label;
    }

    public boolean deleteLabelInfoById(Long id) {
        labelInfoDao.deleteById(id);
        return true;
    }

    public boolean updateLabelInfoById(Long id, LabelInfo labelInfo) {
        labelInfo.setId(id);
        labelInfoDao.updateById(labelInfo);
        return true;
    }

    public LabelInfo queryLabelInfoById(Long id) {

        return labelInfoDao.queryById(id);
    }

    public List<LabelInfo> queryLabel(Integer level, String type) {
        return labelInfoDao.queryLabel(level, type);
    }
}
