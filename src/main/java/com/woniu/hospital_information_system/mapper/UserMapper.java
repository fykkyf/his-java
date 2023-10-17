package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Select("select * from user where user_name = #{userName}")
    User login(User user);
}
