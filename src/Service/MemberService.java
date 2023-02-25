package Service;

public interface MemberService {
    /**
     * 회원가입
     * @param id, password, birthday, gradeNumber, name 회원의 정보 입력하기
     */
    void signUp(String id, String user_password, String birthday, String gradeNumber, String name) ;

    /**
     * 회원조회
     * @param gradeNumber 회원의 학번 입력하기
     */
    void findMember(String gradeNumber) ;

    /**
     * 회원탈퇴
     */
    void withdraw(String id, String user_password, String name);

    /**
     * 회원수정(정보)
     */
    void update(String id, String user_password, String gradeNumber);
}
