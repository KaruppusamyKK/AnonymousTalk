package org.AnonymouTalk.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.AnonymouTalk.model.Url;
import org.AnonymouTalk.repo.UrlRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlServiceImpl implements UrlService {

    private final UrlRepo urlRepo;


    @Override
    public Boolean savePrivateUrl(String url) {
        return (Boolean) urlRepo.findByUrl(url).map(s->{
            log.info("Url already exists ....");
            return false;
        })
        .orElseGet(()->{
            urlRepo.save(new Url(url));
            return true;
        });
    }




}
