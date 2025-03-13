package org.AnonymouTalk.dto;

public record WebSocketRequest(String sender,
                               String receiver,
                               String content) {
}