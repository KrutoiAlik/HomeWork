import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkWithDB {

    Connection connection;

    public WorkWithDB(String url) throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    /**
     * Данный метод предназначен для просмотра результата запроса
     * @param sql
     * @return
     */
    List<String[]> getQueryResponse(String sql) throws SQLException {
        ResultSet set = this.connection.createStatement().executeQuery(sql);
        List<String[]> list = new ArrayList<>();
        while (set.next()) {
            String[] s = new String[set.getMetaData().getColumnCount()];
            for (int i = 0; i < s.length; i++) s[i] = set.getString(i + 1);
            list.add(s);
        }
        return list;
    }

    /**
     * Данный метод подходит для запросов удаления, изменения, добавления
     * @param sql
     * @throws SQLException
     */
    void runQuery(String sql) throws SQLException {
        connection.createStatement().executeUpdate(sql);
    }
}