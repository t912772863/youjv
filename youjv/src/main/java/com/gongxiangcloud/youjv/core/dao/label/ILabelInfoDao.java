package com.gongxiangcloud.youjv.core.dao.label;

import com.gongxiangcloud.youjv.core.entity.label.LabelInfo;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface ILabelInfoDao {
    /**
     * 新增一条数据
     * @param labelInfo
     */
    public void insert(LabelInfo labelInfo);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param labelInfo
     */
    public void updateById(LabelInfo labelInfo);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public LabelInfo queryById(Long id);

    /**
     * 综合查询标签接口
     * @param level
     * @param type
     * @return
     */
    public List<LabelInfo> queryLabel(Integer level,String type);

    /**
     * 根据标签名查询标签
     * @param labelName
     * @return
     */
    public LabelInfo queryLabelInfoByLalelName(String labelName);
}
