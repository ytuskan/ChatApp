package com.example.finalreview.mapper;

import com.example.finalreview.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("Select * From Users Where username=#{username}")
    User findUser(String username);

    @Insert("Insert Into Users(username, salt, password, firstname, lastname)" +
            "Values(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(User user);
}
