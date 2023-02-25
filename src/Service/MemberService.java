package Service;

import Member.Member;

public interface MemberService {
    /**
     * 회원가입
     * @param member 회원의 정보 입력하기
     */
    void singUp(Member member);

    /**
     * 회원조회
     */
    void findMember();

    /**
     * 회원탈퇴
     */
    void withdraw(Member member);

    /**
     * 회원수정(정보)
     */
    void update();
}
