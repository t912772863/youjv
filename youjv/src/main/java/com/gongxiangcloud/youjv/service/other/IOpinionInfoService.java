package com.gongxiangcloud.youjv.service.other;

import com.gongxiangcloud.youjv.core.entity.other.OpinionInfo;

/**
 * 系统反馈消息的业务层
 * Created by tianxiong on 16/10/9.
 */
public interface IOpinionInfoService {
    /**
     * 新增一个
     * @param opinionInfo
     * @return
     */
    public boolean insertOpinionInfo(OpinionInfo opinionInfo);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteOpinionInfoById(Long id);

    /**
     * 根据ID更新
     * @param id
     * @param opinionInfo
     * @return
     */
    public boolean updateOpinionInfoById(Long id,OpinionInfo opinionInfo);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public OpinionInfo queryOpinionInfoById(Long id);
}
