package org.AnonymouTalk.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.WebSocketRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
@RequiredArgsConstructor
public class WebSocketController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public WebSocketRequest sendMessage(WebSocketRequest message) {
        log.info("Received chat messages are {} ",message);
        return message;
    }
}