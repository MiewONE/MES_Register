var lastsel;
var index ={
    init:function()
    {
        var _this =this;
        var state = false;
        $('#btn_save').on('click',function(){
            _this.save();
        });
        $('#btn_update').on('click',function ()
        {
            _this.update();
        });
        $('#btn_delete').on('click',function ()
        {
            if(confirm("정말로 삭제를 진행하시겟습니까?")==true)
            {
                _this.delete();
            }

        });
        $('#btn_search').on('click',function()
        {
            _this.search();
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
        window.location.href='/employee/register';
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
        // var employeenumber = $('#employeenumber').val();

        // $.ajax({
        //     type:'DELETE',
        //     url:'/api/delete/'+employeenumber,
        //     dataType:'json',
        //     contentType:'application/json; charset=utf-8'
        // }).done(function()
        // {
        //     alert('사원이 삭제되었습니다.');
        //     window.location.href='/';
        // }).fail(function (error)
        // {
        //     alert(JSON.stringify(error));
        // })
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
    var test;
    var cnames = ['사원번호','사업장', '공장',  '사원구분', '사원명', '부서코드', '직위', '상위자', '부서장여부', '입사 일정', '퇴사 일정', '이메일', '전화번호', '사용유무', '비고', '등록자', '등록 일자', '수정자', '수정일자'];
    $("#jqGrid").jqGrid({
        url: "/api/emolpyeeList",
        datatype: "json",
        mtype:"GET",
        colNames: cnames,
        ajaxGridOptions: { contentType: "application/json; charset=UTF-8" },
        ajaxRowOptions: { contentType: "application/json; charset=UTF-8", async: true },
        ajaxSelectOptions: { contentType: "application/json; charset=UTF-8", dataType: "JSON" },
        colModel: [
            { name: 'employeenumber',key:true, index: 'employeenumber', width: 50 ,align: "center",editable:true},
            { name: 'orgid', index: 'orgid', width: 50, align: "center",editable:true },
            { name: 'companyid', index: 'companyid', width: 50, align: "center",editable:true },
            { name: 'inspectortype', index: 'inspectortype', width: 50 ,align: "center",editable:true},
            { name: 'krname', index: 'krname', width: 50,align: "center",editable:true },
            { name: 'departmentcode', index: 'departmentcode', width: 50,align: "center",editable:true },
            { name: 'positioncode', index: 'positioncode', width: 50,align: "center",editable:true },
            { name: 'upperemployeenumber', index: 'upperemployeenumber', width: 50,align: "center",editable:true },
            { name: 'leaderyn', index: 'leaderyn', width: 50,align: "center",editable:true },
            { name: 'effectivestartdate', index: 'effectivestartdate', width: 50,align: "center",editable:true },
            { name: 'effectiveenddate', index: 'effectiveenddate', width: 50 ,align: "center",editable:true},
            { name: 'email', index: 'email', width: 50,align: "center",editable:true },
            { name: 'phonenumber', index: 'phonenumber', width: 50,align: "center",editable:true },
            { name: 'useyn', index: 'useyn', width: 50,align: "center",editable:true },
            { name: 'remarks', index: 'remarks', width: 50 ,align: "center",editable:true},
            { name: 'createdby', index: 'createdby', width: 50,align: "center",editable:true },
            { name: 'creationdate', index: 'creationdate', width: 50 ,align: "center",editable:true},
            { name: 'lastupdatedby', index: 'lastupdatedby', width: 50 ,align: "center",editable:true},
            { name: 'lastupdatedate', index: 'lastupdatedate', width: 50 ,align: "center",editable:true},
        ],
        height: 480,
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#jqGridPager',
        rownumbers: true,
        autowidth: true,
        onSelectRow: function (id) {
            editparameters = {
                "keys" : true,
                "oneditfunc" : null,
                "successfunc" : null,
                "url" : '/api/update/'+id,
                "extraparam" : {},
                "aftersavefunc" : null,
                "errorfunc": null,
                "afterrestorefunc" : null,
                "restoreAfterError" : false,
                "mtype" : "PUT"
            }
            if (id && id !== lastsel) {
                jQuery('#jqGrid').jqGrid('restoreRow', lastsel);
                jQuery('#jqGrid').jqGrid('editRow',
                    id,
                    editparameters);
                // jQuery('#jqGrid').jqGrid('editRow',
                //     id, // id
                //     true, //key
                //     null, //oneditfunc
                //     null, //successfunc
                //     '/api/update/'+id,//url
                //     jQuery('#jqGrid').jqGrid('getRowData',id)//extraparam
                // );
                lastsel = id;
            }
        },
        caption: "사원관리 그리드",
        serializeRowData:function(data){
            return JSON.stringify(data);
        }
    });

});
index.init();
