package Service;

import Member.Member;

import java.sql.*;

public class MemberServiceImpl implements MemberService{

    /**
     * 회원가입
     * @param id, password, birthday, gradeNumber, name 회원의 정보 입력하기
     */
    @Override
    public void signUp(String id, String user_password, String birthday, String gradeNumber, String name)  {
        String url = "jdbc:mysql://localhost:3305/JDBC_TEST";
        String user_name = "root";
        String password = "1111";

        Connection conn = null;

        PreparedStatement preparedStatement = null; // sql 문

        ResultSet rs = null; // 출력문 작성 그것을 rs 객체에 저장

//        String grade_Number = "gradeNumber";
        try {
            conn = DriverManager.getConnection(url, user_name, password);

            String sql = " insert into member (id, password, birthday, gradeNumber, name) " +
                    "values (?, ?, ?, ?, ?); ";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, user_password);
            preparedStatement.setString(3, birthday);
            preparedStatement.setString(4, gradeNumber);
            preparedStatement.setString(5, name);
//            rs = preparedStatement.executeQuery();

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("SUCCESS : 회원의 정보가 저장되었습니다 !");
            } else {
                System.out.println("FAILED : 회원의 정보를 저장하지 못했습니다.");
                System.out.println("다시 입력해 주세요.");
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

    /**
     * 회원탈퇴
     * @param id, user_password, name -> 입력하면 해당 입력값에 맞는 정보 delete
     */
    @Override
    public void withdraw(String id, String user_password, String name) {
        String url = "jdbc:mysql://localhost:3305/JDBC_TEST";
        String user_name = "root";
        String password = "1111";

        Connection conn = null;

        PreparedStatement preparedStatement = null; // sql 문

        ResultSet rs = null; // 출력문 작성 그것을 rs 객체에 저장

        try {
            conn = DriverManager.getConnection(url, user_name, password);

            String sql = " delete from member " +
                    "where id = ? and password = ? and name = ? ";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, user_password);
            preparedStatement.setString(3, name);

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("SUCCESS : 회원의 정보가 삭제되었습니다 !");
            } else {
                System.out.println("FAILED : 회원의 정보를 삭제하지 못했습니다.");
                System.out.println("다시 입력해 주세요.");
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

    /**
     * 회원수정이지만 아직은 학번만 변경하도록 설계함.
     * @param id, password, gradeNumber
     */
    @Override
    public void update(String gradeNumber, String id, String user_password) {
        String url = "jdbc:mysql://localhost:3305/JDBC_TEST";
        String user_name = "root";
        String password = "1111";

        Connection conn = null;

        PreparedStatement preparedStatement = null; // sql 문

        ResultSet rs = null; // 출력문 작성 그것을 rs 객체에 저장

        try {
            conn = DriverManager.getConnection(url, user_name, password);

            String sql = " update member set " +
                    " gradeNumber = ? " +
                    " where id = ? and password = ? ";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, gradeNumber);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, user_password);

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("SUCCESS : 회원의 정보(학번)가 수정되었습니다 !");
            } else {
                System.out.println("FAILED : 회원의 정보(학번)를 수정하지 못했습니다.");
                System.out.println("다시 입력해 주세요.");
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
