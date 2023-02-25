import java.sql.*;

public class SqlTest {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3305/JDBC_TEST";
        String user_name = "root";
        String password = "1111";

        /**
         * Class.forName(com.mysql.cj.jdbc.Driver"); <- Driver Load
         * JDK1.6(JDBC4) 부터는 getConnection 할 시에 Driver가 자동 로드됨. 나는 11이라 밑에 로직대로 실행하면 로드되는 것.
         * forName 안 써도 된다는 것임.
         * 간단해서 좋은듯.
         */

        Connection conn = DriverManager.getConnection(url, user_name, password);

        Statement st = conn.createStatement(); // Statement 객체 생성 입력하기 위해서

        ResultSet rs = st.executeQuery("select * from member"); // 출력문 작성 그것을 rs 객체에 저장

        while (rs.next()) {
            String id = rs.getString("id");
            String phone_number = rs.getString("phone_number");
            String address = rs.getString("address");
            String name = rs.getString("name");
            System.out.println( id +"/"+  name +"/"+  phone_number +"/"+  address);
        }

        rs.close();
        st.close();
        conn.close();

    }
}
