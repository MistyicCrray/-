package com.nursery_school.manager.mapper;

import com.nursery_school.manager.model.Activity;
import com.nursery_school.manager.model.CleaningInfo;

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
public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_activity
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Delete({
        "delete from t_activity",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_activity
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Insert({
        "insert into t_activity (id, name, ",
        "detail)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{detail,jdbcType=VARCHAR})"
    })
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_activity
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Select({
        "select",
        "id, name, detail",
        "from t_activity",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR)
    })
    Activity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_activity
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Select({
        "select",
        "id, name, detail",
        "from t_activity"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR)
    })
    List<Activity> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_activity
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Update({
        "update t_activity",
        "set name = #{name,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Activity record);
    
    @SelectProvider(type = com.nursery_school.manager.model.dyna.ActivityDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR)
    })
    List<Activity> findByDyna(Map<String, Object> map);
    
    @UpdateProvider(type = com.nursery_school.manager.model.dyna.ActivityDynaProvider.class, method = "updateProvider")
    void updateProvider(Map<String, Object> map);
}