# MES_Register
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
