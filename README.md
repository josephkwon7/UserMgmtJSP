이 과정은 Servlet/JSP로 사용자 관리 시스템을 구현하면서 자바 웹 애플리케이션 개발자가 반드시 알아야할 빌드 도구, logging 라이브러리, validation, 리팩토링 등에 대해 다룬다.

> 이 저장소 코드를 구현하는 전체 과정은 https://goo.gl/86ai5a 에서 볼 수 있다.

> 이 저장소의 소스 코드를 활용하는 방법은 https://youtu.be/IgT_Zq16Mfg 동영상에서 참고할 수 있다.

# 개발 환경 세팅 및 Servlet 기본
### [자바 웹 개발 환경 세팅](https://youtu.be/DNGp6Q9vLwk) 동영상
* JDK 설치
* Eclipse JEE Developers 버전 설치

### [Embedded Tomcat 버전 설치 및 설정](https://youtu.be/jWVlAclnIXo) 동영상
* 웹 애플리케이션을 개발한 후 배포하려면 서버가 필요하다. 이 서버 중의 하나가 tomcat이다. tomcat은 오픈 소스이고, 무료이기 때문에 자바 기반으로 웹 애플리케이션을 개발할 때 많이 사용한다.
* eclipse에서 tomcat 서버를 세팅하고 실행하는 과정을 다룬다.

### [Servlet으로 Hello World 출력하기](https://youtu.be/xCXw8xmmWC4) 동영상
* Servlet은 동적인 웹 페이지를 구현하기 위한 기술 중의 하나이다. 사용자 요청에 "Hello World!"를 응답으로 보내주는 Servlet을 추가하고 실행하는 과정을 다룬다.

### [eclipse relaunch 플러그인 설치](https://youtu.be/OdCR6Y4_HAQ) 동영상
* eclipse에서 tomcat 서버로 개발할 때 java 소스 코드가 변경되면 서버를 재시작해야 한다. 그런데 서버를 재시작하는 것이 은근히 불편한 과정이다. 이 불편한 과정을 해소하는 방법 중 하나가 relaunch 플러그인을 활용하는 방법이다.

### [Client to Server, Server to Client로 데이터 전달](https://youtu.be/RmOD3UZ3VkM) 동영상
* Client와 Server 사이에 데이터를 전달할 필요가 있다. Client에서 HTTP Get 방식으로 데이터를 전달하고, Client에서 전달한 데이터를 Server에서 받아 처리한 후 이 데이터를 활용해 Client에 응답으로 보낼 메시지를 생성하는 과정을 다룬다.

### [Servlet Container와 Servlet 관계](https://youtu.be/aP4Lw3SfffQ) 동영상
* Servlet은 자바 진영에서 동적인 웹 페이지를 개발하기 위한 기술 중의 하나이다. Servlet Container는 Servlet 인스턴스를 생성하고, Servlet을 실행하는 역할을 한다. 오픈 소스 이면서 가장 많이 사용하는 Servlet Container 중의 하나가 Tomcat이다.

# 회원가입 페이지 분석 및 JSP
최신 개발 환경으로 실습할 수 있도록 지원하기 위해 개발 환경 세팅과 소스 코드가 지금까지 진행한 코드 다르다. 이후의 동영상은 찍은 시점이 다르다. 따라서 동영상에 약간의 차이가 있을 수 있다. 하지만 기본적인 사용방법은 같다. 특히 소스 코드가 상당히 많은 분량이 추가될 수 있고, 디렉토리 구조가 다를 수 있다. 이 부분은 https://youtu.be/IgT_Zq16Mfg 동영상을 참고해 세팅한다.

### [회원가입 페이지 요구사항 분석](https://youtu.be/d6k-WJpS2d4) 동영상
* jsp & servlet 학습을 위해 앞으로 개발할 애플리케이션 요구사항 분석
* 메인 페이지와 회원 가입 페이지 jsp 공유
* web.xml의 welcome-file-list 설명

### [Servlet에서 JSP로 전환](https://youtu.be/JE2hNFniPJU) 동영상
* Servlet의 문제점 인식 및 JSP 등장 이유 
* JSP와 Servlet의 관계 
* JSP에서 자바 코드 사용

