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
           _this.delete();
        });
    },
    save : function()
    {
        var data = {
            org_id:$('#orgid').val(),
            company_id:$('#companyid').val(),
            employee_number:$('#employeenumber').val(),
            inspector_type:$('#inspectortype').val(),
            kr_name:$('#krname').val(),
            department_code:$('#departmentcode').val(),
            position_code:$('#positioncode').val(),
            upper_employee_number:$('#upperemployeenumber').val(),
            leader_yn:$('#leaderyn').val(),
            effective_start_date:$('#effectivestartdate').val(),
            effective_end_date:$('#effectiveenddate').val(),
            email:$('#email').val(),
            phone_number:$('#phonenumber').val(),
            use_yn:$('#useyn').val(),
            remarks:$('#remarks').val(),
            created_by:$('#createdby').val(),
            creation_date:$('#creationdate').val(),
            last_updated_by:$('#lastupdatedby').val(),
            last_update_date:$('#lastupdatedate').val()
        };
        $.ajax({
            type:'POST',
            url:'/api/register',
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data)
        }).done(function(msg)
        {
            alert(JSON.stringify(msg.responseText));
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        })

    },
    update : function()
    {
        var data = {
            org_id:$('#orgid').val(),
            company_id:$('#companyid').val(),
            employee_number:$('#employeenumber').val(),
            inspector_type:$('#inspectortype').val(),
            kr_name:$('#krname').val(),
            department_code:$('#departmentcode').val(),
            position_code:$('#positioncode').val(),
            upper_employee_number:$('#upperemployeenumber').val(),
            leader_yn:$('#leaderyn').val(),
            effective_start_date:$('#effectivestartdate').val(),
            effective_end_date:$('#effectiveenddate').val(),
            email:$('#email').val(),
            phone_number:$('#phonenumber').val(),
            use_yn:$('#useyn').val(),
            remarks:$('#remarks').val(),
            created_by:$('#createdby').val(),
            creation_date:$('#creationdate').val(),
            last_updated_by:$('#lastupdatedby').val(),
            last_update_date:$('#lastupdatedate').val()
        };
        var employeecode = $('#employeercode').val();
        $.ajax({
            type:'PUT',
            url:'/api/updateEm/'+employeecode,
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data)
        }).done(function()
        {
            alert('사원 수정이 완료되었습니다')
            window.location.href='/';
        }).file(function (error){
            alert(JSON.stringify(error));
        })

    },
    delete : function()
    {
        var employeercode = $('#employeercode').val();

        $.ajax({
            type:'DELETE',
            url:'/api/deleteEm'+employeercode,
            dataType:'json',
            contentType:'application/json; charset=utf-8'
        }).done(function()
        {
            alert('사원이 삭제되었습니다.');
            window.location.href='/';
        }).fail(function (error)
        {
            alert(JSON.stringify(error));
        })
    }
};
index.init();