var index ={
    init:function()
    {
        var _this =this;
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
        })
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
            url:'/api/update/'+employeenumber,
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data)
        }).done(function()
        {
            alert('사원 수정이 완료되었습니다')
            window.location.href='/employee/'+employeenumber;
        }).fail(function (error){
            alert(JSON.stringify(error));
        })

    },
    delete : function()
    {
        var check_cnt = document.getElementsByName("check_employee").length;
        employeenumbers = [];
        for(var i =0;i<check_cnt;i++)
        {
            if (document.getElementsByName("check_employee")[i].checked == true) {
                // alert(document.getElementsByName("check_employee")[i].value);
                employeenumbers.push({"employeenumber":document.getElementsByName("check_employee")[i].value});
            }
        }
        $.ajax({
            type:'DELETE',
            url:'/api/delete/',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(employeenumbers)
        }).done(function()
        {
            window.location.href='/';
        }).fail(function(error)
        {
            alert(JSON.stringify(error));
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
        })
    }
};
index.init();
