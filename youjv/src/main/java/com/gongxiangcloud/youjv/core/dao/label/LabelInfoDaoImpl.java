package com.gongxiangcloud.youjv.core.dao.label;

import com.gongxiangcloud.youjv.common.business.BusinessException;
import com.gongxiangcloud.youjv.common.business.SystemConstantOutside;
import com.gongxiangcloud.youjv.common.utils.JavaBeanUtil;
import com.gongxiangcloud.youjv.core.dao.common.BaseDao;
import com.gongxiangcloud.youjv.core.entity.label.LabelInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianxiong on 16/10/9.
 */
@Repository
public class LabelInfoDaoImpl extends BaseDao implements ILabelInfoDao {
    public void insert(LabelInfo labelInfo) {
        this.getHibernateTemplate().save(labelInfo);
    }

    public void deleteById(Long id) {
        this.getHibernateTemplate().delete(queryById(id));
    }

    public void updateById(LabelInfo labelInfo) {
        LabelInfo labelInfoOld = queryById(labelInfo.getId());
        this.getHibernateTemplate().update(JavaBeanUtil.fuseBeans(labelInfoOld,labelInfo));
    }

    public LabelInfo queryById(Long id) {
        return this.getHibernateTemplate().get(LabelInfo.class,id);
    }

    public List<LabelInfo> queryLabel(Integer level, String type) {
        //综合查询,hql不能写死要根据参数拼接

        String hql = "from LabelInfo a where a.level = :level and ";

        String subHql;
        if(SystemConstantOutside.LABEL_TYPE_GUIDE.equals(type)){
            subHql = "a.guideNeed = 1";
        }else if(SystemConstantOutside.LABEL_TYPE_INTEREST.equals(type)){
            subHql = "a.interestNeed = 1";
        }else if(SystemConstantOutside.LABEL_TYPE_SKILL.equals(type)){
            subHql = "a.skillNeed = 1";
        }else {
            throw new BusinessException("传入的参数有误,未知的标签引导类型");
        }
        hql += subHql;

        List<LabelInfo> labelInfoList = this.getSession().createQuery(hql)//
            .setParameter("level",level)//
            .list();

        return labelInfoList;
    }

    public LabelInfo queryLabelInfoByLalelName(String labelName) {
        String hql = "from LabelInfo a where a.lavelName = :labelName";

        return (LabelInfo) this.getSession().createQuery(hql)//
            .setParameter("labelName",labelName)//
            .uniqueResult();
    }
}
