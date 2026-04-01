package org.example.back_end.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/hello")
public class HelloController {
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String hello(){
        return "Hello World";
    }
}
