package com.example.empManagement.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleJob {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "${cron.expression}")
    public void getCurrentDateByJob() {
        log.info(" -----  Current Date ---  " + new Date().toString());
    }
}
