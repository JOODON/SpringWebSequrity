package service;
//로그인 정보와 암호 정보를 가지고 있는 객체 생성
public class UserEntity {
    private String loginUserId;
    private String password;

    public UserEntity(String loginUserId, String password) {
        this.loginUserId = loginUserId;
        this.password = password;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
