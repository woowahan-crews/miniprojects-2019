package techcourse.w3.woostagram.user.exception;

public class LoginException extends RuntimeException {
    private static final String ERROR_USER_NOT_FOUND = "아이디 또는 비밀번호를 다시 확인하세요.";

    public LoginException() {
        super(ERROR_USER_NOT_FOUND);
    }
}