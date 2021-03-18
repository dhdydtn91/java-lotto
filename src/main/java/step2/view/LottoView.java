package step2.view;

import step2.dto.LottoDto;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {

    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String COUNT_OF_LOTTO_PURCHASED = "개를 구매 했습니다.";
    public static final String DELIMITER = ",";
    public static final String LOTTO_INFO = "[%s]\n";
    public static final String INPUT_WIN_NUMBER = "지난주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String STATISTICS = "당청통계";
    public static final String DIVISION_LINE = "---------";
    public static final String COUNT_OF_MATCH = "%d개 일치%s (%d)- %d원\n";
    public static final String RETURN_OF_RATE = "총 수익률은 %5.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    public static final String PROFIT = "이득";
    public static final String LOSS = "손해";
    public static final String MATCH_OF_BONUS = ", 보너스 볼 일치";
    public static final int BREAK_EVEN_POINT = 1;
    public static final int SECOND_WIN_MONEY = 30000000;
    
    private final Scanner scanner;
    public int paymentMoney;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int paymentMoney() {
        System.out.println(INPUT_MONEY);
        this.paymentMoney = scanner.nextInt();
        return paymentMoney;
    }

    public void lottoInfoPirnt(LottosDto lottosDto) {
        List<LottoDto> lottoDtoList = lottosDto.getLottoDtoList();
        System.out.println(lottoDtoList.size() + COUNT_OF_LOTTO_PURCHASED);
        lottoDtoList.forEach(dto -> System.out.printf(LOTTO_INFO, toString(dto.getLottoNumbers())));
    }

    private String toString(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    public String inputWinNumber() {
        System.out.println(INPUT_WIN_NUMBER);
        scanner.nextLine(); //scanner.nextLine() 사용전 nextInt()를 사용하면 스킵되는 현상때문에 추가
        return scanner.nextLine();
    }

    public int inputBonusInput() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }

    public void finish(LottoStatisticsDto lottoStatisticsDto) {
        List<Integer> rankList = lottoStatisticsDto.getRankList();
        List<Integer> winningMoney = lottoStatisticsDto.getWinningMoney();
        List<Long> countOfRank = lottoStatisticsDto.getCountOfRank();
        double ratioOfReturn = lottoStatisticsDto.getRatioOfReturn();
        statisticsPrint(rankList, winningMoney, countOfRank, ratioOfReturn);

    }

    public void statisticsPrint(List<Integer> rankList, List<Integer> winningMoney, List<Long> countOfRank, double ratioOfReturn) {
        System.out.println(STATISTICS);
        System.out.println(DIVISION_LINE);
        for (int i = 0; i < winningMoney.size(); i++) {
            System.out.printf(COUNT_OF_MATCH, rankList.get(i), printBonus(winningMoney.get(i)), winningMoney.get(i), countOfRank.get(i));
        }
        System.out.printf(RETURN_OF_RATE, ratioOfReturn, setBenefitOrLoss(ratioOfReturn));
        //총 수익률은 %5.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)
    }

    private String printBonus(int winningMoney) {
        if (winningMoney == SECOND_WIN_MONEY) {
            return MATCH_OF_BONUS;
        }
        return " ";
    }

    private String setBenefitOrLoss(double ratioOfReturn) {
        String message = LOSS;
        if (BREAK_EVEN_POINT < ratioOfReturn) {
            message = PROFIT;
        }
        return message;
    }
}