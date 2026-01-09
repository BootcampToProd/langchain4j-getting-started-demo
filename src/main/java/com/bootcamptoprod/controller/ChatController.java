package com.bootcamptoprod.controller;

import com.bootcamptoprod.dto.ChatRequest;
import com.bootcamptoprod.dto.ChatResponse;
import dev.langchain4j.model.chat.ChatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ChatController {

    private final ChatModel chatModel;

    public ChatController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String aiResponse = chatModel.chat(request.message());
        return new ChatResponse(aiResponse);
    }
}