package tablegame.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nemykin 29.10.2020
 */
@RestController
@RequestMapping("/api/static")
public class StaticController {

    @RequestMapping("/ping")
    public String sayHello() {
        return "pong";
    }
}
