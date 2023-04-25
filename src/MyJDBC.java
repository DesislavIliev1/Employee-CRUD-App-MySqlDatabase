import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeapp", "root", "des20sislav10");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employees");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("fullName"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
