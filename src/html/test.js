var state = false;
var index = {

    init: function () {
        
        // $('#btn_factory').on('click', function () {
        //     $.ajax({
        //         url: '/api/register/factory',
        //         type: "GET",
        //         contentType: "application/josn;charset=utf-8",
        //         dataType: "json",
        //     }).done(function (data) {
        //         if (!state) {
        //             // var data = ["1", "2", "3", "사장"];
        //             var inputData = "<input type='text' name='inputDefault' id='inputDefault' style='width:172px;height:50px;'>";
        //             inputData += "<button class='btn' id='btn_factory' style='width:180px'>공장 입력</button>";
        //             var text = "<table style='width:180px;overflow-y:scroll;min-height: 100px;max-height: 500px;'>";
        //             text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
        //             $('#viewData').append(inputData);
        //             $('#viewData').append(text);
        //             $('#thd').append("<tr><th>직위</th></tr>");
        //             for (var i = 0; i < data.length; i++) {
        //                 $('#tbd').append("<tr><td>" + data[i] + "</td></tr>");
        //             }
        //             state = true;
        //         } else {
        //             state = false;
        //             $('#viewData').empty();

        //         }
        //     }).fail(function (error) {
        //         alert(error);
        //     })
        // });

        $('#btn_factory').on('click', function () {
            if (!state) {
                var data = ["1", "2", "3", "사장"];
                var inputData = "<input type='text' name='inputDefault' id='inputDefault' style='width:172px;height:50px;'>";
                inputData += "<button class='btn' id='btn_factorys' style='width:180px'>공장 입력</button>";
                var text = "<table style='width:180px;overflow-y:scroll;min-height: 100px;max-height: 500px;'>";
                text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                $('#viewData').append(inputData);
                $('#viewData').append(text);
                $('#thd').append("<tr><th>직위</th></tr>");
                for (var i = 0; i < data.length; i++) {
                    $('#tbd').append("<tr><td>" + data[i] + "</td></tr>");
                }
                var script = "<script>$('#btn_factorys').on('click', function () {alert('hello');});</script>";
                $('#viewData').append(script);

                state = true;
            } else {
                state = false;
                $('#viewData').empty();

            }

        });
        
        
       
    }
}
index.init();
