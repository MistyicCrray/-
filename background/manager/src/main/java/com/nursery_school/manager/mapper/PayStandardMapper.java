package com.nursery_school.manager.mapper;

import com.nursery_school.manager.model.PayStandard;
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
public interface PayStandardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pay_standard
     *
     * @mbg.generated Mon Sep 30 20:42:30 CST 2019
     */
    @Delete({
        "delete from t_pay_standard",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pay_standard
     *
     * @mbg.generated Mon Sep 30 20:42:30 CST 2019
     */
    @Insert({
        "insert into t_pay_standard (id, schooling, ",
        "book_money, board_ages, ",
        "quarterage, payment_deadline, ",
        "year)",
        "values (#{id,jdbcType=VARCHAR}, #{schooling,jdbcType=INTEGER}, ",
        "#{bookMoney,jdbcType=INTEGER}, #{boardAges,jdbcType=INTEGER}, ",
        "#{quarterage,jdbcType=INTEGER}, #{paymentDeadline,jdbcType=DATE}, ",
        "#{year,jdbcType=DATE})"
    })
    int insert(PayStandard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pay_standard
     *
     * @mbg.generated Mon Sep 30 20:42:30 CST 2019
     */
    @Select({
        "select",
        "id, schooling, book_money, board_ages, quarterage, payment_deadline, year",
        "from t_pay_standard",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="schooling", property="schooling", jdbcType=JdbcType.INTEGER),
        @Result(column="book_money", property="bookMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="board_ages", property="boardAges", jdbcType=JdbcType.INTEGER),
        @Result(column="quarterage", property="quarterage", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_deadline", property="paymentDeadline", jdbcType=JdbcType.DATE),
        @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    PayStandard selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pay_standard
     *
     * @mbg.generated Mon Sep 30 20:42:30 CST 2019
     */
    @Select({
        "select",
        "id, schooling, book_money, board_ages, quarterage, payment_deadline, year",
        "from t_pay_standard"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="schooling", property="schooling", jdbcType=JdbcType.INTEGER),
        @Result(column="book_money", property="bookMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="board_ages", property="boardAges", jdbcType=JdbcType.INTEGER),
        @Result(column="quarterage", property="quarterage", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_deadline", property="paymentDeadline", jdbcType=JdbcType.DATE),
        @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    List<PayStandard> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pay_standard
     *
     * @mbg.generated Mon Sep 30 20:42:30 CST 2019
     */
    @Update({
        "update t_pay_standard",
        "set schooling = #{schooling,jdbcType=INTEGER},",
          "book_money = #{bookMoney,jdbcType=INTEGER},",
          "board_ages = #{boardAges,jdbcType=INTEGER},",
          "quarterage = #{quarterage,jdbcType=INTEGER},",
          "payment_deadline = #{paymentDeadline,jdbcType=DATE},",
          "year = #{year,jdbcType=DATE}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PayStandard record);
    
    @UpdateProvider(type = com.nursery_school.manager.model.dyna.PayStandardDynaProvider.class, method = "updateProvider")
    void updateProvider(Map<String, Object> map);
    
    @SelectProvider(type = com.nursery_school.manager.model.dyna.PayStandardDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="schooling", property="schooling", jdbcType=JdbcType.INTEGER),
        @Result(column="book_money", property="bookMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="board_ages", property="boardAges", jdbcType=JdbcType.INTEGER),
        @Result(column="quarterage", property="quarterage", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_deadline", property="paymentDeadline", jdbcType=JdbcType.DATE),
        @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    List<PayStandard> selectProvider(Map<String, Object> map);
}