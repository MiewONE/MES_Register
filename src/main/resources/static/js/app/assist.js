var index ={
    init : function (){
        $('#btn_positions').on('click', function () {

            var search = $("#inputDefault").val();
            search = search.replace(/</g,"").replace(/>/g,"");
            search = search.replace(/\"/g,"").replace(/\'/g,"");
            $('#inputDefault').val(search);
            if(search == "단어를 입력하세요") {
                search = "";
            }

            if(search==""){
                alert("단어를 입력하시오");
                return false;
            }else if(search!=""){
                if(search.length < 2){
                    alert('단어는 1자리 이상 입력하셔야 합니다.');
                    return false;
                }
            }
            $.ajax({
                url:'/api/register/insertposition',
                type:"POST",
                contentType:"application/json;charset=utf-8",
                datatype:"json",
                data:JSON.stringify(search)
            }).done(function (data){{
                alert(data);
                if(!data.includes("실패"))
                {
                    $('#tbd').append("<tr><td>" + search + "</td></tr>");
                }else
                {
                    alert('test');
                }

            }}).fail(function(data){
                alert('fail'+JSON.stringify(data));
            })
        });
        $('#btn_positions_del').on('click',function (){

        });
        /*
        *
        *
        * */
    },

}
index.init();
