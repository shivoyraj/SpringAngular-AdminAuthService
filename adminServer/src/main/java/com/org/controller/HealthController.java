package com.org.controller;

import io.swagger.v3.core.util.Json;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/status")
    public ResponseEntity<Object> getStatus() {
        String message = "application is up";
        return ResponseEntity.ok().body("{\"msg\":\"" + message + "\"}");
    }

}
