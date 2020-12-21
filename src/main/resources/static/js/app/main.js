var lastsel;
var test='';
var state = false;
var index ={
    init:function()
    {
        var _this =this;

        $('#btn_save').on('click',function(){
            _this.save();
            // jQuery('#jqGrid').jqGrid(
            //     'addRow',
            // )
        });

        $('#btn_update').on('click',function ()
        {
            // _this.update();
            jQuery('#jqGrid').jqGrid('editRow');
        });
        $('#btn_delete').on('click',function ()
        {
            // if(confirm("정말로 삭제를 진행하시겟습니까?")==true)
            // {
            //     _this.delete();
            // }
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
            if(params.length <1) alert('삭제할 항목을 선택해주십시오');
            else
            {
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

            // var gr = jQuery("#delgrid").jqGrid('getGridParam','selrow');
            // if( gr != null ) jQuery("#delgrid").jqGrid('delGridRow',gr,{reloadAfterSubmit:false});
            // else alert("Please Select Row to delete!");

        });
        $('#btn_search').on('click',function()
        {
            jQuery("#jqGrid").jqGrid('searchGrid'
            );
        });
        $('#btn_register').on('click',function(){
            _this.register();
        });
        $('#check_employees').on('click',function(){
            if($("input:checkbox[id='check_employees']").prop("checked"))
            {
                $("input[type=checkbox]").prop("checked",true);
            }else
            {
                $("input[type=checkbox]").prop("checked",false);
            }
        });
        $('#btn_factory').on('click',function(){
            $.ajax({
                url:'/api/register/factory',
                type:"GET",
                contentType:"application/josn;charset=utf-8",
                dataType:"json",
            }).done(function(data){
                if (!state) {
                    var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                    inputData += "<div id='btn_inputContainer'></div>";
                    $('#viewData').append(inputData);
                    var inputBtn ="<button class='btn_data' id='btn_factorys'>등록</button>" ;
                    inputBtn += "<button class='btn_data' id='btn_factorys_del'>삭제</button>";
                    $('#btn_inputContainer').append(inputBtn);
                    var text = "<table id='DefaultTable'>";
                    text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                    text += "<script src='/js/app/assist.js'></script>";
                    $('#viewData').append(text);
                    $('#thd').append("<tr><th>공장</th></tr>");
                    for (var i = 0; i < data.length; i++) {
                        $('#tbd').append("<tr><td>" + data[i].factory + "</td></tr>");
                    }
                    state = true;
                } else {
                    state = false;
                    $('#viewData').empty();

                }
            }).fail(function(error){
                alert('fail'+error);
            })
        });
        $('#btn_position').on('click',function(){
            $.ajax({
                url:'/api/register/position',
                type:"GET",
                contentType:"application/josn;charset=utf-8",
                dataType:"json",
            }).done(function(data){
                if (!state) {
                    var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                    inputData += "<div id='btn_inputContainer'></div>";
                    $('#viewData').append(inputData);
                    var inputBtn ="<button class='btn_data' id='btn_positions'>등록</button>" ;
                    inputBtn += "<button class='btn_data' id='btn_positions_del'>삭제</button>";
                    $('#btn_inputContainer').append(inputBtn);
                    var text = "<table id='DefaultTable'>";
                    text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                    text += "<script src='/js/app/assist.js'></script>";
                    $('#viewData').append(text);
                    $('#thd').append("<tr><th>직위</th></tr>");
                    for (var i = 0; i < data.length; i++) {
                        $('#tbd').append("<tr><td>" + data[i].position + "</td></tr>");
                    }
                    state = true;
                } else {
                    state = false;
                    $('#viewData').empty();

                }
            }).fail(function(error){
                alert('fail'+error);
            })
        });
        $('#btn_departmentcode').on('click',function(){
            $.ajax({
                url:'/api/register/departmentcode',
                type:"GET",
                contentType:"application/josn;charset=utf-8",
                dataType:"json",
            }).done(function(data){
                if (!state) {
                    var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                    inputData += "<div id='btn_inputContainer'></div>";
                    $('#viewData').append(inputData);
                    var inputBtn ="<button class='btn_data' id='btn_departmentcodes'>등록</button>" ;
                    inputBtn += "<button class='btn_data' id='btn_departmentcodes_del'>삭제</button>";
                    $('#btn_inputContainer').append(inputBtn);
                    var text = "<table id='DefaultTable'>";
                    text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                    text += "<script src='/js/app/assist.js'></script>";
                    $('#viewData').append(text);
                    $('#thd').append("<tr><th>부서코드</th></tr>");
                    for (var i = 0; i < data.length; i++) {
                        $('#tbd').append("<tr><td>" + data[i].departmentcode + "</td></tr>");
                    }
                    state = true;
                } else {
                    state = false;
                    $('#viewData').empty();

                }
            }).fail(function(error){
                alert('fail'+error);
            })
        });
        $('#btn_inspectortype').on('click',function(){
            $.ajax({
                url:'/api/register/btn_inspectortype',
                type:"GET",
                contentType:"application/josn;charset=utf-8",
                dataType:"json",
            }).done(function(data){
                if (!state) {
                    var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                    inputData += "<div id='btn_inputContainer'></div>";
                    $('#viewData').append(inputData);
                    var inputBtn ="<button class='btn_data' id='btn_inspectortypes'>등록</button>" ;
                    inputBtn += "<button class='btn_data' id='btn_inspectortypes_del'>삭제</button>";
                    $('#btn_inputContainer').append(inputBtn);
                    var text = "<table id='DefaultTable'>";
                    text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                    text += "<script src='/js/app/assist.js'></script>";
                    $('#viewData').append(text);
                    $('#thd').append("<tr><th>사원구분</th></tr>");
                    for (var i = 0; i < data.length; i++) {
                        $('#tbd').append("<tr><td>" + data[i].inspectortype + "</td></tr>");
                    }
                    state = true;
                } else {
                    state = false;
                    $('#viewData').empty();

                }
            }).fail(function(error){
                alert('fail'+error);
            })
        });


    },

    save : function()
    {
        if(!state)
        {
            var script = "<div class='input_container'><div class='inputform'><label for='orgid'>사업장</label><input type='text' id='orgid'/></div><div class='inputform'><label for='companyid'>공장</label><input type='text' id='companyid'/></div><div class='inputform'><label for='employeenumber'>사원 번호</label><input type='text' id='employeenumber' value=''/></div><div class='inputform'><label for='inspectortype'>사원구분</label><input type='text' required maxlength='20' id='inspectortype'/></div><div class='inputform'><label for='krname'>사원명</label><input type='text' required maxlength='200' id='krname'/></div><div class='inputform'><label for='departmentcode'>부서코드</label><input type='text' required maxlength='20' id='departmentcode'/></div><div class='inputform'><label for='positioncode'>직위</label><input type='text' id='positioncode' required maxlength='20'/></div><div class='inputform'><label for='upperemployeenumber'>상위자</label><input type='text' id='upperemployeenumber' required maxlength='20'/></div>           <div class='inputform'><label for='leaderyn'>부서장여부</label><input type='text' id='leaderyn'maxlength='1'/></div>           <div class='inputform'><label for='effectivestartdate'>입사일정</label><input type='date' id='effectivestartdate'/></div>";
            script +="<div class='inputform'><label for='effectiveenddate'>퇴사일정</label><input type='date' id='effectiveenddate'/></div><div class='inputform'><label for='email'>이메일</label><input type='email' id='email' required maxlength='200'/></div><div class='inputform'><label for='phonenumber'>전화번호</label><input type='text' id='phonenumber' required maxlength='20'/></div><div class='inputform'><label for='useyn'>사용유무</label><input type='text' id='useyn' maxlength='1'/></div><div class='inputform'><label for='remarks'>비고</label><input type='text' id='remarks' required maxlength='200'/></div><div class='inputform'><label for='createdby'>등록자</label><input type='text' id='createdby' required maxlength='30'/></div><div class='inputform'><label for='creationdate'>등록 일자</label><input type='date' id='creationdate' /></div><div class='inputform'><label for='lastupdatedby'>수정자</label><input type='text' id='lastupdatedby' required maxlength='30'/></div><div class='inputform'><label for='lastupdatedate'>수정 일자</label><input type='date' id='lastupdatedate'/></div>        </div>";
            jQuery("#jqGrid").jqGrid('setGridWidth',$(window).width()*5/7);
            jQuery('#InsertZone').width($(window).width()*2/7);
            jQuery('#InsertZone').append(script);
            // jQuery('#InsertZone').css('background-color','green');
            state = true;
        } else {
            state = false;
            jQuery("#jqGrid").jqGrid('setGridWidth',$(window).width());
            $('#InsertZone').empty();
        }


        // window.location.href='/employee/register';
    },
    update : function()
    {
        var data = {
            orgid:$('#orgid').val(),
            companyid:$('#companyid').val(),
            employeenumber:$('#employeenumber').val(),
            inspectortype:$('#inspectortype').val(),
            krname:$('#krname').val(),
            departmentcode:$('#departmentcode').val(),
            positioncode:$('#positioncode').val(),
            upperemployeenumber:$('#upperemployeenumber').val(),
            leaderyn:$('#leaderyn').val(),
            effectivestartdate:$('#effectivestartdate').val(),
            effectiveenddate:$('#effectiveenddate').val(),
            email:$('#email').val(),
            phonenumber:$('#phonenumber').val(),
            useyn:$('#useyn').val(),
            remarks:$('#remarks').val(),
            createdby:$('#createdby').val(),
            creationdate:$('#creationdate').val(),
            lastupdatedby:$('#lastupdatedby').val(),
            lastupdatedate:$('#lastupdatedate').val()
        };
        var employeenumber = $('#employeenumber').val();
        $.ajax({
            type:'PUT',
            ///employee/search?title='+title+'&keyword='+keyword;
            url:'/api/update/'+employeenumber,
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data)
        }).done(function()
        {
            alert('사원 수정이 완료되었습니다')
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        })

    },
    delete : function()
    {
        var check_cnt = document.getElementsByName("check_employee").length;
        var employeenumbers = new Array();
        for(var i =0;i<check_cnt;i++)
        {
            if (document.getElementsByName("check_employee")[i].checked == true) {
                // alert(document.getElementsByName("check_employee")[i].value);
                employeenumbers.push({"employeenumber":document.getElementsByName("check_employee")[i].value});
            }
        }
        var jsonString = JSON.stringify(employeenumbers)
        $.ajax({
            type:'DELETE',
            url:'/api/delete',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data:jsonString
        }).done(function()
        {
            alert("삭제 완료되었습니다.");
            window.location.href='/';
        }).fail(function(error)
        {
            alert(error.responseText);
            window.location.href='/';
        })
    },
    search : function()
    {
        var title = $('#cb_search option:selected').val();
        var keyword = $('#seacrchKeyword').val();

        window.location.href='/employee/search?title='+title+'&keyword='+keyword;
    },
    register : function()
    {
        var data = {
            orgid:$('#orgid').val(),
            companyid:$('#companyid').val(),
            employeenumber:$('#employeenumber').val(),
            inspectortype:$('#inspectortype').val(),
            krname:$('#krname').val(),
            departmentcode:$('#departmentcode').val(),
            positioncode:$('#positioncode').val(),
            upperemployeenumber:$('#upperemployeenumber').val(),
            leaderyn:$('#leaderyn').val(),
            effectivestartdate:$('#effectivestartdate').val(),
            effectiveenddate:$('#effectiveenddate').val(),
            email:$('#email').val(),
            phonenumber:$('#phonenumber').val(),
            useyn:$('#useyn').val(),
            remarks:$('#remarks').val(),
            createdby:$('#createdby').val(),
            creationdate:$('#creationdate').val(),
            lastupdatedby:$('#lastupdatedby').val(),
            lastupdatedate:$('#lastupdatedate').val()
        };
        $.ajax({
            type:'POST',
            url:'/api/register',
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data)
        }).done(function(msg)
        {
            alert(msg.responseText);
            window.location.href='/';
        }).fail(function (error){
            alert(error.responseText);
            window.location.href='/';
        });

    },




};
$(document).ready(function () {

    // ="FE:FedEx;IN:InTime;TN:TNT;AR:ARAMEX";
    $.ajax({
        type:'GET',
        url:'api/register/position',
        dataType:'json',
        contentType:'application/json;charset=utf-8',
    }).done(function(data){
        for(var i=0;i<data.length;i++)
        {
            if(test===''||test==="")
            {
                var tests = (data[i].position+':'+data[i].position+';').toString();
                test = tests;
            }else
            {
                test += (data[i].position+':'+data[i].position+';').toString();
            }

        }
        var url = window.location.pathname;
        switch (url)
        {
            case '/':
                searchData('/api/emolpyeeList');
                break;
            default :

                break;
        }


        jQuery("#jqGrid").jqGrid('inlineNav',"#jqGridPager");
    }).fail(function(err){
        alert(JSON.stringify(err));
    });


    // jQuery('#jqGrid').jqGrid('navGrid','#jqGridPager').jqGrid('navButtonAdd','#jqGridPager');
});
function imageFormatter(cellvalue, options, rowObject)
{

    return '<img src="' + rowObject.test + '" />';
}
index.init();


