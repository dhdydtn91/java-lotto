package nextstep.lotto;

import nextstep.lotto.dto.*;
import nextstep.lotto.utils.LottoNumberUtil;
import nextstep.lotto.view.InputView;
import nextstep.lotto.view.ResultView;

import java.util.List;


public class LottoGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.playLottoGame();
    }

    private void playLottoGame() {
        LottoBuyManger lottoBuyManger = LottoBuyManger.create(inputView.inputTotalAmountForBuy(), inputView.inputManualLottoAmoutForBuy());
        LottoTickets userLottoTickets = buyTicket(lottoBuyManger);
        resultView.showLottoTicket(userLottoTickets, lottoBuyManger);

        LottoWinnerNumbers winnerNumbers = castWinnerNumber(inputView.inputWinnerNumber(), inputView.inputBonusNumber());

        resultView.showLottoResultBoard(LottoResultBoard.create(userLottoTickets.resultRank(winnerNumbers)));
    }


    private LottoWinnerNumbers castWinnerNumber(List<String> winnerNumbers, int bonusNumber) {
        return LottoWinnerNumbers.create(
                LottoNumberUtil.transStringNumberToLottoNumber(winnerNumbers),
                LottoNumber.create(bonusNumber)
        );
    }

    private LottoTickets buyTicket(LottoBuyManger lottoBuyManger) {
        List<LottoTicket> lottoTickets = buyManualTicket(lottoBuyManger.getManualLottoAmount());

        return LottoTickets.create(lottoTickets, lottoBuyManger.getAutoAmount());
    }

    private List<LottoTicket> buyManualTicket(int buyManualTicketCount) {
        return inputView.inputManualNumber(buyManualTicketCount);
    }

}