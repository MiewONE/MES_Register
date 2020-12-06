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

        $('#btn_position').on('click', function () {
            if (!state) {
                var data = ["1", "2", "3", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장"];
                var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                inputData += "<div id='btn_inputContainer'></div>";
                $('#viewData').append(inputData);
                var inputBtn ="<button class='btn' id='btn_positions'>등록</button>" ;
                inputBtn += "<button class='btn' id='btn_positions_del'>삭제</button>";
                $('#btn_inputContainer').append(inputBtn);
                var text = "<table id='DefaultTable'>";
                text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                text += "<script src='./innerTest.js'></script>";
                
                $('#viewData').append(text);
                // $('#viewData').css('zoom','1');
                $('#thd').append("<tr><th>직위</th></tr>");
                for (var i = 0; i < data.length; i++) {
                    $('#tbd').append("<tr><td>" + data[i] + "</td></tr>");
                }
                state = true;
            } else {
                state = false;
                $('#viewData').empty();

            }

        });
        $('#btn_factory').on('click', function () {
            if (!state) {
                var data = ["1", "2", "3", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장"];
                var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                inputData += "<div id='btn_inputContainer'></div>";
                $('#viewData').append(inputData);
                var inputBtn ="<button class='btn_data' id='btn_factorys'>등록</button>" ;
                inputBtn += "<button class='btn_data' id='btn_factorys_del'>삭제</button>";
                $('#btn_inputContainer').append(inputBtn);
                var text = "<table id='DefaultTable'>";
                text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                text += "<script src='./innerTest.js'></script>";
                
                $('#viewData').append(text);
                // $('#viewData').css('zoom','1');
                $('#thd').append("<tr><th>공장</th></tr>");
                for (var i = 0; i < data.length; i++) {
                    $('#tbd').append("<tr><td>" + data[i] + "</td></tr>");
                }
                state = true;
            } else {
                state = false;
                $('#viewData').empty();

            }

        });
        $('#btn_departmentcode').on('click', function () {
            if (!state) {
                var data = ["1", "2", "3", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장"];
                var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                inputData += "<div id='btn_inputContainer'></div>";
                $('#viewData').append(inputData);
                var inputBtn ="<button class='btn_data' id='btn_departmentcodes'>등록</button>" ;
                inputBtn += "<button class='btn_data' id='btn_departmentcodes_del'>삭제</button>";
                $('#btn_inputContainer').append(inputBtn);
                var text = "<table id='DefaultTable'>";
                text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                text += "<script src='./innerTest.js'></script>";
                
                $('#viewData').append(text);
                // $('#viewData').css('zoom','1');
                $('#thd').append("<tr><th>부서코드</th></tr>");
                for (var i = 0; i < data.length; i++) {
                    $('#tbd').append("<tr><td>" + data[i] + "</td></tr>");
                }
                state = true;
            } else {
                state = false;
                $('#viewData').empty();

            }

        });
        $('#btn_inspectortype').on('click', function () {
            if (!state) {
                var data = ["1", "2", "3", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장", "사장"];
                var inputData = "<input type='text' name='inputDefault_register' id='inputDefault_register'>";
                inputData += "<div id='btn_inputContainer'></div>";
                $('#viewData').append(inputData);
                var inputBtn ="<button class='btn_data' id='btn_inspectortypes'>등록</button>" ;
                inputBtn += "<button class='btn_data' id='btn_inspectortypes_del'>삭제</button>";
                $('#btn_inputContainer').append(inputBtn);
                var text = "<table id='DefaultTable'>";
                text += "<thead id='thd'></thead><tbody id='tbd'</tbody></table>";
                text += "<script src='./innerTest.js'></script>";
                
                $('#viewData').append(text);
                // $('#viewData').css('zoom','1');
                $('#thd').append("<tr><th>사원 구분</th></tr>");
                for (var i = 0; i < data.length; i++) {
                    $('#tbd').append("<tr><td>" + data[i] + "</td></tr>");
                }
                state = true;
            } else {
                state = false;
                $('#viewData').empty();

            }

        });
        
        
       
    }
}
index.init();
