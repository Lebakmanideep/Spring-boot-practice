package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCouch implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fat bowling for 15 minutes!!!";
    }
}
