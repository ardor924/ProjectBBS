폴더트리 가이드라인

폴더 및 파일 네이밍 규칙 : 전반적으로 모든 jsp파일과 views/ 내의 폴더는 스네이크 타입을 사용함.


------------폴더구성도-------------
views/
├─ admin/ : 관리자관련 파일
│   ├─ category_manage/  : 카테고리 관련 파일
│   │   ├─ category_reg.jsp
│   │   ├─ category_reg_code.jsp
│   │   ├─ category_manage.jsp
│   │   └─ category_manage_code.jsp
│   ├─ bbs_manage/ : 게시판관리 파일
│   │   ├─ bbs_manage.jsp
│   │   └─ bbs_manage_code.jsp
│   └─ member_manage/ 회원정보 관리 파일
│       ├─ member_manage.jsp
│       └─ member_manage_code.jsp
│   
├─ bbs/ : 게시판 및 게시글 관련 폴더와 파일의 최상위 폴더
│   ├─ board/ : 각각의 게시판페이지 관련 폴더
│   │   ├─ bbs_100/ : 게시판에 붙은 카테고리
│   │   │   ├─ bbs_101.jsp
│   │   │   └─ bbs_101_code.jsp
│   │   │   ├─ bbs_102.jsp
│   │   │   └─ bbs_102_code.jsp
│   │   │   ├─ bbs_103.jsp
│   │   │   └─ bbs_103_code.jsp
│   │   ├─ bbs_200/ : 게시판에 붙은 카테고리
│   │   │   ├─ bbs_201.jsp
│   │   │   └─ bbs_201_code.jsp
│   │   │   ├─ bbs_202.jsp
│   │   │   └─ bbs_202_code.jsp
│   │   └─ bbs_300/ : 게시판에 붙은 카테고리
│   │       ├─ bbs_301.jsp
│   │       └─ bbs_301_code.jsp
│   └─ post/ : 게시글페이지 관련 폴더
│       ├─ post_view.jsp
│       ├─ post_view_code.jsp
│       ├─ post_writing.jsp
│       ├─ post_edit.jsp
│       ├─ post_edit_code.jsp
│       ├─ post_reply.jsp
│       ├─ post_reply_code.jsp
│       └─ post_writing_code.jsp
│   
├─ home/ : 홈페이지 폴더
│   ├─ home.jsp
│   └─ home_code.jsp
│   
├─ template/ : 해당 프로젝트에서 사용한 템플릿 폴더
│   ├─ components/
│   │   ├─ header.jsp
│   │   ├─ footer.jsp
│   │   └─ sidebar.jsp
│   └─ layout/
│       ├─ html_top.jsp
│       └─ html_bottom.jsp
│   
└─ member/ : 회원관련 폴더
    ├─ myinfo.jsp
    ├─ myinfo_code.jsp
    ├─ login.jsp
    ├─ login_code.jsp
    ├─ join.jsp
    └─ join_code.jsp
    
--------------------------------폴더 구조 설명-----------------------------------------------------
<폴더설명>

views : 모든 jsp파일의 최상위 폴더
admin : 모든 관리자 관련페이지의 최상위폴더
category_manage : 카테고리관리와 등록 페이지에 관한 폴더
bbs_manage : 전체 등록된 게시판의 목록을 관리하는 파일이 있는 폴더 
member_manage : 전체 회원의 목록을 관리하는 파일이 있는 폴더
bbs : 게시판 및 게시글 관련 폴더와 파일의 최상위 폴더
board : 각각의 게시판페이지가 있는 폴더
bbs_100 , bbs_200 ,bbs_300 ... : 해당 숫자는 각 각 게시판에 등록된 카테고리를 뜻함
post : 게시판의 각 게시글 페이지 관련 폴더 ex) post_view.jsp 게시판보기페이지 파일 , post_writing.jsp 게시글쓰기페이지 파일  
home : 홈 폴더
template : 해당 프로젝트에서 사용한 템플릿 폴더
components : header footer 등 components요소를 담은 폴더
layout : 전반적인 페이지의 레이아웃을 담당한 템플릿 관련 폴더
member : 로그인, 회원가입등의 회원관련 폴더


<파일설명>
1. 각각의 xxx.jsp와 xxx_code.jsp의 차이 :
xxx.jsp는 xxx_code.jsp를 불러온 frame의 기능만을 수행하며
핵심코드는 모듈화 하여 xxx_code.jsp안에 작성함 
2. bbs_101 , bbs_102, bbs_103, 파일들의 의미 :
해당 번호는 카테고리가 100인 게시판의 1번 게시판 2번게시판 3번게시판 을 뜻함
마찬가지로 bbs_507 이라는 파일이 있다면 카테고리 500에 해당하는 게시판의 7번째 게시판을 뜻함

--------------------------------폴더트리 요구사항-----------------------------------------------------------------------
    
1. 모듈화: 서로 관련된 파일들을 적절한 폴더에 그룹화해서 각 기능의 코드 및 리소스를 쉽게 찾을 수있게함
2. 일관성: 파일 및 폴더의 명명 규칙을 일관성있게 작성했고 일정한 패턴의 컨벤션을 따랐음
3. 가독성: 폴더구조를 명확하고 직관적이게 배치하여 프로젝트의 구성 요소들을 알기 쉽게 배치함
4. 확장성: 기존 게시판 기능을 추가 수정할때를 고려해서 설계함


    
    