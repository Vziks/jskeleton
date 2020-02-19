package info.vziks.skeleton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class IndexController
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/")
    public String indexAction () {
        return "index/index";
    }

    @RequestMapping("/hello")
    public String helloAction () {
        return "index/hello";
    }
}
