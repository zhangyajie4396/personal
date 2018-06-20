function addUserFun() {
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
}

function batchDelFun() {
    var selections = $("#table").bootstrapTable('getSelections');
    if(selections.length == 0){
        showBox("请至少选一条记录",1);
        return;
    }
}

function editUserFun(row) {
    $('#myModal').modal();
    $('#id').val(row.id);
    $('#username').val(row.username);
    $('#password').val(row.password);

    console.info(row)
    var arr=row.roleId.split(',');
    $('.selectpicker').selectpicker('val', arr);
}

$(function(){

    $(".selectpicker").selectpicker({
        noneSelectedText : '请选择'
    });

    $(window).on('load', function() {
        $('.selectpicker').selectpicker('val', '');
        $('.selectpicker').selectpicker('refresh');
    });
    //下拉数据加载
    $.ajax({
        type : 'get',
        url : "/admin/role/selectAll",
        dataType : 'json',
        success : function(datas) {//返回list数据并循环获取
            var data = datas.data;
            var select = $("#txt_role");
            for (var i = 0; i < data.length; i++) {
                select.append("<option value='"+data[i].id+"'>"
                    + data[i].remark + "</option>");
            }
            $('.selectpicker').selectpicker('val', '');
            $('.selectpicker').selectpicker('refresh');
        }
    });
    
    
    $("#btn_submit").click(function () {

        var url = "/user/saveUser";
        var id =$("#id").val();
        if(id){
            url = "/user/updateUser";
        }

        var user = {
            username:$("#username").val(),
            password : $("#password").val(),
            id:id
        };
        var jsonData = {
            user:user,
            roleIds:$("#txt_role").val()
        };

        $.ajax({
            type : 'post',
            url :url ,
            data:{
                jsonData:JSON.stringify(jsonData)
            },
            success : function(data) {
                if(!data.success){
                    showBox(data.msg, 5);
                    return;
                }else{
                    showBox(data.msg, 4);
                    $("#table").bootstrapTable('refresh');
                }
            }
        });
    })
})


