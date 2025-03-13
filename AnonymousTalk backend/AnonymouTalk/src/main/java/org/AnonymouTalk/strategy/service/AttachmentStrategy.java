package org.AnonymouTalk.strategy.service;

import org.AnonymouTalk.dto.ChatRequest;
import org.AnonymouTalk.strategy.UserChatStrategy;
import org.springframework.stereotype.Component;

@Component
public class AttachmentStrategy implements UserChatStrategy {

    @Override
    public void handleUserChat(ChatRequest request) {

    }
}
