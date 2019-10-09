package com.nursery_school.manager.model;

import org.springframework.data.annotation.Transient;

public class Staff {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_staff.id
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_staff.work_number
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    private String workNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_staff.id_card
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    private String idCard;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_staff.id
     *
     * @return the value of t_staff.id
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    public String getId() {
        return id;
    }
    
    @Transient
    private User user;
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_staff.id
     *
     * @param id the value for t_staff.id
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_staff.work_number
     *
     * @return the value of t_staff.work_number
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_staff.work_number
     *
     * @param workNumber the value for t_staff.work_number
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber == null ? null : workNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_staff.id_card
     *
     * @return the value of t_staff.id_card
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_staff.id_card
     *
     * @param idCard the value for t_staff.id_card
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }
}