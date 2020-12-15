# MES_Register

## Srping

  *[RestController] Spring MVC Controller에 @Responsebody가 추가된 것 Json형태로 객체 데이터를 반환*
  
  *[Domain]도메인 객체는 비즈니스 로직이 반영되는 곳. 도메인 객체에서 자기 자신의 책임을 충분히 다하지 않으면 그 로직들은 자연스럽게 Service 영역 및 외부 영역에서 해당 책임 넘겨받아 구현하게 됩니다.*
  
  *[Builder] 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.*
  
  *[ORM] 객체관계매핑 객체는 객체대로 설계하고, 관계형 데이터베이스는 관계형 데이터베이스대로 설계한다.-참고[JPA개념링크](https://gmlwjd9405.github.io/2019/08/04/what-is-jpa.html)*
  <pre>
    Spring boot 2.4.3  
    │  .gitignore   - Git에서 커밋할때 무시할 부분
    │  build.gradle - gradle을 통해 spring 의존성을 설정해주는 build 프레임워크
    │  gradlew      - gradle 명령 파일
    │  gradlew.bat  - gradle 명령 파일
    │  HELP.md
    │  README.md
    │  settings.gradle - 빌드할 프로젝트의 정보를 설정
    │
    ├─.gradle
    │
    │
    │
    ├─gradle - gradle 버전별 엔진 및 설정 파일
    │  └─wrapper
    │          gradle-wrapper.jar
    │          gradle-wrapper.properties
    │
    └─src
        ├─main
        │  ├─java - 자바 소스 파일 위치
        │  │  └─com
        │  │      └─example
        │  │          └─mesttest
        │  │              └─demo
        │  │                  │  DemoApplication.java - Spring을 톰캣을 통해 빌드 해주는 부분
        │  │                  │
        │  │                  ├─Controller - 컨트롤 부분 Url과 메소드 'POST,GET,DELETE,PUT'을 이용하여 해당하는 부분을 뷰를 통해 보여줌
        │  │                  │      IndexController.java - 페이지를 찾아서 보여주는 부분 
        │  │                  │      RegisterDefaultStructureController.java - [RestController] 사원관리시 입력되어야할 데이터 기본 구조
        │  │                  │      RegisterEmController.java - [RestController] 사원관리시 등록,수정,삭제,조회를 처리할 컨트롤러
        │  │                  │
        │  │                  ├─Domain 
        │  │                  │  │  RegisterEm.java  - [Entity][Builder] 사원관리에 필요한 필드들을 가지고 Jpa와 함께 Entity관리를 한다.
        │  │                  │  │  RegisterEmPK.java - RegisterEm.java에서 사용될 PK를 가지고있는 클래스
        │  │                  │  │
        │  │                  │  ├─defaultStructure
        │  │                  │  │      RegisterDepartmentcode.java - [Entity][Builder] 부서코드 
        │  │                  │  │      RegisterFactory.java        - [Entity][Builder] 공장
        │  │                  │  │      RegisterInspectortype.java  - [Entity][Builder] 사원구분
        │  │                  │  │      RegisterPosition.java       - [Entity][Builder] 직위
        │  │                  │  │
        │  │                  │  └─Repository - [ORM] JpaRepository<T,ID> 인터페이스를 이용하여 T에는 엔티티 클래스를 작성하고 ID에는 엔티티에서 사용하는 ID를 입력
        │  │                  │          RegisterDepartmentcodeRepository.java  - 부서코드 관련 JPA
        │  │                  │          RegisterFactoryRepository.java         - 공장 관련 JPA
        │  │                  │          RegisterinspectortypeRepository.java   - 사원구분 관련 JPA
        │  │                  │          RegisterPositionRepository.java        - 직위 관련 JPA
        │  │                  │          RegisterRepository.java                - 사원 관련 JPA
        │  │                  │
        │  │                  ├─Dto
        │  │                  │      EmployeeUpdateReqDto.java  - [Builder] 사원관리 수정에 필요한 데이터 관리하는 클래스 
        │  │                  │      RegisterDto.java           - 사원관리에 필요한 데이터 관리하는 클래스
        │  │                  │      RegisterPositionDto.java   - 직위에 필요한 데이터 관리하는 클래스
        │  │                  │      RegisterResDto.java        - Service,JPA에서 반환할 데이터를 가지고있는 클래스
        │  │                  │
        │  │                  └─Service - 비즈니스로직 처리와 비즈니스와 관련된 도메인 모데의 적합성 검증 , 두 계층을 직접연결 하지않게해 유연성 증가
        │  │                          RegisterService.java      - 
        │  │
        │  └─resources
        │      │  application.properties
        │      │
        │      ├─static
        │      │  ├─css
        │      │  │  │  jquery-ui.css
        │      │  │  │  style.css
        │      │  │  │  ui.jqgrid-bootstrap-ui.css
        │      │  │  │  ui.jqgrid-bootstrap.css
        │      │  │  │  ui.jqgrid-bootstrap4.css
        │      │  │  │  ui.jqgrid.css
        │      │  │  │
        │      │  │  └─images
        │      │  │
        │      │  ├─js
        │      │  │  └─app
        │      │  │      │  assist.js
        │      │  │      │  Changes.txt
        │      │  │      │  chartJs.js
        │      │  │      │  install.txt
        │      │  │      │  jquery-1.11.0.min.js
        │      │  │      │  jquery.jqGrid.min.js
        │      │  │      │  jquery.js
        │      │  │      │  main.js - jqGrid와 데이터 삭제,조회,수정,입력을 할 수 있음.
        │      │  │      │
        │      │  │      ├─chart
        │      │  │      └─i18n
        │      │  │
        │      │  └─plugins
        │      │
        │      └─templates - 페이지 부분
        │          │  error.mustache
        │          │  inputData.mustache
        │          │  main.mustache
        │          │  update.mustache
        │          │  updateData.mustache
        │          │
        │          ├─data
        │          └─layout
        │                  footer.mustache
        │                  header.mustache
        │                  middle.mustache
        │
        └─test
            └─java
                └─com
                    └─example
                        └─mesttest
                            └─demo
                                │  DemoApplicationTests.java - TDD 테스트를 위한 
                                │
                                └─Controller
                                        RegisterEmTest.java
                                    
  </pre>
## Gradle

### build.gradle

<pre>
  buildscript {
      ext {
          springBootVersion = '2.1.7.RELEASE'
      }
      //ext{}는 build.gradle에서 사용하는 전역변수를 설정하겠다라는 의미
      //의미 : springBootVersion을 2.1.7.RELEASE로 하겠다.

      repositories {
          mavenCentral()
          jcenter()
      }


      dependencies {
          classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
      }
      //spring-boot-gradle-plugin라는 스프링 부트 그레이들 플러그인의 2.1.7.RELEASE를 의존성으로 받겠다는 의미이다.
      //${springBootVersion}으로 사용해야지만, 각 라이브러리들의 버전 관리가 한 곳으로 집중되고, 버전 충돌 문제도 해결된다

  }
  //해당 프로젝트의 플러그인 의전성 관리를 위한 설정


  apply plugin: 'java'
  apply plugin: 'eclipse'
  apply plugin: 'org.springframework.boot'
  apply plugin: 'io.spring.dependency-management'
  //자바와 스프링 부트를 사용하기 위한 필수적인 플러그인들.

  group 'com.example.MestTest'
  version '0.0.1-SNAPSHOT'+new Date().format("yyyyMMddHHmmss")
  sourceCompatibility = 11

  repositories {
      mavenCentral()
      jcenter()
  }
  //repositories는 각종 의존성들을 어떤 원격 저장소에 받을지를 지정한다.
  //기본적으로 mavenCentral()을 자주 사용하나, 최근에는 jcenter()를 많이 사용한다.
  //이유는 mavenCentral()는 라이브러리 업로드를 위해서 많은 설정이 필요한 반면, jcenter() 라이브러리 업로드를 간단하게 할 수 있기 때문이다.
  //또한, jcenter() 라이브러리를 업로드하면 mavenCentral에도 업로드가 가능하다.

  dependencies {
      implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
      implementation 'org.springframework.boot:spring-boot-starter-mustache'
      implementation 'org.springframework.boot:spring-boot-starter-web'
  //    implementation 'junit:junit:4.12'
      compile 'mysql:mysql-connector-java'
      compileOnly 'org.projectlombok:lombok'
      runtimeOnly 'com.h2database:h2'
      annotationProcessor 'org.projectlombok:lombok'
      testImplementation 'org.springframework.boot:spring-boot-starter-test'
  }

</pre>

## jqGrid
jQGrid 기본
  <pre>
  <code>
    $("#jqGrid").jqGrid({
        url: url,
        datatype: "json",
        mtype:"GET",
        colNames: cnames, //속성에 표시될 내용들
        ajaxGridOptions: { contentType: "application/json; charset=UTF-8" },
        ajaxRowOptions: { contentType: "application/json; charset=UTF-8", async: true },
        ajaxSelectOptions: { contentType: "application/json; charset=UTF-8", dataType: "JSON" },
        colModel: [ // 각 속성마다 이름,인덱스,넓이 등 옵션을 설정할 수 있음
            {name:'Insert_name',index:'Insert_index',width: Insert_width ,align: "Insert_align",[key = 'inert_bool']},
        ],
        height: 480, // 
        rowNum: 100,
        rowList: [100, 200, 300],
        pager: '#jqGridPager', // JqGrid 밑 에 있는 페이지,row를 보여주는 행
        multiselect:true, // 체크박스 표시
        pagerpos:'center', // 페이저의 위치
        sortable:true, // 정렬
        rownumbers: true, // 번호 표시
        autowidth: true, // 자동 넓이
        ondblClickRow:function(id){ // 더블 클릭시 실행되는 함수
            editparameters = { //edit실행시 
                "keys" : true,
                "oneditfunc" : null,
                "successfunc" : function(){
                    alert('저장이 완료되었습니다.')
                    return true;
                },
                "url" : '/api/update/'+id, // url변경
                "extraparam" : {},
                "aftersavefunc" :null,
                "errorfunc": function(err){
                    alert('변경할 수 없는 값 입니다.');
                    jQuery('#jqGrid').jqGrid('restoreRow', err);
                },
                "afterrestorefunc" : null,
                "restoreAfterError" : false,
                "mtype" : "PUT"
            }
            if (id && id !== lastsel) {
                jQuery('#jqGrid').jqGrid('restoreRow', lastsel);
                jQuery('#jqGrid').jqGrid('editRow', id, editparameters);
                lastsel = id;
            }
        },
        caption: "사원관리 그리드",
        editurl: '/api/register/', //저장시 넣을 url
        serializeRowData:function(data){ // 값을 넘겨줄때 어떠한 형식으로 줄것인가 지정하는 함수 코드 같은 경우에는 JSON형식으로 반환
            return JSON.stringify(data);
        }
    });
    
    jQuery("#jqGrid").jqGrid('navGrid', //네비게이션에서 표시할것들 표시
        "#jqGridPager",{ //첫번째 {} 옵션단위 , 편집 false, 행 추가 : false, 삭제 true, 삭제시 실행할 함수 
            edit:false,add:false,del:true, 
            delfunc : function(id){
                {
                    var params =new Array();
                    var idArray = $('#jqGrid').jqGrid('getDataIDs');
                    for(var i=0;i<idArray.length;i++)
                    {
                        if($("input:checkbox[id='jqg_jqGrid_"+idArray[i]+"']").is(":checked"))
                        {
                            var obj = new Object();
                            obj.employeenumber =idArray[i];
                            params.push(obj);
                        }
                    }
                    // alert(id);
                    $.ajax({
                        type:'DELETE',
                        url:'/api/delete',
                        dataType:'json',
                        contentType:'application/json; charset=utf-8',
                        data:JSON.stringify(params)
                    }).done(function()
                    {
                        alert("삭제 완료되었습니다.");
                        window.location.href='/';
                    }).fail(function(error)
                    {
                        alert(error.responseText);
                        window.location.href='/';
                    })
                }
            }});
  </code>
  </pre>
