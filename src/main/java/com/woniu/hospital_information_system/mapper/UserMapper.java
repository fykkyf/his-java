package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name = #{userName}")
    User login(User user);

    @Select("select count(*) from user where isdelete = 0 and email = #{email}")
    int findEmail(String email);

    @Update("update user set password = #{newPassword} where email=#{email} and isdelete=0")
    void updatepwd(@Param("newPassword") String newPassword, @Param("email")String email);
}
