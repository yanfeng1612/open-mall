package com.openmall.api.controller;

import com.openmall.api.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mahongwei58
 * @date 2020-01-07
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return helloRemote.hello(name);
    }

}
