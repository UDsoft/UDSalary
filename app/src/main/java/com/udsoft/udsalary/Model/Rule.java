package com.udsoft.udsalary.Model;

import java.util.UUID;

/**
 * Rule class saves the information:
 * @job = the object of the JOB.
 * @type = the name type of the Rule.
 * @startTIme = 0 position holds the HOUR, 1 position holds the MIN of the start time of the rule.
 * @endTime = 0 possition holds the HOUR, 1 position holds the MIN of the end time of the rule.
 * @wage = the ammount of the wage.
 * @ID = the identification number of the rule.
 */

public class Rule {
    private Job job;
    private String type;
    private int[] startTime;
    private int[] endTime;
    private float wage;
    private UUID ID;

    public Rule(Job job, String type, int[] startTime, int[] endTime, float wage) {
        this.job = job;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.wage = wage;
        this.ID = UUID.randomUUID();
    }
}
