package com.ChatGPT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ChatGPT.dto.ChatRequest;
import com.ChatGPT.dto.ChatResponse;
import com.ChatGPT.service.ChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
	
	@Autowired
	 public ChatService chatService;

	    @PostMapping
	    public ChatResponse chat(@RequestBody ChatRequest request) {
	        String reply = chatService.generateReply(request.getMessage());
	   	 return new ChatResponse(reply);
	    }
}
