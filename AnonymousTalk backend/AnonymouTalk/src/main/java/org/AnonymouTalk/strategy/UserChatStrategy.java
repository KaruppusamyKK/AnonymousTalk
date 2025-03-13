package org.AnonymouTalk.strategy;

import org.AnonymouTalk.dto.ChatRequest;

public interface UserChatStrategy {
    
    void handleUserChat(ChatRequest request);
}
