package org.jzy.demo.mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.jzy.demo.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    @Select(" select * from user ")
    List<User> listAll();

    @Select(" select * from user where id = #{id} ")
    User get(Integer id);

    @Insert(" insert into user (username,password) values (#{username},#{password}) ")
    // 主键回填
    @Options(useGeneratedKeys = true)
    void post(User user);

    @Delete(" delete from user where id = #{id} ")
    int delete(Integer id);

    @Update(" update user set username = #{username},password = #{password} where id = #{id}")
    int put(User user);
}
