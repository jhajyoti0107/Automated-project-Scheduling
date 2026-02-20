package com.promanage;

import java.util.*;

public class Scheduler {

    public void scheduleProjects(List<Project> projects) {

        projects.sort((a, b) -> b.getRevenue() - a.getRevenue());

        int maxDays = 7;
        Project[] schedule = new Project[maxDays];

        for (Project p : projects) {
            for (int day = Math.min(maxDays, p.getDeadline()) - 1; day >= 0; day--) {
                if (schedule[day] == null) {
                    schedule[day] = p;
                    break;
                }
            }
        }

        int totalRevenue = 0;

        for (int i = 0; i < maxDays; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            if (schedule[i] != null) {
                System.out.println(schedule[i].getTitle() +
                        " (Revenue: " + schedule[i].getRevenue() + ")");
                totalRevenue += schedule[i].getRevenue();
            } else {
                System.out.println("No Project");
            }
        }

        System.out.println("Total Revenue: " + totalRevenue);
    }
}
