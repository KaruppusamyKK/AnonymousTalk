package org.AnonymouTalk.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.response.Responsehandler;
import org.AnonymouTalk.service.UrlServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/url")
public class UrlController {

    private final UrlServiceImpl urlService;


    @PostMapping("/savePrivateUrl")
    public ResponseEntity<?> savePrivateUrl(@RequestParam String url){
        Boolean result = urlService.savePrivateUrl(url);
        return Responsehandler.buildApiResponse(result,"Url save success","Url save failed");
    }

}
