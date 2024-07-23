package com.example.demo_log.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Service

public class HelloWorldService {

    @Value("${app.name:test}") // Provide a default value here
    String app;
    public String inquiryHelloWorld(){
        log.error("hello");
        String ipAddress = getServerIpAddress();
        return "hello world from " + app + " with IP: " + ipAddress;
    }


    private String getServerIpAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            log.error("Unable to get server IP address", e);
            return "unknown";
        }
    }

}
