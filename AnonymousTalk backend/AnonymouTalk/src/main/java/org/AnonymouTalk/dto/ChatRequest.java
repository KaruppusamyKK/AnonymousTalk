package org.AnonymouTalk.dto;
import lombok.*;
public record ChatRequest(
    String sender,
    String receiver,
    String timestamp,
    String content,
    byte[] otherContent) {}
