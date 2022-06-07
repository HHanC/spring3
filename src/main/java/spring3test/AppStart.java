package spring3test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트 초기 셋팅 : 1.내장 톰캣 세팅 2. mvc셋팅 3. Restful 셋팅
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}


/*
*   프로젝트 폴더
*   src
*       main
*           1. java[백엔드 파일]
*               2. 최상위 패키지[웹페이지명]
*                   3. controller 패키지
*                   3. service 패키지
*                   3. domain 패키지
*                   3. 스프링 실행 클래스[*]
*           1. resources [프론트엔드/ 설정파일]
*               2. static
*                   3. js
*                   3. css
*                   3. img
*               2. templates[html파일]
*               2. application.propertice[웹 설정 파일]
*
* */


/*

    설계 디자인 모델
    MVC2[JPA]
        * 안정성 보장 [VIEW -> CONTROLLER // CONTROLLER -> SERVICE : PARAM, DTO , VO(수정불가)]
           // DTO : 데이터 이동 객체 [(읽기 / 수정 모드) CONTROLLER -> SERVICE]
           // VO : 데이터 이동 객체 (읽기모드)
           // ENTITY : DB테이블과 매핑된 객체 (SERVICE 에서만 사용 권장)
*   VIEW ------------------AJAX DTO------------->CONTROLLER-------DTO-------->SERVICE------JPA(또는 dao)------------->DB
*   화면                                      제어(VIEW<--->SERVICE)             로직        ENTITY-->매핑-->TABLE
*                                                                                          entity 조작 : JPARepository
*   -통신방식 : AJAX
*   -URL : create                           @[METHOD]Mopping(URL)
*   -METHOD : GET
*                                           SERVICE 호출                  기능구현 로직
*   JDBC : JAVA DATEABASE CONNECTION 종류
*       // 1. DAO[JAVAFX.JSP]
*       // 2. JPA [SPRING]
*
*       * JPA : 매핑[연결]
*       // 목정 : SQL 최소화 [자바 개발자가 SQL 반복작성 회피]
*       // 매핑 : ENTITY(클래스) ----------- DB(테이블)
*
*       @RequestParam("요청 변수명")자료형 변수명 <------------> reauest.getpar
*       1. 변수 요청 어노테이션
        2. 자동 형변환
*
* */