import java.sql.*;
import java.util.*;

import database.DBConnection;
import model.Project;
import service.Scheduler;

public class Main {

    public static void main(String[] args) {

        List<Project> projects = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM projects");

            while (rs.next()) {
                projects.add(new Project(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("deadline"),
                        rs.getInt("revenue")
                ));
            }

            Scheduler.scheduleProjects(projects);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
