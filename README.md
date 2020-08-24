# 로또
#로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
# 로또 1장의 가격은 1000원이다. -> 매직넘버
#로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
# Collections.sort() 메소드를 활용해 정렬 가능하다.
# ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
# Lotto 클래스 필요한 사항 : 당첨금액(enum?), 맞춘갯수,
# 수익률계산 클래스 필요한 사항 : List<Lotto>, 손익률


# 해당 부분도 인터페이스 타입으로 변경되면 좋을 것 같아요 :)
# -> List 타입으로 변경

#다음과 같이 정수값을 VO 객체로 포장해보면 어떨까요?
#Value Object를 사용한다면 어떤 장점이 있을까요 :) ?
#해당 코멘트와 같이 고민해보시면 좋을 것 같습니다!
#private static final List<LottoNumber> ALL_LOTTO_NUMBER = AllLotto.makeAllLottoNumber();
# -> LottoNumber객체 생성

#해당 부분은 출력에서 수행해준다면 좋을 것 같아요 :)
#-> 출력에서 수행하게 변경

#로또 번호의 범위 외에 값으로도 로또 번호가 만들어지는 것 같아요.
# -> 생성자에서 예외 체크



#현재 AllLotto라는 클래스명만 봐서는 정확히 어떤 클래스인지 유추하기 힘든것 같아요 
# 오히려 기존에 존재하고 있는 LottoFactory 클래스명이 로또를 생성해주는 책임을 수행하고 있다는게 강하게 느껴지네요!
# 해당 로직을 LottoFactory로 옮기거나 AllLotto 클래스 명을 변경해주시면 좋을 것 같아요 :)
# -> AllLotto 삭제, LottoFactory로 변경


#서드를 위에서 아래로 물 흐르듯이 읽을 수 있도록 순서를 고려해주시면 좋을 것 같아요 :)
# -> 순서 변경

#Lotto, AllLotto, MakeLottoFactory 의 테스트를 작성해주세요!

#테스트 코드가 길다면 어떤 테스트를 수행하고 있는지 파악하기 어려운 것 같아요.
# @DisplayName 어노테이션을 이용하여 수행하고 있는 테스트의 설명이나 목적을 작성해주시면 좋을 것 같아요 :)
 
#의미없는 공백은 제거해주세요! 
#-> 의미없는 공백 제거

#Lotto 객체에 getWinningCount() 메서드가 존재하지 않아 컴파일 에러가 발생하고 있습니다..!
# 확인해주시면 감사하겠습니다 :)
# -> 컴파일 에러 수정

#중복되는 테스트 코드가 보이네요!
# @BeforeEach를 이용하여 테스트 코드의 중복을 최소화하도록 개선하시면 좋을 것 같아요 :)
# -> BeforEach 적용, 중복 최소화

#해당 객체의 책임은 무엇으로 정의하셨나요 :) ?
# lottoList 인스턴스 필드를 가지지 않고 lottoList를 갖고 있는 Lotto 객체에게
# 당첨 번호를 파라미터로 전달하는 방법을 이용한다면 어떤 장점이 있을까요 :) ?
# -> 당첨번호를 파라미터로 수정한 이후에, 객체가 스스로 당첨판단하지 않게 판단한 이후 해당 부분 제거했습니다.

#Lotto 객체가 스스로 당첨 판단을 하지 않고 있는데 당첨 금액을 가지고 있을 필요가 있는지에 대해 고민해보아요 :)
# -> 객체가 스스로 판단하지 않게 변경했습니다. 많은 부분이 수정되는데, 많은 부분이 간단해지네요.. 하아..
