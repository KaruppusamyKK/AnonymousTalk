package org.AnonymouTalk.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.ChatRequest;
import org.AnonymouTalk.response.Responsehandler;
import org.AnonymouTalk.service.UserChatService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/chat")
public class UserChatController {

    private final UserChatService chatService;
    private final CacheManager cacheManager;

    private final ConcurrentHashMap<String, List<ChatRequest>> chatStore = new ConcurrentHashMap<>();


    @PostMapping("/validateUrlExistence")
    public ResponseEntity<?> handleTextMessage(@RequestBody Map<String, String> requestBody) {
        String url = requestBody.get("url");
        log.info("URL is {} ", url);
        Boolean result = chatService.validateUrlExistence(url);
        return Responsehandler.buildApiResponse(result, "Url present", "Url not present");
    }

    private final ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/handleChatMessages")
    public ResponseEntity<List<ChatRequest>> handleChatMessages(@RequestBody ChatRequest request, @RequestParam String roomId) {
        log.info("Chat request: {}, roomId: {}", request, roomId);
        Cache chatCache = cacheManager.getCache("chatCache");
        List<ChatRequest> messages = new ArrayList<>();

        if (chatCache != null) {
            Cache.ValueWrapper valueWrapper = chatCache.get(roomId);
            if (valueWrapper != null) {
                Object cachedValue = valueWrapper.get();
                if (cachedValue instanceof List<?>) {
                    messages = (List<ChatRequest>) cachedValue;
                }
            }
        }
        messages.add(request);
        chatCache.put(roomId, messages);
        chatStore.put(roomId, new ArrayList<>(messages));
        return ResponseEntity.ok(new ArrayList<>(messages));
    }


    @GetMapping("/history")
    @Cacheable(value = "chatCache", key = "#roomId")
    public List<ChatRequest> getChatRequest(@RequestParam String roomId) {
        log.info("Fetching chat history for roomId: {}", roomId);
        return chatStore.getOrDefault(roomId, new ArrayList<>());
    }

    @PostMapping("/clearCache")
    public ResponseEntity<String> clearAllCache() {
        Cache chatCache = cacheManager.getCache("chatCache");
        if (chatCache != null) {
            chatCache.clear();
        }
        chatStore.clear();
        log.info("Cleared all chat cache and store.");
        return ResponseEntity.ok("All chat cache cleared.");
    }


}
