package com.example.contactapp.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    @PostMapping("/contact")
    public String handleContact(@RequestParam @NotBlank String name,
                                 @RequestParam @Email String email,
                                 @RequestParam(required = false) String message) {

        log.info("New contact submission - Name: {}, Email: {}, Message: {}", name, email, message);

        return "Form Submitted Successfully";
    }
}
