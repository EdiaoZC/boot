package com.demo.boot.controler;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@RestController
@RequestMapping("/ctl")
public class TimeController {

    @GetMapping("/time")
    public Mono<String> time() {
        return Mono.just("Now is " + new SimpleDateFormat("hh:mm:ss").format(new Date()));
    }


    @GetMapping(value = "/times", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> times() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> "Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date()))
                .take(5);
    }
}
