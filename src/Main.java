import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "Engeto", "JavaEngeto123");
      Statement statement = connection.createStatement();
   //     getAllFlowers(statement);
   //     System.out.println("\n");
      statement.executeUpdate("Insert into flowers (Name, Colour, Description, Poisonous) values ('bledule', 'modrá', 'lesní', true)");
      statement.executeUpdate("Insert into flowers (Name, Colour, Description, Poisonous) values ('kopretina', 'žlutá', 'polní', false)");
      statement.executeUpdate("update flowers set Description = 'Pozor na cibulku - obsahuje největší koncentraci jedu' where Name = 'bledule'");
      statement.executeUpdate("delete from flowers where Poisonous = false");
      getAllFlowers(statement);

     }

    private static ResultSet getAllFlowers(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from flowers");
        while(resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        //    System.out.println(resultSet.getInt("id"));
        }
        return resultSet;
    }
}




