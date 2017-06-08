package com.udsoft.udsalary.Model;

import java.util.Calendar;
import java.util.UUID;

public class WorkSessionWithRules {
    private Calendar startTime;
    private Calendar endTime;
    private float wage;
    private UUID ID;

    public WorkSessionWithRules(Calendar startTime, Calendar endTime, float wage) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.wage = wage;
        this.ID = UUID.randomUUID();
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public float getWage() {
        return wage;
    }

    public UUID getID() {
        return ID;
    }
}
