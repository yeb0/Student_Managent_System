package repository;

import member.Member;

public interface MemberRepository {

    /**
     * ํ์์กฐํ
     * @param gradeNumber
     */
    void findMember(String gradeNumber) ;
}
