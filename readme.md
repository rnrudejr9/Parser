# LineParser

* IDE : intellij
* Language : java
* Database : mysql(jdbc driver gradle)
* Server : aws
* 프로그램
    * csv파일을 읽어 필요한 부분을 추출
    * 추출한 내용을 객체에 저장
    * 객체 내용을 DB에 연동해서 Insert
    * DB연동해서 작업 추가 
    * 테스트 코드 활용
    
![image](https://user-images.githubusercontent.com/49141751/209630586-be6fa917-368e-45c0-9a3b-d0713e9ace80.png)


![header](https://capsule-render.vercel.app/api?type=waving&color=gradient&height=300&section=header&text=오늘부터%20운동메💪&fontSize=70)

# 오늘부터 운동메💪
* **운동은 선택이 아닌 필수! 혼자가 아닌 다같이 하자~**
* **사용자에게 쉽고 간단한 운동메이트를 찾을 수 있게 하는 서비스 제공**
* **새로운 지역에서도 운동으로 이웃들과 친해지고 생활체육 활성화 기대**
* **멋쟁이사자처럼 백엔드스쿨 2기 팀프로젝트**

##### <div align = "center"> "위치 기반으로 동네 운동 메이트를 찾아 함께 스포츠를 즐기는 서비스" </div>
##### <div align = "center"> <a href="naver.com">오늘부터 운동메</a> </div>


> * 노션페이지 : <a href="https://www.notion.so/b8ea6992ef3b4cc4896edf2079378234">팀 노션페이지</a>
> * 요구사항 명세서 : <a href="https://www.notion.so/b8ea6992ef3b4cc4896edf2079378234">요구사항 명세서</a>
> * WBS 시트 : <a href="https://docs.google.com/spreadsheets/d/1NuQwSfQaIN8C239ZupzHOgX0bKoQoHQWYkoj8PyC1Ps/edit?usp=sharing">WBS 시트</a>
<br>


## 🏋️‍♀️ 개발 환경

* **에디터** : Intellij Ultimate
* **개발 툴** : SpringBoot 2.7.7
* **자바** : JAVA 11
* **빌드** : Gradle
* **서버** : AWS EC2, AWS RDS, AWS S3
* **CI/CD** : Docker, gitlab
* **데이터베이스** : MySql, Redis
* **필수 라이브러리** : Spring Data JPA, Lombok, Spring Security, thymeleaf, JWT, WebSocket, OAuth2.0, Email


<br>

## 🤾‍ 프로젝트 시연 영상

<br>

## 🏄‍♂️ 구현 기능

#### USER 
- [x] 로그인
   * 입력한 ID, PW 를 통해 로그인
   * 로그인 성공 시 JWT 토큰 cookie 로 저장해서 클라이언트 저장
- [ ] 회원가입
   * Email 인증 / ID 중복체크 / PW 검사 / 
- [ ] Oauth 로그인
   * 
- [ ] ID/PW 찾기
   * 

#### CREW
- [ ] 크루 CRUD
   * 소개 사진 등록
   * SOFTDELETE
   * 크루 작성 시 채팅방 생성 
- [ ] 크루 댓글/대댓글
- [ ] 크루 좋아요
   
- [ ] 크루 참여
- [ ] 크루 참여 승인/거절
- [ ] 참여자 명단 조회

#### REVIEW
- [ ] 크루 종료 시 후기 작성
- [ ] 온도지수 체크
- [ ] 후기 조회

#### ALARM
- [ ] 알림 기능
   * 

#### MATCHING
- [ ] 실시간 매칭기능

#### CHAT
- [ ] 실시간 채팅
- [ ] 접속자 확인
- [ ] 채팅 내역 조회
- [ ] 읽음 처리

#### FOLLOW
- [ ] USER 팔로우
- [ ] 팔로우 목록 조회

#### MYPROFILE
- [ ] 마이프로필 조회
- [ ] 개인사진 등록
- [ ] 참여중인 크루 조회
- [ ] 


<br>

## 🏌️‍♂️ 테이블 활용한 예시


|API 종류|HTTP|URI|API 설명|
|:-----:|:------------------:|:-----------------------------:|:-----------------------------:|
| `hello` | GET | /api/v1/hello | testAPI return String |


<br>

## 🚴‍♀️ 시스템 아키텍쳐
![image](https://user-images.githubusercontent.com/49141751/218945679-0d0e1bb6-0655-4313-80e5-9e264bafa0c7.png)

<br>

## 🤸‍♀️ ERD


