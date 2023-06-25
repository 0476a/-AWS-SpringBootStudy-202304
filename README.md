# -AWS-SpringBootStudy-20230405

### [📖기술블로그](https://donotthinkjustdo.tistory.com/category/Web/%EC%82%B0%EB%8C%80%ED%8A%B9%28%EB%B0%B1%EC%97%94%EB%93%9C%29)

### 진행기간 2023.04.05 ~ 2023.04.14

___

#### 📅 2023.04.05

##### 1) 스프링
  - 엔터프라이즈용 Java 애플리케이션 개발을 편리하게 할 수 있게 해주는 오픈소스 경량급 애플리케이션 프레임워크

##### 2) 스프링 구조
  - [📖스프링 구조](https://donotthinkjustdo.tistory.com/entry/Stage4-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%84%A4%EC%B9%98-%EC%9A%94%EC%B2%AD%EC%9D%91%EB%8B%B520230405#2.-%EC%8A%A4%ED%94%84%EB%A7%81%EC%9D%84-%ED%91%9C%ED%98%84%ED%95%98%EB%8A%94-%EA%B5%AC%EC%A1%B0)

##### 3) MVC
  - MVC는 Model, View, Controller의 약자로 하나의 애플리케이션
  - 사용자가 Controller를 조작하면 Controller는 Model을 통해 데이터를 가져오고 그 데이터를 바탕으로 View를 통해 시작적 표현을 제어하여 사용자에게 전달함
  - [📖MVC 구조](https://donotthinkjustdo.tistory.com/entry/Stage4-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%84%A4%EC%B9%98-%EC%9A%94%EC%B2%AD%EC%9D%91%EB%8B%B520230405#1.-%EC%8A%A4%ED%94%84%EB%A7%81-mvc-%EA%B5%AC%EC%A1%B0-%EC%9D%B4%ED%95%B4)

___

#### 📅 2023.04.06

##### 1) GET요청, POST 요청
  - GET 요청: 값을 조회할 때 사용
  - POST 요청: 값을 추가할 때 사용

##### 2) GET요청
  - 쿼리 파람으로 GET 요청
  - 경로를 활용한 GET 요청

##### 3) POST요청
  - Form 형태로 POST 요청
  - raw 형태(JSON)로 POST 요청

##### 4) 타임리프
  - 뷰 템플릿이라고 부르고 컨트롤러가 전달하는 데이터를 이용하여 동적으로 화면을 구성할 수 있게 해줌.

##### 5) Rest API
  - http가 설계의 우수성에 비해 제대로 사용되어지지 못하는 모습이 안타까워 웹의 장점을 최대한 활용할 수 있는 아키텍처
  - 구성
    - 자원: URI
    - 행위: HTTP METHOD
    - 표현
  - 특징(해당 특징에 가깝게 작성한 것을 Rest API라고 함)
    - 유니폼 인터페이스
    - 무상태성
    - 캐시 기능
    - 자체 표현 구조
    - Client-Server 구조
    - 계층형 구조

##### 6) Rest API 디자인 가이드
  - 중심 규칙: URI는 정보의 자원을 표현함. (리소스명은 동사보다 명사를 사용)
  - HTTP METHOD의 알맞는 역할
    - POST: 생성
    - GET: 조회
    - PUT: 수정 -> 패치(PATCH)가 존재하는데 패치는 부분 수정할 때 사용
    - DELETE: 삭제
  - URI 설계 시 주의점
    - 슬래시 구분자(/)는 계층 관계를 나타냄
    - URI 마지막 문자로 슬래시(/)를 포함하지 않음
    - 하이픈(-)은 URI 가독성을 높이는데 사용
    - 밑줄(_)은 URI에 사용하지 않는다.
    - 소문자가 적합
    - 파일 확장자는 URI에 포함 X -> 파일 확장자는 Accept header를 사용

___

#### 📅 2023.04.07 ~ 2023.04.10

##### 1) DI
  - 스프링이 다른 프레임워크와 차별화되어 제공하는 의존 관계주입 기능
  - 객체를 직접 생성하는게 아니라 외부에서 생성한 후 주입 시켜주는 방식
  - DI(의존성 주입)를 통해서 모듈 간의 결합도가 낮아지고 유연성이 높아짐.

##### 2) IOC
  - 제어의 역전이라는 뜻
  - 메소드나 객체의 호출작업을 개발자가 결정하는 것이 아니라, 외부에서 결정하는 것
  - 제어의 흐름을 바꾼다는 뜻
  - 객체의 의존성을 역전시켜 객체 간의 결합도를 줄이고 유연한 코드를 작성할 수 있게함.
  - 가독성 및 코드 중복, 유지 보수를 편하게 할 수 있음
  - [IOC 구조](https://donotthinkjustdo.tistory.com/entry/Stage7-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9CIOCDI-MybatisDB%EC%97%B0%EA%B2%B0-lecture-%EB%B0%B1%EC%95%A4%EB%93%9C%EA%B5%AC%EC%A1%B0-20230407-0410#3.-ioc%EA%B5%AC%EC%A1%B0)

##### 3) Mybatis(DB 연결)
  - 객체 지향 언어인 자바의 관계형 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와주는 개발 프래임 워크
  - JDBC를 통해 데이터베이스에 엑세스하는 작업을 캡슐화하고 일반 SQL 쿼리, 저장 프로시저 및 고급 매핑을 지원하며 모든 JDBC 코드 및 매개 변수의 중복작업을 제거함.
  - Mybatis에서는 프로그램에 있는 SQL 쿼리들을 한 구성파일에 구성하여 프로그램 코드와 SQL을 분리할 수 있는 장점을 가짐.

##### 4) 백앤드 구조
  - config: 외부라이브러리들에 bean을 적용시켜주는 클래스
  - controller: 클라이언트로부터 온 요청들을 처리하고 응답해주는 역할을 함
  - service: 요청받은 데이터를 가공해주는 역할을 함
  - repository: 데이터 베이스와 통신하는 역할을 함

___

#### 📅 2023.04.11

##### 1) Lecture
  - [📖Lectrue 풀이 1](https://donotthinkjustdo.tistory.com/entry/Stage8-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%9D%B4%ED%81%B4%EB%A6%BD%EC%8A%A4-%EB%B2%84%EC%A0%84-%EB%B0%94%EA%BE%B8%EA%B8%B0-Lecture-get%EC%9A%94%EC%B2%AD-Lecturer-Student20230410)
  - [📖Lecture 풀이 2](https://donotthinkjustdo.tistory.com/entry/Stage9-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%97%94%ED%8B%B0%ED%8B%B0-%EB%B3%80%EC%88%98%EB%AA%85-%EB%B3%80%EA%B2%BD-Course-20230411)

___

#### 📅 2023.04.12

##### 1) AOP
  - 관점 지향 프로그래밍이라고 불림
  - 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화 하겠다는 것
  - [📖AOP 구조](https://donotthinkjustdo.tistory.com/entry/Stage10-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9CAOP-AOP-%ED%99%9C%EC%9A%A9-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%82%AC20230412#2.-aop%EA%B5%AC%EC%A1%B0)

##### 2) AOP 개념
  - Aspect: 흩어진 관심사를 모듈화 한것, 주로 부가기능을 모듈화함.
  - Target: Aspect를 적용하는 곳
  - Advice: 실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체
  - JoinPoint: Advice가 적용될 위치, 끼어들 수 잇는 지점, 메소드 진입 지점, 생성자 호출 지점, 필드에서 값을 꺼내올 때 등 다양한 시점에 적용가능
  - PointCut: JoinPoint의 상세한 스펙을 정의한 것. 'A'란 메소드의 진입 시점에 호출할 것과 같이 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있음

##### 3) AOP PointCut 표현식
  - execution: Advice를 적용할 메소드를 명시할 때 사용
  - within: 특정 타입에 속하는 메소드를 JoinPoint로 설정되도록 명시할 때 사용
  - Bean: 스프링 버전 2.5버전부터 지원하기 시작했으며, 스프링 빈을 이용하여 JoinPoint를 설정함.
  - execution 명시자
    - "*": 모든 값을 표현함
    - "..": 0개 이상을 의미함 -> 있을 수도 있고 없을 수도 있음

##### 4) 대표적인 AOP
  - TimeAOP: 요청과 응답에 걸린 시간을 체크
  - CheckNameAOP: AOP가 동작한 녀석의 메서드나 클래스의 이름을 출력해주는 AOP
  - ParamsAOP: 요청 받은 parameter 값을 출력
  - ReturnAOP: 리턴 값 출력

##### 5) 유효성 검사
  - 예외 관리하기
  - Vaildation 라이브러리 설치
  - Vaildation 체크
  - JAVA 정규식 사용
    - [📖 JAVA 정규식](https://donotthinkjustdo.tistory.com/entry/Stage10-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9CAOP-AOP-%ED%99%9C%EC%9A%A9-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%82%AC20230412#4.-java-%EC%A0%95%EA%B7%9C%EC%8B%9D)

___

#### 📅 2023.04.13 ~ 2023.04.14

##### 1) JWT 토큰
  - 토큰 기반 인증 시스템으로 클라이언트가 서버에 접속을 하면 서버에서 해당 클라이언트에게 인증되었다는 의미로 토큰을 부여함
  - 이 토큰은 유일하며 발급받은 클라이언트는 또 다시 서버에 요청을 보낼 때 요청 해더에 토큰을 심어 보냄.
    - 이걸 서버에서는 클라이언트로부터 받은 토큰을 서버에서 제공한 토큰과의 일치 여부를 체크하여 인증과정 처리

##### 2) JWT 라이브러리 설치
  - JJWT (API, Impl, Jackson) 라이브러리 설치 -> 버전 0.11.5
  - Spring Boot Starter Security 라이브러리 설치

##### 3) JWT 토큰 생성
  - [📖JWT 토큰 생성](https://donotthinkjustdo.tistory.com/entry/Stage11-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9CJWT%ED%86%A0%ED%81%B0-%EC%83%9D%EC%84%B1-JWT%ED%86%A0%ED%81%B0-%EC%9D%B8%EC%A6%9D20230413-0414#stage11-2.-jwt-%ED%86%A0%ED%81%B0-%EC%83%9D%EC%84%B1)

##### 4) JWT 토큰 인증
  - [📖JWT 토큰 인증](https://donotthinkjustdo.tistory.com/entry/Stage11-%EC%82%B0%EB%8C%80%ED%8A%B9-%EC%9B%B9%EA%B0%9C%EB%B0%9CJWT%ED%86%A0%ED%81%B0-%EC%83%9D%EC%84%B1-JWT%ED%86%A0%ED%81%B0-%EC%9D%B8%EC%A6%9D20230413-0414#stage11-3.-jwt-%ED%86%A0%ED%81%B0-%EC%9D%B8%EC%A6%9D)

