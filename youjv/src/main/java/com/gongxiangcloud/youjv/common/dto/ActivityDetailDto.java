package com.gongxiangcloud.youjv.common.dto;

import com.gongxiangcloud.youjv.core.entity.user.UserInfo;

import java.util.Date;
import java.util.List;

/**
 * 活动详情数据传输对象
 * Created by tianxiong on 16/10/14.
 */
public class ActivityDetailDto {
    /**自增ID,活动的唯一标识 */
    private long id;
    /**活动名称*/
    private String name;
    /**活动发起人ID*/
    private long createUid;
    /**数据创建时间(活动创建时间)*/
    private Date createTime;
    /**修改时间*/
    private Date updateTime;
    /**活动开始时间*/
    private Date startTime;
    /**活动结束时间*/
    private Date endTime;
    /**报名截止时间*/
    private Date applyEndTime;
    /**活动最多可以参与的人数*/
    private Integer maxMember;
    /**活动最少参与的人数*/
    private Integer minMember;
    /**活动费用(单位:分)*/
    private Integer fee;
    /**活动内容*/
    private String context;
    /**活动内容插入的图片的链接*/
    private String contextImage;
    /**活动的发布地址(高德地图经纬度)*/
    private String issueLocation;
    /**活动的举行地址(高德地图经纬度)*/
    private String holdLocation;
    /**地点附近的标志建筑*/
    private String marks;
    /**活动地点的中文描述详细地址*/
    private String address;
    /**分享次数*/
    private int shareTime;
    /**阅读数*/
    private int readTime;
    /**数据状态: -1:删除; 1正常*/
    private int status;
    /**活动状态: -1活动已取消; 1活动报名中; 2报名截止(等待审核中); 3名单已确认(活动准备中); 4活动进行中; 5活动已结束; 6活动未成行*/
    private int activityStatus;
    /**活动创建者*/
    private UserInfo createUser;
    /**活动参与者*/
    private List<ActivityParticipantDto> activityParticipantDtoList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(long createUid) {
        this.createUid = createUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Integer getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(Integer maxMember) {
        this.maxMember = maxMember;
    }

    public Integer getMinMember() {
        return minMember;
    }

    public void setMinMember(Integer minMember) {
        this.minMember = minMember;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContextImage() {
        return contextImage;
    }

    public void setContextImage(String contextImage) {
        this.contextImage = contextImage;
    }

    public String getIssueLocation() {
        return issueLocation;
    }

    public void setIssueLocation(String issueLocation) {
        this.issueLocation = issueLocation;
    }

    public String getHoldLocation() {
        return holdLocation;
    }

    public void setHoldLocation(String holdLocation) {
        this.holdLocation = holdLocation;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShareTime() {
        return shareTime;
    }

    public void setShareTime(int shareTime) {
        this.shareTime = shareTime;
    }

    public int getReadTime() {
        return readTime;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }

    public UserInfo getCreateUser() {
        return createUser;
    }

    public void setCreateUser(UserInfo createUser) {
        this.createUser = createUser;
    }

    public List<ActivityParticipantDto> getActivityParticipantDtoList() {
        return activityParticipantDtoList;
    }

    public void setActivityParticipantDtoList(List<ActivityParticipantDto> activityParticipantDtoList) {
        this.activityParticipantDtoList = activityParticipantDtoList;
    }
}
