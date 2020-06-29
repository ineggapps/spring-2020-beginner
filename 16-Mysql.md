# Mysql

오라클은 하나의 데이터베이스를 여러 사용자가 사용하는 것이라면, Mysql은 사용자별로 데이터베이스를 하나씩 가져 사용하는 식으로 사용.

1. mysql~.zip파일 압축 풀고 c:\mysql에 압축 풀기
2. c:\mysql\bin 폴더 있는지 확인
3. my.ini 파일을 c:\mysql 이하에 삽입
   - 실습자료에서 mysql>설치>환경설정파일>my.ini 파일을 그대로 복사하여 붙여넣기 하면 됨.
4. c:\mysql\data 폴더 생성
   - 이곳에는 실질적인 데이터가 저장되는 경로이다.
   - default-character-set=utf8 로 인코딩 설정 등을 지정
5. path 등록
   - 내 컴퓨터 마우스 우클릭 > 속성
   - 왼쪽 탭에서 고급 시스템 설정 클릭
   - 환경 변수에서 시스템 변수 항목(아래쪽 하얀 칸)에서 변수는 Path 항목을 선택하고 편집 버튼 클릭
   - 새로운 팝업이 뜨면 새로 만들기 버튼 클릭
   - 따옴표 안의 값 입력 "C:\mysql\bin" 등록 후 확인을 눌러 빠져나온다.
6. 윈도 서비스 등록 (단, 관리자 권한으로 실행해야 한다.)
   - 시작버튼 우클릭 > Windows PowerShell (관리자)(A) 항목 선택
   - mysqld.exe --initialize 입력 후 엔터 (초기화작업 시 시간이 걸린다. 완료 시 아무런 반응이 없을 것)
   - c:\mysql\data 폴더 이하에 많은 폴더와 파일이 생긴다. (혹시 .err 확장자가 만들어졌다면 오류 발생한 것이니 data폴더를 모두 비우고 다시 명령어 실행)
   - 윈도 서비스 등록
     - c:\mysql\bin\mysqld.exe --install 명령어 입력
     - 성공 시 Service successfully installed.가 뜬다.
7. root 패스워드 변경
   - c:\mysql\data\컴퓨터이름.err (DESKTOP-~~~로 시작할 듯..)
   - 이 파일을 열어 보면 4번째 줄에 ~ password is generated for root@localhost: 패스워드 라고 명시돼 있다. (복사해 두기)
   - cmd창에서 mysql -u root -p 엔터 치고 복사 해 둔 비밀번호를 붙여넣는다. (마우스 우클릭하면 됨)
   - mysql> 이라고 뜨면 로그인이 성공한 것임!
   - 로그인 성공하면 set password = 'java\$!'; 입력하여 비밀번호 변경
8. 환경 확인 및 DB 작성하기
   - mysql> status; 입력하기
   - characterset이 utf8로 설정되어 있는지 확인. (utf8이면 정상적으로 완료된 것임!)
   - show databases; 입력
   - db 만들기
9. 동봉된 zip파일에서 mysql workbench 설치
   - 설치되지 않으면 동봉된 vs2013, vs2015 패키지 설치
10. mysql workbench 프로그램이 설치되면 메뉴에서 다음의 항목 수행
    - edit > preferences 클릭
      - 왼쪽 탭에서 SQL Editor 클릭
      - 우측에서 스크롤 아래로 내려서 Safe Updates (rejects UPDATEs and DELETEs with no restrictions) 체크 해제
        - 해제해야 쿼리가 실행될 것이다.
      - Modeling > Appearance > Fonts 항목에서 Configure Fonts For: Korean 으로 선택
11. Database > Connect to Database 선택
    - Stored Connection: Local instance MySQL 선택
    - Password 항목에서 Store in vault ... 클릭 후 비밀번호 입력한 뒤 OK버튼 클릭
    - OK를 누르고 빠져나온다.

```sql
CREATE DATABASE mydb; -- DB만들기
show databases; -- 입력 후 만든 mydb 데이터베이스가 출력되면 정상적으로 생성된 것임!
```

======
실습용 PC 외부에서 접속 가능하게 설정하기

```sql
SHOW GRANTS FOR 'root'@'localhost';
CREATE USER 'root'@'%' IDENTIFIED BY '비밀번호 입력';
GRANT ALTER, SHOW VIEW, SHOW DATABASES, SELECT, PROCESS, EXECUTE  ON *.* TO 'root'@'%';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'root'@'%';
```

======
게시판 테이블

- varchar은 255자까지만 가능하다.
- text는 기본적으로 최대 65535 byte. utf8 기준(3바이트 문자)으로 21844 글자 저장가능
- DATETIME형에 현재 시간을 넣기 위해서는 CURRENT_TIMESTAMP를 이용

```sql
CREATE TABLE bbs(
    num INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    pwd VARCHAR(50) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    ipAddr VARCHAR(50) NOT NULL,
    created DATETIME DEFAULT CURRENT_TIMESTAMP,
    hitCount INT DEFAULT 0,
    PRIMARY KEY(num)
);
```