function searchData(url) {
    var cnames = ['사원번호','사업장', '공장',  '사원구분', '사원명', '부서코드', '직위', '상위자', '부서장여부', '입사 일정', '퇴사 일정', '이메일', '전화번호', '사용유무', '비고', '등록자', '등록 일자', '수정자', '수정일자','test'];
    $("#jqGrid").jqGrid({
        url: url,
        datatype: "json",
        mtype:"GET",
        colNames: cnames,
        ajaxGridOptions: { contentType: "application/json; charset=UTF-8" },
        ajaxRowOptions: { contentType: "application/json; charset=UTF-8", async: true },
        ajaxSelectOptions: { contentType: "application/json; charset=UTF-8", dataType: "JSON" },
        colModel: [
            //{name:'checkbox',index:'checkbox',width: 50 ,align: "center"},
            { name: 'employeenumber',key:true, index: 'employeenumber', width: 50 ,align: "center",editable:true},
            { name: 'orgid', index: 'orgid', width: 50, align: "center",editable:true },
            { name: 'companyid', index: 'companyid', width: 50, align: "center",editable:true },
            { name: 'inspectortype', index: 'inspectortype', width: 50 ,align: "center",editable:true},
            { name: 'krname', index: 'krname', width: 50,align: "center",editable:true },
            { name: 'departmentcode', index: 'departmentcode', width: 50,align: "center",editable:true },
            { name: 'positioncode', index: 'positioncode', width: 25,align: "center",editable:true,edittype:"select",editoptions:{value:test} },
            { name: 'upperemployeenumber', index: 'upperemployeenumber', width: 50,align: "center",editable:true },
            { name: 'leaderyn', index: 'leaderyn', width: 25,align: "center",editable:true,editoptions:{maxlength:"1"} ,search:false},
            { name: 'effectivestartdate', index: 'effectivestartdate', width: 50,align: "center",editable:true,search:false },
            { name: 'effectiveenddate', index: 'effectiveenddate', width: 50 ,align: "center",editable:true,search:false},
            { name: 'email', index: 'email', width: 50,align: "center",editable:true },
            { name: 'phonenumber', index: 'phonenumber', width: 50,align: "center",editable:true },
            { name: 'useyn', index: 'useyn', width: 25,align: "center",editable:true ,editoptions:{maxlength:"1"},search:false},
            { name: 'remarks', index: 'remarks', width: 50 ,align: "center",editable:true,edittype:"textarea", editoptions:{rows:"2",cols:"10"},search:false},
            { name: 'createdby', index: 'createdby', width: 50,align: "center",editable:true,search:false },
            { name: 'creationdate', index: 'creationdate', width: 50 ,align: "center",editable:true,search:false},
            { name: 'lastupdatedby', index: 'lastupdatedby', width: 50 ,align: "center",editable:true,search:false},
            { name: 'lastupdatedate', index: 'lastupdatedate', width: 50 ,align: "center",editable:true,search:false},
            {name:'test',index:'test',width:50,align:"center",formatter:imageFormatter}
        ],
        height: 200,
        rowNum: 100,
        rowList: [100, 200, 300],
        pager: '#jqGridPager',
        width:$(window).width()-50,
        multiselect:true,
        pagerpos:'center',
        rownumbers: true,
        ondblClickRow:function(id){
            editparameters = {
                "keys" : true,
                "oneditfunc" : null,
                "successfunc" : function(){
                    alert('저장이 완료되었습니다.')
                    return true;
                },
                "url" : '/api/update/'+id,
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
        editurl: '/api/register/',
        serializeRowData:function(data){
            return JSON.stringify(data);
        }
    });
    // jQuery("#jqGrid").jqGrid('navGrid',
    //     "#jqGridPager",{
    //         edit:false,add:false,del:true,
    //         delfunc : function(id){
    //             {
    //                 var params =new Array();
    //                 var idArray = $('#jqGrid').jqGrid('getDataIDs');
    //                 for(var i=0;i<idArray.length;i++)
    //                 {
    //                     if($("input:checkbox[id='jqg_jqGrid_"+idArray[i]+"']").is(":checked"))
    //                     {
    //                         var obj = new Object();
    //                         obj.employeenumber =idArray[i];
    //                         params.push(obj);
    //                     }
    //                 }
    //                 // alert(id);
    //                 $.ajax({
    //                     type:'DELETE',
    //                     url:'/api/delete',
    //                     dataType:'json',
    //                     contentType:'application/json; charset=utf-8',
    //                     data:JSON.stringify(params)
    //                 }).done(function()
    //                 {
    //                     alert("삭제 완료되었습니다.");
    //                     window.location.href='/';
    //                 }).fail(function(error)
    //                 {
    //                     alert(error.responseText);
    //                     window.location.href='/';
    //                 })
    //             }
    //         }});
    jQuery("#jqGrid").jqGrid('gridResize',{minWidth:350,maxWidth:$(window).width(),minHeight:80, maxHeight:$(window).height()});
    // jQuery("#jqGrid").jqGrid('gridResize',{minWidth:350,maxWidth:800,minHeight:80, maxHeight:350});
}