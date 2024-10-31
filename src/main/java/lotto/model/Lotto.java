package lotto.model;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;
import static lotto.util.validator.LottoNumberValidator.validateNumberCount;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicated(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().toList();
    }

    public Integer countSameNumber(final List<Integer> winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public Boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public Boolean isSecondRank(final List<Integer> winningNumbers, final Integer bonusNumber) {
        return countSameNumber(winningNumbers) == 5 && contains(bonusNumber);
    }
}
