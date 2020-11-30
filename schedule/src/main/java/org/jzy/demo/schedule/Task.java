package org.jzy.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class Task {
    @Async("myExecutor")
    public void printNow() {
        log.info(new Date().toString());
    }
}
