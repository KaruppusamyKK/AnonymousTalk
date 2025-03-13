package org.AnonymouTalk.repo;

import org.AnonymouTalk.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepo extends JpaRepository<Url,Long> {

    Optional<Url> findByUrl(String url);

}
