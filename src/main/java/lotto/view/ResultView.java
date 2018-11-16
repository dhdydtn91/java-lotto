package lotto.view;

import lotto.domain.*;

public class ResultView {

    public static void showLottoCount(LottoCountManager lottoCountManager) {
        System.out.println("수동으로 " + lottoCountManager.getManualCount() +
                "장 자동으로 " + lottoCountManager.getAutoLottoCount() + "개를 구매했습니다.");
    }

    public static void showLottoNumbers(BundleLotto lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            makeLottoString(sb, lotto);
            String s = sb.substring(0, sb.lastIndexOf(",")) + " ]";
            System.out.println(s);
        }
    }

    private static void makeLottoString(StringBuilder sb, Lotto lotto) {
        for (LottoNo lottoNo : lotto.getLottoNumbers()) {
            sb.append(lottoNo.getLottoNumber()+", ");
        }
    }

    public static void showResult(LottoGameResult lottoGameResult) {
        StringBuilder sb = new StringBuilder();

        for (LottoDto lottoDto : lottoGameResult.getLottoDtos()) {
            sb.append(lottoDto.getWinnerCategory() + "개 일치 (" + lottoDto.getDefaultMoney() + "원)-" + lottoDto.getMatchNumber() + "개\n");
        }

        System.out.println(sb.toString());
    }

    public static void showRatioResult(String ratio) {
        System.out.println("총 수익률은 " + ratio + "입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
    }
}