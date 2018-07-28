package com.management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: management
 * @description:
 * @author: ggmr
 * @create: 2018-07-28 09:14
 */
@RestController
@RequestMapping(value = "/test")
@CrossOrigin
public class test {
    @RequestMapping
    public String f() {
        return "sd";
    }
}
