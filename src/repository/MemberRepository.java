package repository;

import member.Member;

public interface MemberRepository {

    /**
     * 회원조회
     * @param gradeNumber
     */
    void findMember(String gradeNumber) ;
}
