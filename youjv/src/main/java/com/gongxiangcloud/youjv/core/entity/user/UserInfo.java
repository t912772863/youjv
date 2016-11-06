package com.gongxiangcloud.youjv.core.entity.user;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tianxiong on 16/10/8.
 */
@Entity  //hibernate与表对应的实体在加上该注解
@Table(name = "user_info")  //指定对应的表名
public class UserInfo {
    /** 用户ID*/
    private Long uid;
    /** 性别：0女，1男*/
    private Integer sex;
    /** 邮箱*/
    private String email;
    /** 生日*/
    private Date birthday;
    /** 学历:0高中/中专及以下,1高中/中专,2专科,3本科*/
    private Integer degrees;
    /** 职业*/
    private String profession;
    /** 自我介绍*/
    private String introduce;
    /** 注册地点*/
    private String address;
    /** 用户头像链接地址*/
    private String headImage;
    /** 关联的第三方平台: 1.微信, 2.QQ, 3.新浪微博*/
    private Integer thirdType;
    /** 更新时间*/
    private Date updateTime;
    /** 创建时间*/
    private Date createTime;
    /** 应用与第三平台关联的openId*/
    private String openId;
    /** 数据状态: -1:删除, 1正常*/
    private Integer status;

    @Id //id主键加该注解
    @Column(name="UID", nullable = true)
    public Long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Column(name="SEX", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic(fetch = FetchType.EAGER)  //该注解指定这个属性的加载方式
    @Column(name = "DEGREES")
    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }


    @Column(name = "PROFESSION")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name = "INTRODUCE")
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "HEAD_IMAGE")
    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    @Column(name = "THIRD_TYPE")
    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "OPEN_ID")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (uid != userInfo.uid) return false;
        if (sex != userInfo.sex) return false;
        if (degrees != userInfo.degrees) return false;
        if (status != userInfo.status) return false;
        if (email != null ? !email.equals(userInfo.email) : userInfo.email != null) return false;
        if (birthday != null ? !birthday.equals(userInfo.birthday) : userInfo.birthday != null) return false;
        if (profession != null ? !profession.equals(userInfo.profession) : userInfo.profession != null) return false;
        if (introduce != null ? !introduce.equals(userInfo.introduce) : userInfo.introduce != null) return false;
        if (address != null ? !address.equals(userInfo.address) : userInfo.address != null) return false;
        if (headImage != null ? !headImage.equals(userInfo.headImage) : userInfo.headImage != null) return false;
        if (thirdType != null ? !thirdType.equals(userInfo.thirdType) : userInfo.thirdType != null) return false;
        if (updateTime != null ? !updateTime.equals(userInfo.updateTime) : userInfo.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(userInfo.createTime) : userInfo.createTime != null) return false;
        if (openId != null ? !openId.equals(userInfo.openId) : userInfo.openId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + sex;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + degrees;
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (headImage != null ? headImage.hashCode() : 0);
        result = 31 * result + (thirdType != null ? thirdType.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", degrees=" + degrees +
                ", profession='" + profession + '\'' +
                ", introduce='" + introduce + '\'' +
                ", address='" + address + '\'' +
                ", headImage='" + headImage + '\'' +
                ", thirdType=" + thirdType +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", openId='" + openId + '\'' +
                ", status=" + status +
                '}';
    }
}
