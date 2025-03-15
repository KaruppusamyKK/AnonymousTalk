//package org.AnonymouTalk.Redis;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@Slf4j
//@RequiredArgsConstructor
//public class ControllerClass {
//
//    private final RedisTemplate<String,Object> redisTemplate;
//
//    @PostMapping("/put")
//    public ResponseEntity<Map<String,String>> storeCache(@RequestParam String key,@RequestParam String value){
//        log.info("Key {} & value {} are  ",key,value);
//        redisTemplate.opsForValue().set(key,value);
//        return ResponseEntity.ok(Map.of("Status","SUCCESS"));
//    }
//
//    @PostMapping("/get")
//    public ResponseEntity<?> readCache(@RequestParam String key){
//        log.info("Key {} is  ",key);
//        return ResponseEntity.ok(redisTemplate.opsForValue().get(key));
//    }
//}
