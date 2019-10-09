package com.nursery_school.manager.mapper;

import com.nursery_school.manager.model.Staff;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface StaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_staff
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    @Delete({
        "delete from t_staff",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_staff
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    @Insert({
        "insert into t_staff (id, work_number, ",
        "id_card)",
        "values (#{id,jdbcType=VARCHAR}, #{workNumber,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR})"
    })
    int insert(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_staff
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    @Select({
        "select",
        "id, work_number, id_card",
        "from t_staff",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="work_number", property="workNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR)
    })
    Staff selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_staff
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    @Select({
        "select",
        "id, work_number, id_card",
        "from t_staff"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="work_number", property="workNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR)
    })
    List<Staff> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_staff
     *
     * @mbg.generated Thu Oct 03 10:53:54 CST 2019
     */
    @Update({
        "update t_staff",
        "set work_number = #{workNumber,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Staff record);
    
    @SelectProvider(type = com.nursery_school.manager.model.dyna.StaffDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="work_number", property="workNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR)
    })
	List<Staff> findByDyna(Map<String, Object> map);
    
    @UpdateProvider(type = com.nursery_school.manager.model.dyna.StaffDynaProvider.class, method = "updateProvider")
	void updateProvider(Map<String, Object> map);
}