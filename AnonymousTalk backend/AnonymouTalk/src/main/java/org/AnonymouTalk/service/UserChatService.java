package org.AnonymouTalk.service;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.dto.ChatRequest;
import org.AnonymouTalk.repo.UrlRepo;
import org.AnonymouTalk.strategy.UserChatStrategy;
import org.AnonymouTalk.strategy.service.AttachmentStrategy;
import org.AnonymouTalk.strategy.service.DeleteMessageStrategy;
import org.AnonymouTalk.strategy.service.TextMessageStrategy;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
@Slf4j
public class UserChatService {

    private final UrlRepo urlRepo;
    private  final Map<String, UserChatStrategy> userChatStrategyMap;

    public UserChatService(UrlRepo urlRepo, TextMessageStrategy textMessageStrategy,
                           AttachmentStrategy attachmentStrategy,
                           DeleteMessageStrategy deleteMessageStrategy) {
        this.urlRepo = urlRepo;
        userChatStrategyMap = Map.of("text",textMessageStrategy,
                "attachment",attachmentStrategy,
                "delete",deleteMessageStrategy);
    }


    public Boolean processMessage(String type, ChatRequest request){
        UserChatStrategy strategy = userChatStrategyMap.get(type.toLowerCase());
        if (strategy !=null){
            strategy.handleUserChat(request);
            return true;
        }
        return false;
    }

    public Boolean validateUrlExistance(String url) {
        return urlRepo.findByUrl(url).isPresent();
    }
}
