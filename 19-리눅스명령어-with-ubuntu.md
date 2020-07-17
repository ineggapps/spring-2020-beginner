# 리눅스

## 명령어

### 변수명

export HELLO="hello hello"
echo \$HELLO

### 폴더 만들기

mkdir -p ~/test/user/demo
ls -R test

mkdir test1 test2

mkdir user{1,2,5,7}
=> user1, user2, user5, user7 폴더 생성

mkdir user{B..F}
mkdir user{0005..8}

ll | grep user0

### 파일 만들기

touch test1.txt
rm test1.txt

### 디렉터리 지우기

rmdir 디렉터리명 (비어 있어야 함)
rm -r 디렉터리명

### 파일명에 하이픈이 있는 경우

rm -test.txt 는 옵션으로 인식한다.
rm ./-test.txt 명령어를 이용하여 파일을 삭제한다.

## 환경변수 설정

### JAVA 경로 조회

echo \$JAVA_HOME

### JAVA 버전 조회

javac -version

### JAVA 위치 조회 (심벌릭 링크)

which javac

### JAVA 위치 조회 (진짜 위치 확인)

readlink -f /usr/bin/javac

### JAVA 환경설정

gedit /etc/profile 입력 후 다음의 내용 맨 뒤에 삽입

```
export JAVA_HOME=/usrlib/jvm/jdk1.8.0_211
export PATH=$PATH:$JAVA_HOME/bin
```

source /etc/profile 명령어를 이용하여 적용
echo \$JAVA_HOME 확인

톰캣 설치 후 다음의 설정도 돼 있어야 함.

```
export CATALINA_HOME=/usr/local/tomcat8 #(단, 톰캣이 이곳에 있어야 함)
export  CLASSPATH=.:$JAVA_HOME/jre/lib/ext:$JAVA_HOME/lib/tools.jar:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar
export PATH=$PATH:$CATALINA_HOME/bin
```

### 톰캣 실행 권한 주기

cd /usr/local/tomcat8
sudo chgrp -R sky conf 파일의 사용자 그룹 변경
sudo chmod g+rwx conf 파일 및 디렉터리 권한 변경
sudo chmod g+r conf

sudo chown -R sky webapps/ work/ temp/ logs/

## vi

i: 끼워넣기(커서 위치에서 입력)
I: 끼워넣기 (커서 위치 행의 가장 앞에서 입력)
a: 끼워넣기 (커서 위치 다음 칸부터)
A: 끼워넣기 (커서 위치 행의 가장 마지막부터)
o: 커서가 있는 아래에 빈 줄 삽입(커서 다음 행부터 입력)
R: 덮어쓰기

입력모드 -> 명령모드
ESC

:wq 저장하고 종료
:q! 저장하지 않고 종료
:q 종료

h: 커서를 왼쪽으로 이동
l: 커서 오른쪽
j: 커서 아래쪽
k: 커서 위쪽

^: 커서를 현재 행 처음으로
\$: 커서를 현재 행 마지막으로

gg또는 1G: 커서를 문서의 가장 처음으로
G: 커서를 가장 마지막 행으로
:2 2행으로

----지우기

x: 커서 위치 한 글자 삭제
X: 커서 위치 앞 문자 삭제
dd: 커서가 있는 한 줄 지우기
dw: 커서 위치 한 단어 지우기(스페이스 삭제)
diw: 커서 위치 한 단어 지우기(뒤 스페이스 삭제 안 됨)
db: 커서 위치 앞 단어 삭제
u: 바로 전 명령 취소
D: 커서 위치부터 그 줄 끝까지 삭제
3dd: 커서 위치부터 3줄 삭제
