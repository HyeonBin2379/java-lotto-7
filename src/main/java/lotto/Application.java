package lotto;

import static lotto.config.AppConfig.lottoInputController;
import static lotto.config.AppConfig.inputView;
import static lotto.config.AppConfig.outputView;
import static lotto.config.LottoCheckerConfig.lottoCheckerController;
import static lotto.config.LottoMachineConfig.lottoMachineController;

import java.util.List;
import lotto.dto.LottoResultDTO;
import lotto.dto.WinningLottoDTO;
import lotto.model.Lotto;

public class Application {

    public static void main(String[] args) {
        purchaseLotto();
        printResult();
    }

    public static void purchaseLotto() {
        Integer totalCost = lottoInputController.inputSingleValue(inputView::inputTotalCost);
        List<Lotto> purchased = lottoMachineController.purchase(totalCost);

        lottoCheckerController.setPurchasedLotto(purchased, totalCost);

        outputView.displayLottoNumbers(purchased);
    }

    public static void printResult() {
        WinningLottoDTO winningLotto = lottoInputController.inputWinningCondition();
        LottoResultDTO result = lottoCheckerController.checkPurchasedLottoRank(winningLotto);

        outputView.displayLottoStatistic(result.getResult(), result.getProfitPercentage());
    }
}
