package Member;

/**
 * 1. 회원번호 - memberNumber (ex : 1.. 2.. 3.. ) // PK로 지정한다. Generated.. 값이 1씩 증가하게끔.
 * 2. 아이디 - id (ex : abc123 ) // 최대 12자리까지 가능, PK로 지정함. 중복방지 O
 * 3. 비밀번호 - password (ex : 1q3e2w ) // 최대 16자리까지 가능
 * 4. 생년월일 - birthday (ex : 970528)
 * 5. 학번 - gradeNumber (ex : 10615) <- 1학년 6반 15번이라는 뜻
 */
public class Member {
    private int memberNumber;
    private String id;
    private String password;
    private String birthday;
    private String gradeNumber;

    public Member(int memberNumber, String id, String password, String birthday, String gradeNumber) {
        this.memberNumber = memberNumber;
        this.id = id;
        this.password = password;
        this.birthday = birthday;
        this.gradeNumber = gradeNumber;
    }
    public Member() {}

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(String gradeNumber) {
        this.gradeNumber = gradeNumber;
    }
}