### [JSP include, get/post](https://youtu.be/KGl70HWfw6w) 동영상
* JSP 중복을 include 구문을 활용해 제거 
* get/post method 차이점 설명 
* 클라이언트에서 서버로 데이터 전달 및 데이터 추출

### [데이터 저장](https://youtu.be/7Zyp79is_jY) 동영상
* 회원가입 데이터 저장을 위한 Database 객체 생성 
* 사용자 데이터 저장을 위한 User 객체 생성 
* sendRedirect를 활용한 페이지 이동

# 회원가입 기능 구현 및 JSP2
### [단위 테스트 기반 개발](https://youtu.be/P3cYfVMdFHY) 동영상 
* 단위 테스트를 활용하지 않을 때의 개발/테스트 과정 설명 
* test source folder 추가 
* Database와 User 객체에 대한 단위 테스트 코드 추가 
* 로그인 기능에 대한 단위 테스트 추가 

### [세션(session)을 활용한 로그인 기능 구현](https://youtu.be/hQulJST8C2c) 동영상
* 정상적인 로그인 기능 구현 
* 로그인 성공 후 session에 정보 저장 
* 로그 아웃 기능 구현

### [예외 처리 및 forward](https://youtu.be/ANhfLsFAmas) 동영상
* jsp에 예외 처리하는 흐름 이해 
* RequestDispatcher.forward()를 활용한 jsp 이동

### [JSP 문제점 및 MVC 기본](https://youtu.be/EfsVt7-ol_I) 동영상 
* JSP만으로 구현했을 때의 이슈 공유 
* 이 문제를 해결하기 위한 역할 분리로 MVC 등장 
* JSP와 Servlet을 병행해서 구현

### [redirect와 forward의 차이](https://youtu.be/PxvrcpZJwGs) 동영상 
* redirect와 foward 방식의 차이 
* 개발할 때 고려할 사항

### [JSTL와 EL(expression language)](https://youtu.be/Sk9-mfKpvtQ) 동영상
* jstl 라이브러리 다운로드 및 프로젝트에 추가 
* jstl 활용해 if/else 구현 
* expression language 활용해 스크립틀릿 코드 제거

# 데이터베이스 연동
### [JDBC 설치 및 학습](https://youtu.be/uI97GlQKcg0) 동영상 
* 데이터베이스가 하는 역할
* 데이터베이스에 데이터베이스와 테이블 생성
* JDBC 드라이버 설치
* 사용자 데이터 추가(insert) 
* Junit 단위 테스트를 통한 JDBC 학습

### [DB에서 데이터 조회](https://youtu.be/ljoePTUVFJU) 동영상 
* 데이터 조회 기능 추가(select) 
* Database를 사용하던 코드가 UserDAO를 사용하도록 구현함.

### [DB 테스트](https://youtu.be/aDUdROOSznE) 동영상 
* 사용하지 않는 Database 클래스 제거 
* 반복 테스트가 가능하도록 사용자 제거 기능 추가 
* DB 반복 테스트가 가능하도록 구현함

# 회원가입 기능 구현 지속 및 코드 리팩토링
### [개인 정보 수정 폼 개발](https://youtu.be/souamHDBev8) 동영상 
JSP에서 자바 빈 데이터를 가져올 때 규칙이 있다. 이 규칙을 이해하고 사용해야 한다. 소스 코드를 통해 MVC 각각의 역할을 이해하는 것은 MVC 패턴을 이해하는데 많은 도움이 된다. 최근의 거의 모든 웹 프레임워크가 MVC 패턴을 기반으로 하고 있기 때문에 MVC 패턴에 대해서는 반드시 이해하고 넘어가자.
* JSP에서 자바 코드(스크립틀릿)을 사용하지 않도록 구현하는 방법 
* hidden input type 사용 
* 자바빈 규약에 따라 자바 객체에서 데이터 추출 
* 소스 코드를 통해 MVC 각각의 역할을 설명

### [개인 정보 수정 개발 완료](https://youtu.be/jC_i7OAtLfk) 동영상 
* 개인 정보 수정을 위한 DAO 개발 완료

