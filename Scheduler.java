package service;

import java.util.*;
import model.Project;

public class Scheduler {

    static final int MAX_DAYS = 5;

    public static void scheduleProjects(List<Project> projects) {

        // sort by revenue descending
        projects.sort((a, b) -> b.revenue - a.revenue);

        Project[] schedule = new Project[MAX_DAYS];
        boolean[] slotFilled = new boolean[MAX_DAYS];

        int totalRevenue = 0;

        for (Project p : projects) {

            for (int day = Math.min(MAX_DAYS, p.deadline) - 1; day >= 0; day--) {

                if (!slotFilled[day]) {
                    schedule[day] = p;
                    slotFilled[day] = true;
                    totalRevenue += p.revenue;
                    break;
                }
            }
        }

        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

        System.out.println("\nWeekly Schedule:\n");

        for (int i = 0; i < MAX_DAYS; i++) {
            if (schedule[i] != null)
                System.out.println(days[i] + " -> " + schedule[i].title +
                        " (Revenue: " + schedule[i].revenue + ")");
            else
                System.out.println(days[i] + " -> No Project");
        }

        System.out.println("\nTotal Revenue = " + totalRevenue);
    }
}
