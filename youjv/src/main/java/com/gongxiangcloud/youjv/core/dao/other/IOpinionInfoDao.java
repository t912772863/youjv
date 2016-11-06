package com.gongxiangcloud.youjv.core.dao.other;

import com.gongxiangcloud.youjv.core.entity.other.OpinionInfo;

/**
 * Created by tianxiong on 16/10/9.
 */
public interface IOpinionInfoDao {
    /**
     * 新增一条数据
     * @param opinionInfo
     */
    public void insert(OpinionInfo opinionInfo);

    /**
     * 根据ID删除数据
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 根据ID更新数据
     * @param opinionInfo
     */
    public void updateById(OpinionInfo opinionInfo);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    public OpinionInfo queryById(Long id);
}
