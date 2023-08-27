package com.example.tennis.REST;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import java.util.List;

@RestController
@RequestMapping("/players")
public interface TennisPlayerController {

    @GetMapping("/{id}")
    String getTennisPlayer(@PathVariable String id);

    @GetMapping
    String getTennisPlayersList();

    @GetMapping("/stats")
    String getTennisPlayerStats();
}
