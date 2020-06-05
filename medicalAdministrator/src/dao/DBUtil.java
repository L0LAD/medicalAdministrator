package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
   public static void setUsername (String username) {
      DBUtil.username = username ;
   }

   public static void setPassword (String password) {
      DBUtil.password = password ;
   }

   public static void setHost (String host) {
      DBUtil.host = host ;
   }

   public static void setNumPort (String numPort) {
      DBUtil.numPort = numPort ;
   }

   public static void setBase (String base) {
      DBUtil.base = base ;
   }
   
  private static String username ; //= "user";
  private static String password ; //= "usr";
  private static String host     ; //= "localhost";
  private static String numPort  ; //= "5432";
  private static String base     ; //= "soins";
  static {
    try {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:postgresql://" + host + ":" + numPort + "/" + base, username, password);
  }
}
