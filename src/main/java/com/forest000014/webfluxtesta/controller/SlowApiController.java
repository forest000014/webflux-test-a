package com.forest000014.webfluxtesta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SlowApiController {

    private final long SLEEP_TIME_SECONDS = 5;

    @GetMapping("/slow")
    @ResponseBody
    public String slowMethod(@RequestParam String name) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= SLEEP_TIME_SECONDS; i++) {
            Thread.sleep(1000);
            System.out.printf("sleeping for %d second(s)...\n", i);
        }

        String resBody = "";
        for (int i = 1; i <= 5; ++i) {
            resBody = resBody.concat(name + " ");
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("elapsed time : %.3f sec\n", (endTime - startTime) / 1000.0);

        return resBody;
    }
}
