$('.btn').click(function(){
    var $href = $(this).attr('href');
    layer_popup($href);
});
function layer_popup(el){

    var $el = $(el);    //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    // $el.find('a.btn-layerClose').click(function(){
    //     isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
    //     return false;
    // });

    // $('.layer .dimBg').click(function(){
    //     $('.dim-layer').fadeOut();
    //     return false;
    // });

}
/*
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
        $('#btn_search').on('click',function()
        {
            _this.search();
        });
    },
    save : function()
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
        var employeenumber = $('#employeenumber').val();

        $.ajax({
            type:'DELETE',
            url:'/api/delete/'+employeenumber,
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
    },
    search : function()
    {
        var title = $('#cb_search option:selected').val();
        var keyword = $('#seacrchKeyword').val();

        window.location.href='/employee/search?title='+title+'&keyword='+keyword;
    }
};
index.init();
// function checkAll()
// {
//     if($('employee_check').is('check'))
//     {
//
//     }
// }
*/