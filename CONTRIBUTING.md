# Contribution Guide Line

> 본 문서는 언제든 변경될 수 있습니다. Issue 를 생성해주시거나, Discord 를 통해 의견을 전달해주세요.

본 문서는 원활한 스터디를 진행하기 위해 가이드라인을 구성원들에게 제공하는 것을 목표로 작성되었습니다.

## Test 작성

이 스터디의 핵심 학습 목표이기도 한 [Kotest](https://kotest.io/) 는
다양한 [Testing Style](https://kotest.io/docs/framework/testing-styles.html) 을 지원합니다.

취향에 맞는 방식의 Spec 을 사용하시면서 어떤 Spec 이 어떤 상황에 어울리는지 고민해보시는 것도 좋습니다. 다만 **Annotation Spec 의 경우는 Java 의 JUnit5 와 거의 차이가 없기 때문에
Kotlin Style 을 학습하는 이 스터디의 목표와는 맞지 않다**고 생각되기 때문에 제외합니다.

## Pull Request

- PR 은 다음 팀원이 이어서 진행하기 쉽도록 가급적 본인이 생각하는 가장 작은 기능 단위로 생성해주세요
    - 중간에 구현이 막혔다면, 어떤걸 하려했고 어떤 부분이 막혔는지를 대략적으로 적어두고 PR 을 생성해주세요
    - 이것밖에 구현 못했는데 괜찮나? 라고 생각하지 않아도 괜찮습니다. 그냥 마음편히 던지세요! 코드의 절대적인 양은 이 스터디에서 중요하지 않습니다
    - 기능 구현이 아니라 Refactoring 이여도 괜찮습니다
- 원활한 리뷰 진행을 위해 항상 실행가능한 상태를 유지해주세요
- Kotest Spec 은 **AnnotationSpec 을 제외**한 나머지를 선호에 따라 자유롭게 사용합니다
- Ktlint 는 가급적 모두 통과시켜주세요
    - 다소 엄격하다고 생각될 수 있지만, Standard Rule 로 설정되어 있으므로 Kotlin 진영에서 권장하는 스타일은 무엇인지 살펴볼 수 있는 기회가 될거에요

### Size Labeling

PR 을 생성하면 코드의 변경 내용을 기반으로 size 라벨링이 진행됩니다.

<img width="924" alt="Pasted image 20230906205001" src="https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/304f520e-6c06-4bbd-82f0-aece04ca7a3a">

리뷰어는 라벨만 봐도 리뷰해야할 코드 양을 대략적으로 파악할 수 있습니다.

### Codecov

PR 을 생성하면 작성된 코드를 테스트한 뒤 커버리지 리포트를 생성합니다.

<img width="939" alt="Pasted image 20230906205436" src="https://github.com/Learning-Is-Vital-In-Development/23-17-pair-programming-game/assets/56438906/5ed8e928-297b-4d50-b5b1-0117a3cde625">

만약 이전보다 커버리지가 감소한다면 Pipeline 이 실패합니다. 클래스 별 70% 이상의 커버리지여야 빌드가 가능하니 테스트에 신경써주세요. 관련 설정은 [build.gradle.kts](build.gradle.kts) 에서 확인하실 수 있습니다.

```kotlin
tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "CLASS"
            limit {
                minimum = "0.70".toBigDecimal()
            }
        }
    }
}
```

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
