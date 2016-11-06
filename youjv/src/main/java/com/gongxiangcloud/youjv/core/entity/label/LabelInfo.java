package com.gongxiangcloud.youjv.core.entity.label;

import javax.persistence.*;

/**
 * 标签详情表
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "label_info", schema = "sns", catalog = "")
public class LabelInfo {
    /** 自增ID*/
    private long id;
    /** 标签的名称*/
    private String labelName;
    /** 分类的等级:目前系统只会有二级分类*/
    private Integer level;
    /** 父级分类的ID,表内自关联*/
    private Long parentId;
    /** 标签所属的类型: 1.兴趣类标签;  2.技能类标签*/
    private Integer type;
    /** 用户引导默认加载: 1.需要, 0 不需要*/
    private Integer guideNeed;
    /** 兴趣爱好加载: 1.需要.;  0.不需要*/
    private Integer interestNeed;
    /** 技能引导加载: 1.需要; 0.不需要*/
    private Integer skillNeed;
    /** 标签所对就的色号*/
    private String colorCode;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LABEL_NAME", nullable = false, length = 30)
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Basic
    @Column(name = "LEVEL", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = true)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "TYPE", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "GUIDE_NEED", nullable = true)
    public Integer getGuideNeed() {
        return guideNeed;
    }

    public void setGuideNeed(Integer guideNeed) {
        this.guideNeed = guideNeed;
    }

    @Basic
    @Column(name = "INTEREST_NEED", nullable = true)
    public Integer getInterestNeed() {
        return interestNeed;
    }

    public void setInterestNeed(Integer interestNeed) {
        this.interestNeed = interestNeed;
    }

    @Basic
    @Column(name = "SKILL_NEED", nullable = true)
    public Integer getSkillNeed() {
        return skillNeed;
    }

    public void setSkillNeed(Integer skillNeed) {
        this.skillNeed = skillNeed;
    }

    @Basic
    @Column(name = "COLOR_CODE", nullable = true, length = 10)
    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelInfo labelInfo = (LabelInfo) o;

        if (id != labelInfo.id) return false;
        if (labelName != null ? !labelName.equals(labelInfo.labelName) : labelInfo.labelName != null) return false;
        if (level != null ? !level.equals(labelInfo.level) : labelInfo.level != null) return false;
        if (parentId != null ? !parentId.equals(labelInfo.parentId) : labelInfo.parentId != null) return false;
        if (type != null ? !type.equals(labelInfo.type) : labelInfo.type != null) return false;
        if (guideNeed != null ? !guideNeed.equals(labelInfo.guideNeed) : labelInfo.guideNeed != null) return false;
        if (interestNeed != null ? !interestNeed.equals(labelInfo.interestNeed) : labelInfo.interestNeed != null)
            return false;
        if (skillNeed != null ? !skillNeed.equals(labelInfo.skillNeed) : labelInfo.skillNeed != null) return false;
        if (colorCode != null ? !colorCode.equals(labelInfo.colorCode) : labelInfo.colorCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (labelName != null ? labelName.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (guideNeed != null ? guideNeed.hashCode() : 0);
        result = 31 * result + (interestNeed != null ? interestNeed.hashCode() : 0);
        result = 31 * result + (skillNeed != null ? skillNeed.hashCode() : 0);
        result = 31 * result + (colorCode != null ? colorCode.hashCode() : 0);
        return result;
    }
}
