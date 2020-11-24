import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        /**
         * MySQLの接続可否確認
         */
        long count = DriverManager.drivers().count();
        System.out.println("ドライバーの数: " + count);
        System.out.println("ドライバー一覧: " + DriverManager.drivers().map(Object::toString).collect(Collectors.joining()));

        String url = "jdbc:mysql://localhost:13306/exam";
        String user = "guest_user";
        String password = "guest_password";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DBコネクション: " + connection);
            System.out.println("接続成功");
        } catch (SQLException e) {
            System.out.println("MySQLの起動、MySQLのドライバーのインストール、MySQLの接続情報の3点を確認してください");
            e.printStackTrace();
        }
    }
}
