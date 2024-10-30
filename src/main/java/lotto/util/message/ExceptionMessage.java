package lotto.util.message;

public enum ExceptionMessage {

    BLANK_INPUT("빈 문자열을 입력했습니다."),
    NOT_INTEGER("정수로 변환할 수 없는 문자열입니다."),
    NOT_POSITIVE_INTEGER("입력한 값이 양의 정수가 아닙니다."),
    NOT_DIVIDED_TO_LOTTO_PRICE("로또 구입 금액이 로또 1장의 가격으로 나누어떨어지지 않습니다."),

    ILLEGAL_DELIMITER_USE("쉼표의 사용 방식이 올바르지 않습니다."),
    LOTTO_NUMBER_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호 중 중복된 번호가 있습니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호와 중복되는 로또 번호가 있습니다."),
    WINNING_NUMBER_NOT_IN_RANGE("1~45 사이 정수가 아닌 당첨 번호가 존재합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[ERROR] %s", message);
    }
}