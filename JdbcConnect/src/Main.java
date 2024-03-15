import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String usrName = "postgres";
            String pwd = "01071994";
            Connection conn = DriverManager.getConnection(url,usrName,pwd);
            System.out.println("Connection established");
            Statement st = conn.createStatement();
//            String sql = "insert into demo values (1,'Mukesh',100)";
//            boolean rs;
//            if (st.execute(sql)) rs = true;
//            else rs = false;

            System.out.println("Inserted Successfully");
            String sql1 = "insert into demo values(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql1);
            pst.setInt(1,2);
            pst.setString(2, "Mohanraj");
            pst.setInt(3, 90);
            pst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}