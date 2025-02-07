package techcourse.w3.woostagram.user.exception;

import techcourse.w3.woostagram.common.exception.WoostagramException;

public class UserNotFoundException extends WoostagramException {
    private static final String ERROR_USER_NOT_FOUND = "해당 유저는 존재하지 않습니다.";

    public UserNotFoundException() {
        super(ERROR_USER_NOT_FOUND);
    }
}