### [JDBC 리소스 반환](https://youtu.be/ideyEk8kZNQ) 동영상 
JDBC를 활용해 프로그래밍을 하는 경우 Connection, PreparedStatement, ResultSet 자원을 사용한 후 반드시 반환해야 한다. 반환은 각 인스턴스의 close() 를 사용해 가능하다. 자바 기반 웹 애플리케이션을 개발할 때 웹 서버가 다운되는 원인의 가장 큰 부분이 DB와의 Connection 자원을 close()하지 않아서 발생했다. 지금은 많이 개선된 상태이다.
* JDBC의 Connection, PreparedStatement, ResultSet의 자원을 반화하도록 리팩토링

### [회원가입 화면과 개인정보 수정 화면의 중복 제거](https://youtu.be/k7Rh60ieaSI) 동영상 
회원가입과 개인정보 수정 화면을 담당하는 jsp를 보면 많은 중복이 발생한다. 일반적으로 데이터를 생성하고 수정하는 화면은 많은 중복이 발생하기 때문에 jsp 하나로 생성과 수정 화면을 모두 담당하도록 구현해 중복을 제거한다. 중복은 어느 곳에서나 해악이므로 jsp에서 최대한 중복 코드를 만들지 않도록 해야한다.
* 회원 가입을 위한 Servlet 추가 
* form.jsp와 update_form.jsp 중복 제거해 하나의 파일로 통일 
* c:set 태그 사용

### [개인정보 수정에 대한 보안 처리](https://youtu.be/kO06A7nWhS4) 동영상 
개인 정보 수정, 게시글 삭제와 같은 기능을 개발할 때는 보안에 특히 주의해야 한다. 서버측 프로그래밍은 보안적으로 문제가 발생할 경우 관리하고 있는 모든 데이터에 접근할 수 있기 때문에 보안적으로 문제가 없는지 고려해야 개발해야 한다. 기본적인 기능이 정상적으로 동작하도록 구현하는 것도 중요하지만 안전한 소프트웨어가 되도록 구현하는데도 많은 시간과 노력을 투자해야 한다.
* UpdateUserServlet에서 로그인 사용자만 접근하도록 처리 
* 자신의 계정 정보만 수정할 수 있도록 보안 처리 
* 중복 코드에 대한 리팩토링 작업

### [gson 라이브러리를 활용한 api 개발](https://youtu.be/1yhYpcWMbIk) 동영상 
json 또는 xml 데이터 표준으로 개발하는 웹 애플리케이션이 점차 많아지고 있다. 모바일의 등장과 ajax를 기반으로 한 single page appliction 개발이 주요 흐름으로 자리 잡으면서 좋은 api를 개발하는 것에 대한 관심도는 높아지고 있다. api를 개발하기 위해 자바 객체를 json으로, json을 자바 객체로 변환하는 작업이 많이 필요하다. 자바 진영 라이브러리 중에 gson 또는 jackson이 많이 사용된다.
* gson 라이브러리 추가 
* gson 라이브러리를 활용해 json 데이터로 변환 
* json에 대한 content type 설정

### [리팩토링 이슈 찾기, 등록, 관리](https://youtu.be/Umn45aYUukM) 동영상 
팀으로 협업을 하려면 현재 진행되고 있는 작업 목록을 관리해야 한다. 소프트웨어 개발에서 각 작업을 이슈라고 하며, 이슈 목록을 관리하기 위한 도구 중의 하나가 이슈 관리 시스템이다. github은 이슈 관리 시스템 중에서도 정말 필요한 기능만을 가지고 있는 가벼운 도구 중의 하나이다. 프로젝트 진행에 있어 무엇인가 시간을 투자할 필요가 있는 모든 작업은 이슈 관리 시스템에 관리하고, 목표를 정하고, 일정 관리 등을 해야 효율적인 프로젝트 진행이 가능하다. 이슈만 잘 관리하고 현재 상태를 지속적으로 업데이트만 잘 하더라도 프로젝트의 성공 가능성은 높아진다.
* 리팩토링할 요소들 찾기 
* github에 이슈 등록 
* 마일스톤 관리 및 이슈 관리

