package org.AnonymouTalk.strategy.service;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.ChatRequest;
import org.AnonymouTalk.strategy.UserChatStrategy;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class TextMessageStrategy implements UserChatStrategy {

    @Override
    public void handleUserChat(ChatRequest request) {
    log.info("Message ..............................");
    }


}
