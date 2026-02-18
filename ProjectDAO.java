import database.DBConnection;
import model.Project;

import java.sql.*;
import java.util.*;

public class ProjectDAO {

    public void addProject(Project p) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
                "INSERT INTO projects(title,deadline,revenue) VALUES(?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getTitle());
        ps.setInt(2, p.getDeadline());
        ps.setInt(3, p.getRevenue());

        ps.executeUpdate();
        con.close();
    }

    public List<Project> getAllProjects() throws Exception {

        List<Project> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM projects");

        while (rs.next()) {
            list.add(new Project(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("deadline"),
                    rs.getInt("revenue")
            ));
        }

        con.close();
        return list;
    }
}
