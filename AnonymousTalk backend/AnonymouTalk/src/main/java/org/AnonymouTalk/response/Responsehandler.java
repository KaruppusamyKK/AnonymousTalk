package org.AnonymouTalk.response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class Responsehandler {

    public static ResponseEntity<?> buildApiResponse(Boolean result,String successMessage,String failureMessage) {
        return ResponseEntity.status(result ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR)
                .body(result ? successMessage : failureMessage);
    }
}
