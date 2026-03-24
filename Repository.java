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
