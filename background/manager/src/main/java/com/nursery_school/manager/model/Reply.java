package com.nursery_school.manager.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

public class Reply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.communication_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    private String communicationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.to_user_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    private String toUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.send_user_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    private String sendUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.create_date
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.content
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.id
     *
     * @return the value of t_reply.id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public String getId() {
        return id;
    }
    
    @Transient
    private User toUser;
    
    @Transient
    private User user;
    
    public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.id
     *
     * @param id the value for t_reply.id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.communication_id
     *
     * @return the value of t_reply.communication_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public String getCommunicationId() {
        return communicationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.communication_id
     *
     * @param communicationId the value for t_reply.communication_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public void setCommunicationId(String communicationId) {
        this.communicationId = communicationId == null ? null : communicationId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.to_user_id
     *
     * @return the value of t_reply.to_user_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.to_user_id
     *
     * @param toUserId the value for t_reply.to_user_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId == null ? null : toUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.send_user_id
     *
     * @return the value of t_reply.send_user_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.send_user_id
     *
     * @param sendUserId the value for t_reply.send_user_id
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.create_date
     *
     * @return the value of t_reply.create_date
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.create_date
     *
     * @param createDate the value for t_reply.create_date
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.content
     *
     * @return the value of t_reply.content
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.content
     *
     * @param content the value for t_reply.content
     *
     * @mbg.generated Thu Oct 03 17:33:18 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}