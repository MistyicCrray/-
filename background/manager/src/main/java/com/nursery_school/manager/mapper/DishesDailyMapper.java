package com.nursery_school.manager.mapper;

import com.nursery_school.manager.model.DishesDaily;
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
public interface DishesDailyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dishes_daily
     *
     * @mbg.generated Sun Oct 06 17:41:49 CST 2019
     */
    @Delete({
        "delete from t_dishes_daily",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dishes_daily
     *
     * @mbg.generated Sun Oct 06 17:41:49 CST 2019
     */
    @Insert({
        "insert into t_dishes_daily (id, breakfast_food, ",
        "breakfast_money, lunch_food, ",
        "lunch_money, dinner_food, ",
        "dinner_money, dishes_date, ",
        "create_date, create_by, ",
        "breakfast_food_id, lunch_food_id, ",
        "dinner_food_id)",
        "values (#{id,jdbcType=VARCHAR}, #{breakfastFood,jdbcType=VARCHAR}, ",
        "#{breakfastMoney,jdbcType=INTEGER}, #{lunchFood,jdbcType=VARCHAR}, ",
        "#{lunchMoney,jdbcType=INTEGER}, #{dinnerFood,jdbcType=VARCHAR}, ",
        "#{dinnerMoney,jdbcType=INTEGER}, #{dishesDate,jdbcType=DATE}, ",
        "#{createDate,jdbcType=DATE}, #{createBy,jdbcType=VARCHAR}, ",
        "#{breakfastFoodId,jdbcType=VARCHAR}, #{lunchFoodId,jdbcType=VARCHAR}, ",
        "#{dinnerFoodId,jdbcType=VARCHAR})"
    })
    int insert(DishesDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dishes_daily
     *
     * @mbg.generated Sun Oct 06 17:41:49 CST 2019
     */
    @Select({
        "select",
        "id, breakfast_food, breakfast_money, lunch_food, lunch_money, dinner_food, dinner_money, ",
        "dishes_date, create_date, create_by, breakfast_food_id, lunch_food_id, dinner_food_id",
        "from t_dishes_daily",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="breakfast_food", property="breakfastFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast_money", property="breakfastMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="lunch_food", property="lunchFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="lunch_money", property="lunchMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="dinner_food", property="dinnerFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="dinner_money", property="dinnerMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="dishes_date", property="dishesDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast_food_id", property="breakfastFoodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lunch_food_id", property="lunchFoodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dinner_food_id", property="dinnerFoodId", jdbcType=JdbcType.VARCHAR)
    })
    DishesDaily selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dishes_daily
     *
     * @mbg.generated Sun Oct 06 17:41:49 CST 2019
     */
    @Select({
        "select",
        "id, breakfast_food, breakfast_money, lunch_food, lunch_money, dinner_food, dinner_money, ",
        "dishes_date, create_date, create_by, breakfast_food_id, lunch_food_id, dinner_food_id",
        "from t_dishes_daily"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="breakfast_food", property="breakfastFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast_money", property="breakfastMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="lunch_food", property="lunchFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="lunch_money", property="lunchMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="dinner_food", property="dinnerFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="dinner_money", property="dinnerMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="dishes_date", property="dishesDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast_food_id", property="breakfastFoodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lunch_food_id", property="lunchFoodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dinner_food_id", property="dinnerFoodId", jdbcType=JdbcType.VARCHAR)
    })
    List<DishesDaily> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dishes_daily
     *
     * @mbg.generated Sun Oct 06 17:41:49 CST 2019
     */
    @Update({
        "update t_dishes_daily",
        "set breakfast_food = #{breakfastFood,jdbcType=VARCHAR},",
          "breakfast_money = #{breakfastMoney,jdbcType=INTEGER},",
          "lunch_food = #{lunchFood,jdbcType=VARCHAR},",
          "lunch_money = #{lunchMoney,jdbcType=INTEGER},",
          "dinner_food = #{dinnerFood,jdbcType=VARCHAR},",
          "dinner_money = #{dinnerMoney,jdbcType=INTEGER},",
          "dishes_date = #{dishesDate,jdbcType=DATE},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "breakfast_food_id = #{breakfastFoodId,jdbcType=VARCHAR},",
          "lunch_food_id = #{lunchFoodId,jdbcType=VARCHAR},",
          "dinner_food_id = #{dinnerFoodId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(DishesDaily record);
    
    
    @SelectProvider(type = com.nursery_school.manager.model.dyna.DishesDailyDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="breakfast_food", property="breakfastFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast_money", property="breakfastMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="lunch_food", property="lunchFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="lunch_money", property="lunchMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="dinner_food", property="dinnerFood", jdbcType=JdbcType.VARCHAR),
        @Result(column="dinner_money", property="dinnerMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="dishes_date", property="dishesDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast_food_id", property="breakfastFoodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lunch_food_id", property="lunchFoodId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dinner_food_id", property="dinnerFoodId", jdbcType=JdbcType.VARCHAR)
    })
    List<DishesDaily> findByDyna(Map<String, Object> map);
    
    @UpdateProvider(type = com.nursery_school.manager.model.dyna.DishesDailyDynaProvider.class, method = "updateProvider")
    void updateProvider(Map<String, Object> map);
}