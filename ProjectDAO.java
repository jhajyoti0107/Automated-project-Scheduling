package com.promanage;

import java.sql.*;
import java.util.*;

public class ProjectDAO {

    public void addProject(String title, int deadline, int revenue) {

        String sql = "INSERT INTO projects(title, deadline, revenue) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setInt(2, deadline);
            ps.setInt(3, revenue);

            ps.executeUpdate();
            System.out.println("Project Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Project> getAllProjects() {

        List<Project> list = new ArrayList<>();
        String sql = "SELECT * FROM projects";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Project(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("deadline"),
                        rs.getInt("revenue")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
