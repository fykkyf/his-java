package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
}