# validator 적용 및 maven 빌드 도구
### [validator 라이브러리 설치, 적용, 테스트](https://youtu.be/ZnbbqH5SOvM) 동영상  
데이터 관리 측면에서 사용자가 입력한 데이터가 유효한(valid) 데이터인지를 판단하는 것은 정말 중요하다. 유효하지 않은 데이터가 DB에 추가될 경우 예외 상황이 발생하기 때문에 로직 구현이 힘들어 지고 소스 코드 또한 복잡해 진다. 특히 서버측에서는 데이터에 대한 유효성을 철저하게 검증해야 한다. 하지만 이 작업이 상당히 귀찮은 작업이고, 중복 코드가 많으며, 코드량도 많아진다. 따라서 이 같은 기능을 지원하는 라이브러리가 있는지 찾아서 적용해 보고, 없을 경우 자체적으로 만들어 보는 것도 좋겠다. 자바 진영에서는 유효성을 체크하기 위한 validation api 표준이 있으며, 이 표준 구현체 중에 hibernate validation을 가장 많이 사용하고 있다.
* 외부 라이브러리를 찾아 적용하는 과정 
* java validator 라이브러리 적용 
* 단위 테스트를 활용해 java validator 학습

### [회원가입 기능에 validator 적용](https://youtu.be/JMQIaYIp5-g) 동영상  
* 회원가입 Servlet에 validator 적용

### [빌드 도구 설명, 메이븐 프로젝트 생성, 의존성 관리](https://youtu.be/Eg1Ebl_KNFg) 동영상  
* ant/maven/gradle 빌드 도구에 대한 초간단 설명 
* eclipse에서 메이븐 디렉토리 구조의 프로젝트 생성 
* junit 의존성 추가 * 메이븐 의존성 전이 설명

### [부모 pom, 기본 디렉토리 설정, 메이븐 기본 명령어](https://youtu.be/A8h1y-qXCbU) 동영상 
* effective pom 탭을 통해 메이븐 부모 pom 설명 
* 메이븐 기본 명령어인 compile/test/package 설명 
* eclipse에서 메이븐 명령어 실행

### [메이븐 phase, goal, 플러그인 설정 재정의](https://youtu.be/58yiJQU0xEY) 동영상 
* 메이븐의 phase와 goal 관계 설명 
* compiler 플러그인과 eclipse 플러그인 재정의 및 빌드 
* eclipse에서 효율적인 메이븐 goal 실행 방법

### [slipp 프로젝트에 메이븐 적용](https://youtu.be/ovpVzUaQtSM) 동영상 
지금까지 개발하고 있는 프로젝트의 디렉토리 구조를 변경하지 않으면서 메이븐을 적용할 수 있다. 메이븐을 적용할 경우 지금까지 github에 공유하던 많은 소스 코드를 공유하지 않아도 된다. 특히 eclipse 관련 설정과 jar 라이브러리를 공유하지 않아도 되는 것은 큰 장점이다.
* slipp 프로젝트에 메이븐 적용하는 과정 진행 
* github에서 jar 파일을 버전 관리하지 않도록 설정함.

# 자바 웹 애플리케이션 배포 및 logging
### [서블릿 컨테이너 및 Tomcat 디렉토리 구조 설명](https://youtu.be/WdBAto3IQOg) 동영상 
Embedded Tomcat을 사용하다보면 Tomcat 구조에 대해 익힐 기회가 많지 않다. 그냥 사용하면 되니까. 하지만 개발 서버, 실 서버로 넘어가면 이야기가 달라진다. 이 시점부터는 Tomcat 서버에 직접 접속해 시작하고 디버깅 로그 파악해야 하기 때문에 Tomcat에 대한 기본적인 이해는 하고 있어야 한다.
* 서블릿 컨테이너 설명 
* 터미널에서 Tomcat 시작, 종료 
* Tomcat 디렉토리 구조 설명 
* tail 명령어를 활용한 로그 확인

### [war 파일 빌드, 설정, Tomcat 서버 배포](https://youtu.be/K84mSiC_q6I) 동영상  
war는 web archive를 줄인 말이다. 웹 애플리케이션은 war 파일로 만들어 배포할 수 있다. war 파일은 메이븐 빌드 도구의 package 명령을 실행해 가능하다. 배포 형태를 디렉토리를 통째로 복사하거나 war 파일로 배포하는 두가지 형태가 있다. 환경에 따라 두 가지 방법 중 하나를 사용하면 된다.
* war 파일 생성을 위한 설정 
* war 파일 생성 
* war 파일을 Tomcat 서버에 배포

