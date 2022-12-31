package com.example.plustwonumber;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/plus")
public class PlusController {

    @PostMapping
    ResponseEntity<Integer> plus(
            @RequestParam("a") int a,
            @RequestParam("b") int b
    ) {
        return ResponseEntity.ok(a + b);
    }
}
