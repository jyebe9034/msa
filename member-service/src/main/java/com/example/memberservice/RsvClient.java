package com.example.memberservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "rsv-service") // spring.application.name이 rsv-service인 서비스를 호출한다는 의미
public interface RsvClient {

    @GetMapping("/rsvinfo") // rsv-service모듈 안의 RsvServiceApplication 클래스 안에 있는 rsvinfo()를 호출하는 어노테이션
    Map<String, Object> rsvinfo();
}
