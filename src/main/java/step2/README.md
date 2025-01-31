# Step2. 로또 계산기

### 기능 요구사항

1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
2. 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능구현 목록

- [X] View 입력 기능 추가
- [X] 로또 생성기능 추가
- [X] View 로또 출력 기능 추가
- [X] View 당첨번호 입력 기능 추가
- [X] 당첨 통계 기능 추가
- [X] 리팩토링

# Step2. 로또 계산기(2등)

### 기능 요구사항

1. 2등을 위해 추가 번호를 하나 더 추첨한다.
2. 당첨 통계에 2등도 추가해야 한다.

### 기능구현 목록

- [X] 보너스 볼 입력 기능 추가 - view
    - [x] 보너스 볼 번호는 기존 당첨 번호와 달라야 한다. - Lotto
    - [x] 보너스 볼은 1 ~ 45번 이여야 한다.
    - [x] 보너스 볼은 한개만 뽑을 수 있다.

- [x] Rank enum 객체 리팩토링
    - [x] 2등을 추가 한다.
    - [x] 5개 맞출때는 3등을 이다.
    - [x] 5개를 맞추고 보너스를 맞춰야 2등이다.

- [x] 츨력기능 리팩토링

  