package com.tperuch.hroauth.feignclients;

import com.tperuch.hroauth.entities.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(name="hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity<UserEntity> findByEmail(@RequestParam String email);
}
