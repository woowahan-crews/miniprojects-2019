package techcourse.w3.woostagram.user.exception;

public class UserProfileException extends RuntimeException {
    private static final String ERROR_USER_PROFILE = "파일이 제대로 선택되지 않았습니다.";

    public UserProfileException() {
        super(ERROR_USER_PROFILE);
    }
}