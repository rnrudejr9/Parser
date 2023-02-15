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
* **지역주민들과 함께 운동메가 되어보아요**
* **멋쟁이사자처럼 백엔드스쿨 2기 팀프로젝트**

##### <div align = "center"> "지역생활 주민 내용 들어가기" </div>


> * 팀프로젝트 주소 
<br>


## ✏ 개요 설명
<div align="center">
 <img src="https://img.shields.io/badge/SpringBoot-6DB33F.svg?logo=Spring-Boot&logoColor=white" />
 <img src="https://img.shields.io/badge/SpringSecurity-6DB33F.svg?logo=Spring-Security&logoColor=white" />
 <img src="https://img.shields.io/badge/MySQL-3776AB.svg?logo=MySql&logoColor=white" />
 <img src="https://img.shields.io/badge/Docker-2496ED.svg?logo=Docker&logoColor=white" />
 <img src="https://img.shields.io/badge/AmazonEC2-FF9900.svg?logo=Amazon-EC2&logoColor=white" />
</div>

* **에디터** : Intellij Ultimate
* **개발 툴** : SpringBoot 2.7.5
* **자바** : JAVA 11
* **빌드** : Gradle 6.8
* **서버** : AWS EC2
* **배포** : Docker, gitlab
* **데이터베이스** : MySql 8.0
* **필수 라이브러리** : SpringBoot Web, MySQL, Spring Data JPA, Lombok, Spring Security, thymeleaf


<br>

## 🎨 진행과정

- [x] gitlab 배포파일 및 ec2 크론탭 설정
- [x] swagger 문서화 설정
- [x] 회원가입과 로그인  
- [x] 게시글 CRUD 구현
- [x] 댓글 CRUD 구현
- [x] 좋아요 기능 구현
- [x] Controller 테스트(User,Post,Comment)
- [x] Service 테스트(User,Post,Comment)
- [x] 부가기능 테스트(알림, 좋아요, 권한) 작성 
<hr>

- [x] 마이피드 기능 구현
- [x] 알람 기능 구현
- [x] admin 권한 (Role 역할) 구현 및 ADMIN 권한 부여
- [x] soft delete 구현 (SQLDelete, where 활용)
- [X] 소스코드 리펙토링 (간결화, 효율성 참고) -> validateCode, Controller, Service 완료
<hr>

- [x] UI : 화면 설정 (타임리프 템플릿 사용)
- [x] UI : 게시글 CRUD 구현 (admin CRUD 가능)
- [x] UI : 댓글 CRUD 구현
- [x] UI : 좋아요 기능 구현
- [x] UI : 마이피드 기능 구현
- [x] UI : 알람 기능 구현
- [x] UI : admin 계정 user 데이터 관리(user <-> admin)
- [ ] UI : admin 계정 user 데이터 CRUD
- [ ] UI : 화면에러처리
- [ ] UI : react 적용
- [x] UI : 웹 소켓 사용 간단 채팅방 구현

> * 진행 간 발생했던 이슈 : https://gitlab.com/rnrudejr9/mustasns/-/issues/?sort=created_date&state=all&first_page_size=20

<br>

## 🎯 ENDPOINT


|API 종류|HTTP|URI|API 설명|
|:-----:|:------------------:|:-----------------------------:|:-----------------------------:|
| `hello` | GET | /api/v1/hello | testAPI return String |
| `users` | POST | /api/v1/users/join | 회원가입기능 |
| `users` | POST | /api/v1/users/login | 로그인기능 |
| `posts` | POST | /api/v1/posts | 글작성기능 |
| `posts` | PUT | /api/v1/posts/{id} | 글수정기능 |
| `posts` | DELETE | /api/v1/posts/{id} | 글삭제기능 |
| `posts` | GET | /api/v1/posts/{id} | 글조회기능 |
| `posts` | GET | /api/v1/posts | 글전체조회 |
| `comment` | POST | /api/v1/posts/{id}/comment | 댓글작성기능 |
| `comment` | PUT | /api/v1/posts/{postid}/comment/{id} | 댓글수정기능 |
| `comment` | DELETE | /api/v1/posts/{postid}/comment/{id} | 댓글삭제기능 |
| `comment` | GET | /api/v1/posts/{id}/comment | 댓글조회기능 |
| `good` | POST | /api/v1/posts/{id}/likes | 좋아요+취소기능 |
| `good` | GET | /api/v1/posts/{id}/likes | 좋아요조회기능 |
| `users` | POST | /api/v1/users/{id}/role/change | 사용자권한변경기능 |
| `my` | GET | /api/v1/posts/my | 마이피드조회기능 |
| `alarm` | GET | /api/v1/users/alarm | 알람조회기능 |
| `view` | GET | /view/v1/home | UI 메인화면 |
| `chat` | GET | /chat | UI 채팅방 |

<br>
