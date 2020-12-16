package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    
    @Test
    @DisplayName("로또번호가 아니면 IllegalArgumentException 발생")
    void number_illegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LottoNumber(100));
    }

}