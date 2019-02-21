package ipb.yabi.DatabaseReader;

import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class DatabaseReader {

    public DatabaseReader() {
    }

    @CrossOrigin
    public static ArrayList<ArrayList<String>> runQuery(SqlQuery query)
            throws SQLException {
        
        System.out.println("Command: " + query.getCommand());
        Directory dir = query.getDirectory();
        System.out.println("Database: " + dir.getName());

        Connection con = DriverManager.getConnection(
                dir.getConnectionString(),
                dir.getUsername(),
                dir.getPassword());

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query.getCommand());

        return readResultSet(rs);
    }

    private static ArrayList<ArrayList<String>> readResultSet(ResultSet rs)
            throws SQLException {

        ArrayList<ArrayList<String>> data = new ArrayList<>();//return variable

        //extract metadata        
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<String> columnNames = new ArrayList<>();

        //adds column information
        for (int column = 1; column < columnCount + 1; column++) {
            columnNames.add(
                    rsmd.getColumnName(column));
        }
        data.add(columnNames);

        //reads data
        while (rs.next()) {
            data.add(readRow(rs, columnCount));
        }

        return data;
    }

    private static ArrayList<String> readRow(
            ResultSet rs,
            int columnCount)
            throws SQLException {

        ArrayList<String> row = new ArrayList<>();
        for (int column = 1; column < columnCount + 1; column++) {
            row.add(rs.getString(column));
        }

        return row;
    }

    private static ArrayList<Integer> readTypes(ResultSetMetaData rsmd) throws SQLException {
        long columnCount = rsmd.getColumnCount();

        ArrayList<Integer> types = new ArrayList<>();

        for (int column = 1; column < columnCount + 1; column++) {
            types.add(rsmd.getColumnType(column));
        }

        return types;
    }

}
