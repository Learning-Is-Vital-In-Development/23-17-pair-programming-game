# Contribution Guide Line

> 본 문서는 언제든 변경될 수 있습니다. Issue 를 생성해주시거나, Discord 를 통해 의견을 전달해주세요.

본 문서는 스터디를 원활하게 진행하기 위한 가이드라인을 구성원들에게 제공하는 것을 목표로 작성되었습니다.

## Test 작성

이 스터디의 핵심 학습 목표이기도 한 [Kotest](https://kotest.io/) 는
다양한 [Testing Style](https://kotest.io/docs/framework/testing-styles.html) 을 지원합니다.

취향에 맞는 방식의 Spec 을 사용하시면서 어떤 Spec 이 어떤 상황에 어울리는지 고민해보시는 것도 좋습니다. 다만 **Annotation Spec 의 경우는 Java 의 JUnit5 와 거의 차이가 없기 때문에
Kotlin Style 을 학습하는 이 스터디의 목표와는 맞지 않다**고 생각되기 때문에 제외합니다.

## Pull Request Guide

- PR 은 기능 단위로 생성해주세요
    - 중간에 구현이 막혔다면, 어떤걸 하려했고 어떤 부분이 막혔는지를 PR 을 통해 대략적으로 설명해주세요
    - 이것밖에 구현 못했는데 괜찮나? 라고 생각하지 않아도 괜찮습니다. 그냥 마음편히 던지세요! 코드의 절대적인 양은 이 스터디에서 중요하지 않습니다
    - 기능 구현이 아니라 Refactoring 이여도 괜찮습니다
- 원활한 리뷰 진행을 위해 항상 실행가능한 상태를 유지해주세요
- Ktlint 는 가급적 모두 통과시켜주세요
    - 다소 엄격하다고 생각될 수 있지만, Standard Rule 로 설정되어 있으므로 Kotlin 진영에서 권장하는 스타일은 무엇인지 살펴볼 수 있는 기회가 될거에요

최대한 편리하게 PR 생성 및 리뷰 과정이 이루어질 수 있도록 자동화를 적용해뒀습니다. 몇 가지를 간단하게 소개해드릴게요.

### Size Labeling

PR 을 생성하면 코드의 변경 내용을 기반으로 size 라벨링이 진행됩니다.

<img width="924" alt="Pasted image 20230906205001" src="https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/304f520e-6c06-4bbd-82f0-aece04ca7a3a">

리뷰어는 라벨만 봐도 리뷰해야할 코드 양을 대략적으로 파악할 수 있습니다.

- `XS` : 1 ~ 9 lines
- `S` : 10 ~ 29 lines
- `M` : 30 ~ 99 lines
- `L` : 100 ~ 499 lines
- `XL` : 500 ~ 999 lines
- `XXL` : 1000+ lines

### Codecov

PR 을 생성하면 작성된 코드를 테스트한 뒤 커버리지 리포트를 생성합니다.

<img width="939" alt="Pasted image 20230906205436" src="https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/5ed8e928-297b-4d50-b5b1-0117a3cde625">

만약 이전보다 커버리지가 감소한다면 PR 검사가 실패합니다. 조건을 만족해야 빌드가 가능하니 테스트에 신경써주세요. 관련
설정은 [build.gradle.kts](build.gradle.kts) 에서 확인하실 수 있습니다.

https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/blob/b375fd6cc2fbf6f6c3a258be5fd1b31526505aac/build.gradle.kts#L48-L57

### Ktlint

- `./gradlew ktlintCheck` 를 실행하면 ktlint 를 local 환경에서 실행해보실 수 있습니다.
- `./gradlew ktlintFormat` 을 실행하면 ktlint 가 자동으로 코드를 수정해줍니다.
- `./gradlew build` 에는 `ktlintCheck` 가 포함되어 있습니다.

Kotest 와 함께 본 스터디의 핵심 학습 목표입니다.

코드 스타일은 [Kotlin Standard Rule](https://pinterest.github.io/ktlint/1.0.0/rules/standard/) 을 따르고 있습니다.

<img width="1147" alt="Pasted image 20230906210528" src="https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/1ac9696c-dc6e-4cba-b10e-6a8e031e72d1">

코드 스타일이 다르다면 PR 상태 체크가 실패하니 기여자는 코드 스타일을 준수해주세요.

### 정족수 Approve

PR 을 merge 하기 위해서는 최소 2명의 승인이 필요합니다. 기본적으로는 **전체인원 / 2** 로 설정합니다.

### Merge

Approve 가 완료되면 **다음 Assignee 가 원하는 시점에 PR 을 merge** 하고 과정을 반복합니다.

## Reviewer Guide

좋은 코드 리뷰, 즉 **서로에게 도움이 되는 커뮤니케이션**은 이번 스터디의 핵심입니다. 어떻게 하면 좋은 리뷰를 남길 수 있을지 함께 고민해보기 전에 참고해볼만한 자료들을 링크해두었습니다.

- [코드 리뷰 코멘트는 어떻게 작성하면 좋을까? 코드 리뷰 원칙 들여보기](https://mong-blog.tistory.com/entry/Team-%EC%BD%94%EB%93%9C-%EB%A6%AC%EB%B7%B0-%EC%BD%94%EB%A9%98%ED%8A%B8%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%9E%91%EC%84%B1%ED%95%98%EB%A9%B4-%EC%A2%8B%EC%9D%84%EA%B9%8C-%EC%BD%94%EB%93%9C-%EB%A6%AC%EB%B7%B0-%EC%9B%90%EC%B9%99-%EB%93%A4%EC%97%AC%EB%B3%B4%EA%B8%B0)
- [Best Practice 1 - zzimkkong](https://github.com/woowacourse-teams/2021-zzimkkong/pull/969)

위 내용을 기반으로 우리의 스터디 목적에 맞게 재구성해봤어요.

### 1. 리뷰는 최대한 빠르게

> 우리는 지금 폭탄 돌리기를 하고 있다고 생각해보세요. 😂 나보다 앞에서 너무 오래 들고 있다면...? 🧨💥

리뷰가 최대한 빠르게 진행되어야 전체적인 흐름이 원활하게 유지될 수 있어요.

다음 Assignee 의 충분한 구현 시간 보장을 위해 가급적이면 빠르게 리뷰가 진행되도록 노력해주세요.
Assignee 는 Approve 개수가 충분하다면 언제든지 PR 을 merge 할 수 있는 권한을 가집니다.
원하는 시점에 merge 하고 다음 과정을 진행해주세요.

### 2. 의견은 근거와 함께

Fact(사실)와 Opinion(의견)을 구분하고, 의견이라면 합리적인 근거와 함께 전달해주세요.

#### 올바른 예 👍

> `get~` 네이밍은 최근 클린코드 개념과는 멀어지고 있다고 생각해요(의견).
>
> Java 또한 record class 를 제시하며 `get` 키워드를 제거했어요(근거).
>
> kotlin 에서는 property 라는 대안도 있으니 `get~` 보다는 property 를 사용하시는게 어떨까요?(결론)
>
> - [Java 14 Record Keyword](https://www.baeldung.com/java-record-keyword) (공신력 있는 자료까지)

#### 안좋은 예 👎

> 굳이 왜 `get~` 를 사용하시나요? Kotlin 은 property 인거 모르시나요? (부정적 표현)
>
> 여기 수정하세요 (명령형 표현)

### 3. 리뷰는 최대한 친절하게

이 스터디에서는 LGTM(Look Good To Me) 또한 얼마든지 허용할 생각이에요.
하지만 의아한 부분이 있다면 얼마든지 자신의 의견을 적극적으로 피력해주세요! 서로의 스타일을 알아가기 위해서는 많은 이야기가 필요하니까요~

LGTM 라면 👍 이나 짤과 함께 칭찬합시다!

![ghisisgood](https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/ccb7e040-e18e-4c14-b4ee-42d21b881fa8)

### 4. 리뷰어 지정 방식

기본적으로 Team 인원 모두를 지정합니다. 자동화되어 있기 때문에 별도로 지정할 필요는 없어요.

merge 에 필요한 Approve 는 2개만 필요하니, 너무 늦게 PR 을 확인하시면 이미 merge 가 끝나있을 수 있어요~ 😂

### 5. Assignee 지정 방식

시작 전 짧은 OT 를 통해 순서를 지정합니다.

## Just Do It!

불편한 부분이나 개선할 점이 있다면 언제든지 알려주세요.

그럼... `Happy Hacking!` 🚀

![computer-cat](https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/ee6a1f11-5f2e-445a-800c-807be10a8314)
