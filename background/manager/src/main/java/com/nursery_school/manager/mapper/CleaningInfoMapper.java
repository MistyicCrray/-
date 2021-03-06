package com.nursery_school.manager.mapper;

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
public interface CleaningInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cleaning_info
     *
     * @mbg.generated Wed Oct 02 19:06:01 CST 2019
     */
    @Delete({
        "delete from t_cleaning_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cleaning_info
     *
     * @mbg.generated Wed Oct 02 19:06:01 CST 2019
     */
    @Insert({
        "insert into t_cleaning_info (id, cleaning_id, ",
        "clean_start_time, clean_end_time, ",
        "staff_id, img)",
        "values (#{id,jdbcType=VARCHAR}, #{cleaningId,jdbcType=VARCHAR}, ",
        "#{cleanStartTime,jdbcType=TIMESTAMP}, #{cleanEndTime,jdbcType=TIMESTAMP}, ",
        "#{staffId,jdbcType=VARCHAR}, #{img,jdbcType=VARCHAR})"
    })
    int insert(CleaningInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cleaning_info
     *
     * @mbg.generated Wed Oct 02 19:06:01 CST 2019
     */
    @Select({
        "select",
        "id, cleaning_id, clean_start_time, clean_end_time, staff_id, img",
        "from t_cleaning_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="cleaning_id", property="cleaningId", jdbcType=JdbcType.VARCHAR),
        @Result(column="clean_start_time", property="cleanStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="clean_end_time", property="cleanEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.VARCHAR),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR)
    })
    CleaningInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cleaning_info
     *
     * @mbg.generated Wed Oct 02 19:06:01 CST 2019
     */
    @Select({
        "select",
        "id, cleaning_id, clean_start_time, clean_end_time, staff_id, img",
        "from t_cleaning_info"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="cleaning_id", property="cleaningId", jdbcType=JdbcType.VARCHAR),
        @Result(column="clean_start_time", property="cleanStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="clean_end_time", property="cleanEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.VARCHAR),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR)
    })
    List<CleaningInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cleaning_info
     *
     * @mbg.generated Wed Oct 02 19:06:01 CST 2019
     */
    @Update({
        "update t_cleaning_info",
        "set cleaning_id = #{cleaningId,jdbcType=VARCHAR},",
          "clean_start_time = #{cleanStartTime,jdbcType=TIMESTAMP},",
          "clean_end_time = #{cleanEndTime,jdbcType=TIMESTAMP},",
          "staff_id = #{staffId,jdbcType=VARCHAR},",
          "img = #{img,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CleaningInfo record);
    
    @SelectProvider(type = com.nursery_school.manager.model.dyna.CleaningInfoDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="cleaning_id", property="cleaningId", jdbcType=JdbcType.VARCHAR),
        @Result(column="clean_start_time", property="cleanStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="clean_end_time", property="cleanEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.VARCHAR),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR)
    })
    List<CleaningInfo> findByDyna(Map<String, Object> map);
    
    @UpdateProvider(type = com.nursery_school.manager.model.dyna.CleaningInfoDynaProvider.class, method = "updateProvider")
    void updateProvider(Map<String, Object> map);
}