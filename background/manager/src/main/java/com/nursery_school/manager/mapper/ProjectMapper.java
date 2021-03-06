package com.nursery_school.manager.mapper;

import com.nursery_school.manager.model.CleaningInfo;
import com.nursery_school.manager.model.Project;
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
public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Delete({
        "delete from t_project",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Insert({
        "insert into t_project (id, name)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Select({
        "select",
        "id, name",
        "from t_project",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Project selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Select({
        "select",
        "id, name",
        "from t_project"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Project> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project
     *
     * @mbg.generated Tue Nov 26 20:23:43 CST 2019
     */
    @Update({
        "update t_project",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Project record);
    
    @SelectProvider(type = com.nursery_school.manager.model.dyna.ProjectDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Project> findByDyna(Map<String, Object> map);
    
    @UpdateProvider(type = com.nursery_school.manager.model.dyna.ProjectDynaProvider.class, method = "updateProvider")
    void updateProvider(Map<String, Object> map);
}