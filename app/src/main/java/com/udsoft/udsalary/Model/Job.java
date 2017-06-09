package com.udsoft.udsalary.Model;

import java.util.Random;
import java.util.UUID;

/**
 * This Job class hold the information about the Job
 * @ID = The Identification number of the job.
 * @name = The name of the job
 * @description = The job description of the job
 * @companyName = The company where the job was given.
 */

public class Job {
    private UUID ID;
    private String description;
    private String name;
    private String companyName;

    public Job(String description, String name, String companyName) {
        this.description = description;
        this.name = name;
        this.companyName = companyName;
        this.ID = UUID.randomUUID();
    }

    public UUID getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }
}