### [tomcat context 설정](https://youtu.be/MkMyNEaCDeY) 동영상  
Tomcat은 webapps 디렉토리에 웹 애플리케이션을 바로 배포할 수 있다. 또 다른 방법은 conf/server.xml 설정을 추가해 임의의 디렉토리에 있는 웹 애플리케이션을 배포하는 것이 가능하다. 현장에서는 server.xml의 설정을 변경해 배포하는 방법을 많이 사용한다.
* 메이븐 finalName 설정 
* server.xml에서 tomcat context 설정 
* 개발 서버에서 웹 애플리케이션 배포시 디렉토리 구조

### [개발 서버에 소스 코드 배포 과정에 대한 자동화](https://youtu.be/X6UgSdjvrBU) 동영상  
소스 코드를 빌드/배포하는 과정에서 수 많은 반복 작업이 발생한다. 반복 작업은 사람의 실수를 유발하고 이는 대규모 장애로 이어진다. 따라서 반복 작업은 컴퓨터를 통해 자동화하는 것이 가장 안전하다. 그리고 개발자는 소중한 존재이므로 이런 하찮은 반복 작업에 시간을 쓰지 않도록 노력해야 한다. 틈틈히 shell script 만드는 연습을 하면 많은 반복 작업을 줄일 수 있다.
* 배포 과정에서 발생하는 반복 과정에 대한 설명 
* sh 파일을 이용해 배포 과정을 자동화

### [logging framework 개념 및 기본 설정](https://youtu.be/TcKEGh7KShI) 동영상  
System.out.println을 사용하는 것은 많은 문제점을 가지고 있기 때문에 현장에서는 사용하지 않는다. 현장에서는 logging framework를 사용한다. logging framework은 로그 메시지를 관리하기 위한 다양한 기능을 지원한다. logging framework은 개발자가 반드시 익혀야할 도구 중의 하나이니 이번 기획에 확실히 익혔으면 한다.
* logging framework이 필요한 이유 
* logback framework 설정

### [logging framework 추가 설정 및 eclipse 설정](https://youtu.be/040Y3MBNnyw) 동영상  
logging framework을 사용할 때 성능 측면에서 고려할 부분이 있다. 사용자가 많지 않은 경우에는 큰 문제 없지만 만약지면 이런 작은 차이가 크다. 시작부터 좋은 습관을 들여놓으면 좋겠다. 개발자가 항상 가져야 하는 습관은 단순, 반복적인 작업을 제거, 중복 코드를 제거하는 습관을 들여야 한다. eclipse와 같은 통합 개발 도구를 활용해 많은 작업을 효율화할 수 있다. 자신이 낭비라고 생각하는 작업이 있다면 해결 방법이 없는지 찾는 연습을 해보자.
* logging level 설명 
* 패키지별 logging framework 설정 
* debug 메시지 구현시 주의할 점 공유 
* logging을 위해 반복적으로 추가되는 설정을 eclipse template으로 해결 
* eclipse formatter 설정

> 아직 빌드가 무엇인지, 빌드 도구가 무엇이며, 왜 필요한 것인지 감이 잘 오지 않을 것이다. 빌드 도구의 필요성을 제대로 느껴보려면 개발 서버에 지금까지 만든 서비스를 배포해 보는 경험을 해야 한다. 그 전이라도 라이브러리 관리만으로도 많은 도움을 받을 것이다. 빌드 도구 중의 하나인 메이븐에 대해 다루고 있다. 이 동영상만으로 이해하는데 어려움이 있기 때문에 동영상에서 추천하는 자료와 같이 학습하면 좋겠다.

