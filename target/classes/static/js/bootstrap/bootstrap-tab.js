/**
 * 判断是否存在指定的标签页
 * @param tabMainName
 * @param tabName
 * @returns {Boolean}
 */
function checkTabIsExists(tabMainName, tabName){
    var tab = $("#"+tabMainName+" > #tab_li_"+tabName);
    //console.log(tab.length)
    return tab.length > 0;
}

function closeTab (button) {

    //通过该button找到对应li标签的id
    var li_id = $(button).parent().parent().attr('id');
    var id = li_id.replace("tab_li_","");

    //如果关闭的是当前激活的TAB，激活他的前一个TAB
    if ($('li[class="active"]').attr('id') == li_id) {
        $('li[class="active"]').prev().find("a").click();
    }

    //关闭TAB
    $("#" + li_id).remove();
    $("#tab_content_" + id).remove();
};

function addTabs() {
    $('.tt').on('click','a',function(e,b){

        options = JSON.parse($(this).attr("opt"))
        var exists = checkTabIsExists("deviceulid", options.resourceName);
        if(exists){
            $("#tab_a_"+options.resourceName).click();
        } else {

            $("#deviceulid").append('<li id="tab_li_'+options.resourceName+'"><a href="#tab_content_'+options.resourceName+'" data-toggle="tab" id="tab_a_'+options.resourceName+'"><button class="close closeTab" type="button" onclick="closeTab(this);">×</button>'+options.resourceName+'</a></li>');

            //固定TAB中IFRAME高度
            mainHeight = $(document.body).height() - 50;

            var content = '';
            if(options.content){
                content = option.content;
            } else {
                content = '<iframe src="' + options.resourceUrl + '" style="padding: 10px; width:100%;" height="'+mainHeight+'px" frameborder="0" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>';
            }
            $(".tab-content").append('<div id="tab_content_'+options.resourceName+'" role="tabpanel" class="tab-pane" id="'+options.resourceName+'">'+content+'</div>');
            $("#tab_a_"+options.resourceName).click();
        }

    });
}

$(function(){
    $.ajax({
        type: "GET",
        url: "/admin/resource/findResource",
        dataType: "json",
        success: function(data){
            var arr = data.data;
            var lis = $("#menu").find("li");
            for(var i=0;i<arr.length;i++){
                var obj = arr[i];
                for(var j=0;j<lis.length;j++){
                    var li = lis[j];
                    if(obj.resourceName == $(li).attr("name")){
                        $(li).show();
                        var div = $(li).find("div");
                        $(obj.children).each(function(item,child){
                            $(div).append($("<li class='tt'><a href='javascript:void(0)' opt='"+JSON.stringify(child)+"'>"+child.resourceName+"</a></li>"));
                        });
                        continue;
                    }
                }
            }
            addTabs();
        }
    })


    
})


