package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.study_servlets.controlls.commons.Commons;

public class OptionInforsDao {
    //insert
     public static int InsertName(String name) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in workbench
            String query = "INSERT INTO option_infors\n" + //
                    "(OPTION_INFOR_ID,OPTION_NAME)\n" + //
                    "VALUES\n" + //
                    "('OP-007','"+name+"');";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    //update
    public static int UpdateWithName(String NAME) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in workbench
            String query ="";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    //delete
    public static int DeleteWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in workbench
            String query = "DELETE FROM option_infors\n" + //
                    "where OPTION_INFOR_ID = '"+unique_id+"';";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList optionInforList = new ArrayList();
        try {
            if (search == null) {
                search = "";
            }
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in workbench
            String query = "SELECT *\n" + //
                    "FROM option_infors\n" + //
                    "WHERE OPTION_NAME like '" + search + "%';";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap optionInforRecord = new HashMap<>();
            while (resultSet.next()) {
                optionInforRecord = new HashMap<>();
                optionInforRecord.put("OPTION_INFOR_ID", resultSet.getString("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME", resultSet.getString("OPTION_NAME"));

                optionInforList.add(optionInforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforList;
    }
}