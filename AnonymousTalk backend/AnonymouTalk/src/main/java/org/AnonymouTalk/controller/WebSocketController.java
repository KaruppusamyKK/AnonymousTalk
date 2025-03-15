package org.AnonymouTalk.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.WebSocketRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebSocketController {


    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public WebSocketRequest sendMessage(WebSocketRequest message) {
        log.info("Received chat messages are {} ",message);
        return message;
    }


    @MessageMapping("/userJoined")
    @SendTo("/topic/userJoined")
    public Map<String, Object> userJoined(WebSocketRequest message) {
        log.info("User joined: {}", message.sender());
        Map<String, Object> response = new HashMap<>();
        response.put("sender", message.sender());
        response.put("messageThrown", true);
        return response;
    }





}