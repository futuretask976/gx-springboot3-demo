package com.gx.sp3.demo.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Deploy the war under tomcat webapp, the tomcat path is /gx
 * so here root path only need to be set as /, not /gx
 */
@RestController
@RequestMapping("/")
public class RootController {
    /**
     * Access this method by http://localhost:8080/gxsp3demo/test000
     * @return
     */
    @GetMapping(value = "/")
    public String test000() {
        try {
            System.out.println("MainController#test000 entering");
            return "success: test000";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail: " + e.toString();
        }
    }

    /**
     * Access this method by http://localhost:8080/gxsp3demo/test001?param=123
     * @param param
     * @return
     */
    @GetMapping(value = "/test001")
    public String test001(@RequestParam("param") String param) {
        try {
            System.out.println("MainController#test001 entering");
            return "success: " + param;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail: " + e.toString();
        }
    }

    /**
     * Access this method by http://localhost:8080/gxsp3demo/test002
     * @return
     */
    @GetMapping(value = "/test002")
    public String test002() {
        try {
            System.out.println("MainController#test002 entering");
            return "success: test002";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail: " + e.toString();
        }
    }

    /**
     * Access this method by http://localhost:8080/gxsp3demo/test003?param=123
     * @param param
     * @return
     */
    @GetMapping(value = "/test003")
    public String test003(@RequestParam("param") String param) {
        try {
            System.out.println("MainController#test003 entering");
            return "success: " + param;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail: " + e.toString();
        }
    }
}
