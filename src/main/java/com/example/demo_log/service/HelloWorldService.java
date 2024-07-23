package com.example.demo_log.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HelloWorldService {


    public String inquiryHelloWorld(){
        log.error("hello");
        String ipAddress = getServerIpAddress();
        return "hello world from " + " with IP: " + ipAddress;
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
