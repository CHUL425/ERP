### 젠킨스 테스트2

테스트 수정2입니다.

### 로컬 호스트 설정

로컬 환경에서 로그인시 쿠키를 저장하기위해 도메인 변경이 필요하며 다음 방법을 추천합니다.
(서버의 메인도메인과 Local Domain을 일치시킴)

C:\Windows\System32\drivers\etc\hosts 에 아래 Custom 도메인을 추가
127.0.0.1 local.miraeassetsecurities.com

### 배포

[github.io](https://kimminje0ng.github.io)

### Set

-   git clone

```
$ git clone https://github.com/HeeraWoo/mi-support-front.git
```

-   branch clone

```
$ git clone -b {branch_name} --single-branch {repo_url}
```

-   install node_modules

```
$ cd mi-support-front
$ npm install
```

### Run

```
$ npm run dev
```

### Mock Server Set

-   run server

```
$ cd mi-support-back
$ npm install
$ SET DEBUG=mi-support-back:* & npm start
```

[참고] src/components/template/DatagridCpnt4.vue
