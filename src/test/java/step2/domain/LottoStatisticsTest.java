package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {


    @DisplayName("총수익이 0이면 0이다.")
    @Test
    void ZeroProfit() {
        //given
        int paymentMoney = 1000;
        List<Integer> matchResult = List.of(0, 0, 0);

        //when
        LottoStatistics lottoStatistics = new LottoStatistics(paymentMoney, matchResult);

        //then
        assertThat(lottoStatistics.getStringEarningRate()).isEqualTo("0.00");
    }

    @DisplayName("수익률은 소수 2번째 자리까지 계산한다.")
    @Test
    void statistics_소수점() {
        //given
        int paymentMoney = 2000;
        List<Integer> matchResult = List.of(4, 0, 0);

        //when
        LottoStatistics lottoStatistics = new LottoStatistics(paymentMoney, matchResult);

        //then
        assertThat(lottoStatistics.getStringEarningRate()).isEqualTo("25.00");
    }

    @DisplayName("매칭된 로또들을 그룹화한다.")
    @Test
    void matchOfLotto_계산() {
        //given
        int paymentMoney = 1000;
        List<Integer> matchResult = List.of(4, 0, 0);
        LottoStatistics lottoStatistics = new LottoStatistics(paymentMoney, matchResult);

        //when
        Map<Integer, List<Rank>> matchGroup = lottoStatistics.statistics(matchResult);

        //then
        assertThat(matchGroup.get(0).size()).isEqualTo(2);
        assertThat(matchGroup.get(6).size()).isEqualTo(0);
        assertThat(matchGroup.get(4).size()).isEqualTo(1);
    }

}