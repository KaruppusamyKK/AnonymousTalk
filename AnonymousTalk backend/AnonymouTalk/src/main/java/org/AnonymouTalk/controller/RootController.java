package org.AnonymouTalk.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class RootController {

    @GetMapping("/")
    public Map<String,String > root(){
        return Map.of("Status","Running \uD83D\uDE80");
    }
}
