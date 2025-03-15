package org.AnonymouTalk.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.ChatRequest;
import org.AnonymouTalk.repo.UrlRepo;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
@Service
@Slf4j
@RequiredArgsConstructor
public class UserChatService {

    private final CacheManager cacheManager;
    private final UrlRepo urlRepo;




    public Boolean validateUrlExistence(String url) {
        return urlRepo.findByUrl(url).isPresent();
    }
}
