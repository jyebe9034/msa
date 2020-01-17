package com.example.memberservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "rsv-service")
public interface RsvClient {

    @GetMapping("/rsvinfo")
    Map<String, Object> rsvinfo();
}
