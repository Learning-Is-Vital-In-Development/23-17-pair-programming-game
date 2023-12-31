# Pair Programming - Kotlin Lotto

> 자유롭게, 하고 싶은 대로, 하고 싶은 만큼, 함께 코딩하기

## 목표

이 스터디는 **요구사항 및 기능을 직접 정의**해나가면서, **페어 프로그래밍을 위한 커뮤니케이션**에 초점을 맞추고 있어요. 부담갖지 마시고 하고 싶은 모든 걸 해보시기 바랍니다. 다른 팀원이 추가한 기술이나
구현 방식이 접해보지 못한 새로운 내용이라면, 함께 이야기해볼 수 있는 좋은 기회가 될거에요!

## 진행 과정

먼저 모든 팀원은 미션 저장소를 자신의 개인 저장소로 fork 합니다.

1. 기능과 관련된 적절한 이름의 branch 를 생성 후 commit 합니다
2. 2번의 과정이 끝나면 local 에만 변경사항이 반영되어 있으므로 본인의 remote 저장소에 push 합니다
3. 본인의 remote 저장소에 push 가 완료되면, github 에서 pull request 를 생성합니다
4. (Optional) 아직 기능이 완성되진 않았지만, 진행상황 공유 등의 이유로 PR 을 먼저 생성하고 싶다면 draft 로 만들어보세요
5. Ready 상태의 PR 이 생성되면 리뷰어들은 코드 리뷰를 시작합니다
6. 리뷰가 완료되면 assignee 는 PR 을 merge 하고, 위 과정을 반복합니다

## 규칙

> 자세한 내용은 [Contribution Guide Line](https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/blob/main/CONTRIBUTING.md) 을 참고해주세요

- PR 은 다음 팀원이 이어서 진행하기 쉽도록 기능 단위로 생성해주세요
- Kotest 를 사용하는 테스트 코드를 작성해주세요
- 항상 실행가능한 상태를 유지해주세요
- Ktlint 는 가급적 모두 통과시켜주세요

## 가이드

아래 내용은 로또의 가장 기본적인 규칙이에요. 뭘 구현해야할지 막막하다면 현재 진행상황과 아래 규칙을 비교해보세요!

- 구입 금액 입력
- 구입 금액에 따라 1장에 1000원씩 계산하여 로또 발급하기
- 로또 한장에는 6개의 숫자가 담겨있다
- 수동으로 구매한 로또 수 입력
    - 입력한 금액을 벗어나는 경우 예외 처리
- 수동 로또수에 따라 하나의 로또당 6개의 번호를 입력해야함
- 수동 로또를 제외하고 나머지 금액은 자동 로또 발급
- 지난 주 당첨 번호와 보너스볼을 입력
- 당첨번호와 보너스볼과 일치하는 개수에 따라 통계를 내기
- 통계에는 3개 일치, 4개 일치, 5개 일치, 5개 일치 + 보너스볼 , 6개 일치하는 로또 개수를 보여주고, 수익률을 계산한다.(기준 1)
    - 수익률은 당첨 금액 / 원금 으로 계산한다.
