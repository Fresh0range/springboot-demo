package org.jzy.demo.schedule;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Data
public class Scheduler {
    @Autowired
    private Task task;

    @Scheduled(fixedRate = 30000)
    public void schedule() {
        for (int i = 0; i < 100; i++) {
            task.printNow();
        }
    }
}
