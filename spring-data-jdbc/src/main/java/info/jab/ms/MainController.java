package info.jab.ms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MainController {

    @GetMapping(value = "/api/v1/", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public String getData() {
        return "Hello World";
    }
}
