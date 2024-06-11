package com.springboot.app2.rest.testing;

import io.sentry.Sentry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentryController {

    @GetMapping("/sentry")
    public String sentryTest() {
        try {
            throw new Exception("This is a sentry test.");
        } catch (Exception e) {
            Sentry.captureException(e);
            return "-1";
        }
    }

}