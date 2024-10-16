package dev.webish.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellWorldController.class);

    public HellWorldController() {
        LOGGER.info("Loaded!");
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "You are my admin!";
    }
}
