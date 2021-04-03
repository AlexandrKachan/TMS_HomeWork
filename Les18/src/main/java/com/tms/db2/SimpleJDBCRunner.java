package com.tms.db2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleJDBCRunner {
    public static void main(String[] args) {
        Connection cn = null;

        try { // 1 блок
            cn = ConnectorDB.getConnection();
            Statement st = null;
            try { // 2 блок
                st = cn.createStatement();
                ResultSet rs = null;
                try { // 3 блок
                    rs = st.executeQuery("SELECT * FROM phonebook");
                    ArrayList<Abonent> lst = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        int phone = rs.getInt(3);
                        String name = rs.getString(2);
                        lst.add(new Abonent(id, phone, name));
                    }
                    if (lst.size() > 0) {
                        System.out.println("База данных :" + lst + "\n");
                    } else {
                        System.out.println("Not found");
                    }

                } finally { // для 3-го блока try
                    /*
                     * закрыть ResultSet, если он был открыт
                     * или ошибка произошла во время
                     * чтения из него данных
                     */
                    if (rs != null) { // был ли создан ResultSet
                        rs.close();
                    } else {
                        System.err.println(
                                "ошибка во время чтения из БД");
                    }
                }
            } finally {
                /*
                 * закрыть Statement, если он был открыт или ошибка
                 * произошла во время создания Statement
                 */
                if (st != null) { // для 2-го блока try
                    st.close();
                    System.err.println("Statement close");
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException e) { // для 1-го блока try
            System.err.println("DB connection error: " + e);
            /*
             * вывод сообщения о всех SQLException
             */
        } finally {
            /*
             * закрыть Connection, если он был открыт
             */
            if (cn != null) {
                try {
                    cn.close();
                    System.err.println("Сonnection close.");
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }


    }


}
