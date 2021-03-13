package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
    }

    @DisplayName("로또 생성를 생성")
    @Test
    void createLotto() {
        int count = 4;

        Lottos resultLottos = lottos.createLottoList(count);

        assertThat(resultLottos.lottoCount()).isEqualTo(4);
    }

    @DisplayName("로또마다 당첨번호 매칭 후 결과 값은 로또 갯수와 같다")
    @Test
    void staticsOfMatch() {
        //given
        Lottos lottos = createLottos();
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        List<Rank> ranks = lottos.staticsOfMatch(winNumber);

        assertThat(ranks.size()).isEqualTo(4);
        assertThat(ranks.get(0)).isEqualTo(Rank.FIRST);
        assertThat(ranks.get(1)).isEqualTo(Rank.SECOND);
    }

    Lottos createLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottoList.add(new Lotto(List.of(2, 3, 4, 5, 11, 24)));
        return new Lottos(lottoList);
    }
}