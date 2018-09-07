package ipb.yabi.test.testPojo;

import ipb.yabi.Directory.Directory;
import java.util.ArrayList;
import lombok.Getter;



/**
 *
 * @author hydrocat
 */
public class DirectoriesForTesting {
    
    @Getter public static Directory maria    = new Directory(10l, "jdbc:mysql/localhost/Chinook:3306",    "MariaDB", "root",    "root");
    @Getter public static Directory oracle   = new Directory(20l, "jdbc:oracle:thin:@//localhost:1521",   "OracleXE", "chinook",  "p4ssw0rd");
    @Getter public static Directory postgres = new Directory(30l, "jdbc:postgresql://localhost/chinook","Postgres", "postgres","root");
    @Getter public static Directory sqlserver= new Directory(40l, "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=Chinook","SqlServer", "sa", "rootPassword1");
    @Getter public static Directory[] dirs = {maria,oracle,postgres,sqlserver};
    
}
