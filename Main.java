package com.promanage;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProjectDAO dao = new ProjectDAO();
        Scheduler scheduler = new Scheduler();

        while (true) {

            System.out.println("\n===== TASK SCHEDULING SYSTEM =====");
            System.out.println("1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("3. Generate Schedule");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Deadline (1-7): ");
                    int deadline = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Revenue: ");
                    int revenue = Integer.parseInt(sc.nextLine());


                    dao.addProject(title, deadline, revenue);
                    break;

                case 2:
                    List<Project> list = dao.getAllProjects();
                    for (Project p : list) {
                        System.out.println(
                                p.getId() + " | " +
                                        p.getTitle() + " | Deadline: " +
                                        p.getDeadline() + " | Revenue: " +
                                        p.getRevenue()
                        );
                    }
                    break;

                case 3:
                    List<Project> projects = dao.getAllProjects();
                    scheduler.scheduleProjects(projects);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
