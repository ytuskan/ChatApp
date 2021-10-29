package com.example.finalreview.mapper;

import com.example.finalreview.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    @Select("Select * From Messages")
    List<ChatMessage> findMessages();

    @Insert("Insert Into Messages(username, messagetext)" +
            "Values(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insertMessage(ChatMessage chatMessage);
}
