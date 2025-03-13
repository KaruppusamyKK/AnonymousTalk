package org.AnonymouTalk.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.ChatRequest;
import org.AnonymouTalk.response.Responsehandler;
import org.AnonymouTalk.service.UserChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/chat")
public class UserChatController {

    private final UserChatService chatService;


    @PostMapping("/validateUrlExistence")
    public ResponseEntity<?> handleTextMessage(@RequestBody Map<String,String> requestBody){
        String url = requestBody.get("url");
        log.info("URL is {} ",url);
        Boolean result = chatService.validateUrlExistance(url);
        return Responsehandler.buildApiResponse(result,"Url present","Url not present");
    }



    @PostMapping("/text")
    public ResponseEntity<?> handleTextMessage(@RequestBody ChatRequest request){
        log.info("Chat request are {} ",request);
        return ResponseEntity.ok(chatService.processMessage("text",request));
    }


}
