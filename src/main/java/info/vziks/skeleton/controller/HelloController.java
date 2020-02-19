package info.vziks.skeleton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Class HelloController
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
public class HelloController {

    @GetMapping("/hello1")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "Hello") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "Hello") String name, Map<String, Object> model) {
        model.put("name", name);
        return "hello";
    }
}
