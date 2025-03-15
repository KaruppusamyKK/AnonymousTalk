package org.AnonymouTalk.dto;
import lombok.*;

import java.io.Serializable;

public record ChatRequest(
    String sender,
    String receiver,
    String timestamp,
    String content,
    byte[] otherContent) implements Serializable {private static final long serialVersionUID = 1L;
}
