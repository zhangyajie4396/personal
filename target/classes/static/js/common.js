function showBox(msg,type){
    var tip = msg;
   switch (type){
       case 1:
           tip = tip?tip:"服务器繁忙，请稍后再试。";
           break;
       case 4:
           tip = tip?tip:"设置成功！";
           break;
       case 5:
           tip = tip?tip:"操作失败";
           break;
       case 6:
           tip = tip?tip:"正在加载中，请稍后...";
   }

    ZENG.msgbox.show(tip, type, 3000);

}