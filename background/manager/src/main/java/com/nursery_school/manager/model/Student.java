package com.nursery_school.manager.model;

import java.util.Date;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.contract
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String contract;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.address
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.in_date
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private Date inDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.parent_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.student_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.father_tel
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String fatherTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.mather_tel
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String matherTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.father_name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String fatherName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.mather_name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String matherName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.birthday
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.gender
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_student.class_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    private String classId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.id
     *
     * @return the value of t_student.id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.id
     *
     * @param id the value for t_student.id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.name
     *
     * @return the value of t_student.name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.name
     *
     * @param name the value for t_student.name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.contract
     *
     * @return the value of t_student.contract
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getContract() {
        return contract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.contract
     *
     * @param contract the value for t_student.contract
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setContract(String contract) {
        this.contract = contract == null ? null : contract.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.address
     *
     * @return the value of t_student.address
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.address
     *
     * @param address the value for t_student.address
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.in_date
     *
     * @return the value of t_student.in_date
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public Date getInDate() {
        return inDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.in_date
     *
     * @param inDate the value for t_student.in_date
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.parent_id
     *
     * @return the value of t_student.parent_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.parent_id
     *
     * @param parentId the value for t_student.parent_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.student_id
     *
     * @return the value of t_student.student_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.student_id
     *
     * @param studentId the value for t_student.student_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.father_tel
     *
     * @return the value of t_student.father_tel
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getFatherTel() {
        return fatherTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.father_tel
     *
     * @param fatherTel the value for t_student.father_tel
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setFatherTel(String fatherTel) {
        this.fatherTel = fatherTel == null ? null : fatherTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.mather_tel
     *
     * @return the value of t_student.mather_tel
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getMatherTel() {
        return matherTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.mather_tel
     *
     * @param matherTel the value for t_student.mather_tel
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setMatherTel(String matherTel) {
        this.matherTel = matherTel == null ? null : matherTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.father_name
     *
     * @return the value of t_student.father_name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.father_name
     *
     * @param fatherName the value for t_student.father_name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.mather_name
     *
     * @return the value of t_student.mather_name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getMatherName() {
        return matherName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.mather_name
     *
     * @param matherName the value for t_student.mather_name
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setMatherName(String matherName) {
        this.matherName = matherName == null ? null : matherName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.birthday
     *
     * @return the value of t_student.birthday
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.birthday
     *
     * @param birthday the value for t_student.birthday
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.gender
     *
     * @return the value of t_student.gender
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.gender
     *
     * @param gender the value for t_student.gender
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_student.class_id
     *
     * @return the value of t_student.class_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public String getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_student.class_id
     *
     * @param classId the value for t_student.class_id
     *
     * @mbg.generated Sat Sep 28 15:39:12 CST 2019
     */
    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
}