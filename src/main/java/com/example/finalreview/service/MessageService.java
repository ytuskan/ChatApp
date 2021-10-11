package com.example.finalreview.service;

import com.example.finalreview.mapper.MessageMapper;
import com.example.finalreview.model.ChatForm;
import com.example.finalreview.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
    public void createMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageMapper.insertMessage(newMessage);
    }

    public List<ChatMessage> getAllMessages(){
        return messageMapper.findMessages();
    }
}