# DAO 리팩토링
> JDBC 기반으로 프로그래밍하다보면 정말 많은 중복이 발생한다. 이 중복을 어떻게 제거할 것인지에 대한 연습은 공통 라이브러리 코드를 어떻게 만드는 것이 좋을 것인지에 대한 학습을 하는데 큰 도움이 된다. JDBC 중복을 제거하는 과정을 보면 리팩토링을 어떻게 하는 것이 유연한 코드를 만들고, 깔끔한 코드를 만드는 것인지에 대한 경험을 할 수 있다. 이 과정에는 Template Method 패턴, Callback Interface등 디자인 패턴과 관련한 내용도 등장해야 한다. 디자인 패턴은 수 많은 선배 개발자들이 문제에 부딪혔을 때 좀 더 깔끔하고 유연한 코드를 만들기 위해 고민했던 흔적을 느껴볼 수 있다. 여력이 된다면 동영상을 본 후에 혼자 힘으로 리팩토링하는 연습을 해보면 좋겠다.

> 자바와 리팩토링에 익숙하지 않을 경우 과정이 다소 어려울 수 있다. 앞의 단계에서 학습을 마무리한 후 일정 경험을 쌓은 후 다시 도전하는 것도 한 가지 방법이다.

### [DAO 리팩토링 1 - insert, update, delete 중복 제거](https://youtu.be/ylrMBeakVnk) 동영상  
* DAO 중복 코드에 대한 이슈 제기 
* 라이브러리 코드와 개발자가 구현해야 하는 코드 분리 
* abstract 키워드를 활용해 추상 클래스 구현 
* 익명 클래스 사용 
* insert, update, delete 문에 대한 중복 제거

### [DAO 리팩토링 2 - select 문 중복 제거](https://youtu.be/zfXAZkqPH44) 동영상  
* select 쿼리에 대한 중복 코드 제거 
* getConnection 메서드 중복 제거 및 테스트 코드 수정 
* Template Method 패턴

### [DAO 리팩토링 3 - JdbcTemplate과 SelectJdbcTemplate 통합](https://youtu.be/yEHUB97B62I) 동영상  
* Template Method 패턴을 활용해 JdbcTemplate과 SelectJdbcTemplate 통합 
* Template Method 패턴을 활용할 때의 문제점 
* 각 Method를 interface로 분리해 JdbcTemplate과 SelectJdbcTemplate 통합

### [DAO 리팩토링 4 - 라이브러리 리팩토링 및 목록 기능 추가](https://youtu.be/nkepkHJi7e8) 동영상  
* 자바 Generic을 활용해 캐스팅을 하지 않도록 라이브러리 구현 
* 가변 인자를 활용해 개발자 편의성 개선 
* 여러 건의 데이터를 조회할 수 있는 기능 추가 
* 라이브러리 코드에서 중복을 제거하는 과정에 대한 설명

### [DAO 리팩토링 5 - SQLException을 DataAccessException으로 래핑](https://youtu.be/lFTyw7Uipyo) 동영상  
자바 언어가 등장하면서 장점 중의 하나가 Exception 클래스의 도입이었다. 그런데 Checked Exception이 남용되면서 소스 코드가 지저분해지는 경향이 생기면서 최근에는 Checked Exception의 사용을 최소화하자는 방향으로 흐름이 바뀌였다. 하지만 기존 API에는 수 많은 Checked Exception이 있다. 이 Checked Exception을 그대로 사용하는 것이 아니라 UnChecked Exception(Runtime Exception)으로 래핑해서 사용하는 것이 더 깔끔한 코드를 유지하는데 도움이 된다.
* Checked Exception과 Unchecked Exception 
* SQLException을 Unchecked Exception으로 변환 처리

### [DAO 리팩토링 6 - 람다 표현식을 사용하도록 리팩토링](https://youtu.be/0ax9jxfW9x4) 동영상  
자바 8에 추가된 람다 표현식은 자바 코드를 좀 더 깔끔하게 구현할 수 있도록 지원한다. 이미 수 많은 언어에서 지원하고 있는 람다 표현식이 늦게 추가된 경향이 있다. 람다 표현식은 함수형 프로그래밍에서 널리 사용되고 있는 것으로 익혀 놓으면 추후 다른 언어 기반으로 구현하는데도 도움이 될 것으로 생각한다.
* RowMapper에 FunctionalInterface 어노테이션 설정 
* RowMapper를 사용할 때 람다 표현식을 사용하도록 리팩토링
