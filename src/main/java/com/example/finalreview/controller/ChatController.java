package com.example.finalreview.controller;

import com.example.finalreview.model.ChatForm;
import com.example.finalreview.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", messageService.getAllMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(Authentication authentication, ChatForm chatForm, Model model) {
        chatForm.setUsername(authentication.getName());
        messageService.createMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", messageService.getAllMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[]{"Say", "Shout", "Whisper"};
    }
}
