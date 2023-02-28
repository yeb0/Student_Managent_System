package repository;

import java.sql.*;

public class MemberRepositoryImpl implements MemberRepository {
    /**
     * 회원조회
     * @param gradeNumber 회원의 학번 입력하기
     */
    @Override
    public void findMember(String gradeNumber)  {
        String url = "jdbc:mysql://localhost:3305/JDBC_TEST";
        String user_name = "root";
        String password = "1111";

        Connection conn = null;

        PreparedStatement preparedStatement = null; // sql 문

        ResultSet rs = null; // 출력문 작성 그것을 rs 객체에 저장

        String grade_Number = "gradeNumber";
        try {
            conn = DriverManager.getConnection(url, user_name, password);

            String sql = " select id, password, birthday, gradeNumber, name " +
                    " from member " +
                    " where gradeNumber = ? ";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, gradeNumber);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String user_id = rs.getString("id");
                String user_password = rs.getString("password");
                String birthday = rs.getString("birthday");
//                String gradeNumber = rs.getString("gradeNumber");
                String name = rs.getString("name");
                System.out.println(name + " 님 안녕하세요 ! ");
                System.out.println("----------INFO----------");
                System.out.println("USER ID : " + user_id);
                System.out.println("USER PW : " + user_password);
                System.out.println("USER BD : " + birthday);
                System.out.println("USER GN : " + gradeNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
