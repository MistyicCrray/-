package com.nursery_school.manager.model;

public class Activity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_activity.id
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_activity.name
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_activity.detail
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    private String detail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_activity.id
     *
     * @return the value of t_activity.id
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_activity.id
     *
     * @param id the value for t_activity.id
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_activity.name
     *
     * @return the value of t_activity.name
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_activity.name
     *
     * @param name the value for t_activity.name
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_activity.detail
     *
     * @return the value of t_activity.detail
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_activity.detail
     *
     * @param detail the value for t_activity.detail
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}