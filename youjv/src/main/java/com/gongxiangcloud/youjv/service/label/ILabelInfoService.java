package com.gongxiangcloud.youjv.service.label;

import com.gongxiangcloud.youjv.core.entity.label.LabelInfo;

import java.util.List;

/**
 * 标签对应业务层
 * Created by tianxiong on 16/10/9.
 */
public interface ILabelInfoService {
    /**
     * 如果标签不存在,新增;
     * 如果存在,直接查出来返回
     * @param labelInfo
     * @return
     */
    public LabelInfo insertLabelIfNeed(LabelInfo labelInfo);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteLabelInfoById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param labelInfo
     * @return
     */
    public boolean updateLabelInfoById(Long id,LabelInfo labelInfo);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public LabelInfo queryLabelInfoById(Long id);

    /**
     * 综合查询标签接口
     * @param level
     * @param type
     * @return
     */
    public List<LabelInfo> queryLabel(Integer level,String type);
}
