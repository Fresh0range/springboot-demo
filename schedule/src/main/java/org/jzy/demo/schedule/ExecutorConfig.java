package org.jzy.demo.schedule;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@Data
@ConfigurationProperties(prefix = "app.executor")
public class ExecutorConfig {
    @Value("${core:8}")
    private Integer core;
    @Value("${max:16}")
    private Integer max;
    @Value("${keep:0}")
    private Integer keep;

    @Bean
    public Executor myExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(core);
        executor.setMaxPoolSize(max);
        executor.setKeepAliveSeconds(keep);
        executor.setThreadNamePrefix("myExecutor-");
        return executor;
    }
}
