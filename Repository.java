package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private final String url = "jdbc:sqlite:C:/Users/QC SDO/IdeaProjects/Milestone1/milestone1.db";

    public Repository() {
        setupDatabase();
    }

    private void setupDatabase() {
        String createTable = "CREATE TABLE IF NOT EXISTS task4 (" +
                "id INTEGER PRIMARY KEY, " +
                "Brand TEXT, " +
                "Spec INTEGER, " +
                "Type TEXT)";
    try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Hardware> getAllHardware() {
        List<Hardware> list = new ArrayList<>();
        String query = "SELECT * FROM task4";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("Brand");
                int spec = rs.getInt("Spec");
                String type = rs.getString("Type");

                if (type.equalsIgnoreCase("Laptop")) {
                    list.add(new Laptop(id, brand, spec));
                } else if (type.equalsIgnoreCase("Phone")) {
                    list.add(new Phone(id, brand, spec));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

package org.example;

public class Phone extends Hardware {

    public Phone(int id, String brand, int spec) {
        super(id, brand, spec);
    }

    @Override
    public String interpretSpec() {
        return getSpec() + " Megapixels";  // use getter, not spec directly
    }
}