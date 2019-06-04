$(function () {



    $.ajax({
        url:"/bankByUid",
        type:'POST',
        success:function (data) {
            var str = eval(""+data+"");
            var text = "<select lay-filter=\"aihao\">";
            for (var i=0;i<str.length;i++) {
                if(str[i].mrxz==1){
                    text+="<option selected='selected'>"+str[i].bankno.substring(0,4)+"***********"+str[i].bankno.substring(14,str[i].bankno.length)+"</option>";
                }else{
                    text+="<option>"+str[i].bankno.substring(0,4)+"***********"+str[i].bankno.substring(14,str[i].bankno.length)+"</option>";
                }
            }
            text+="</select>";
            $("#Bank").html(text);
            layui.use('form', function(){
                var form = layui.form;
                form.render();
            });
        },
        error:function () {
            console.log("查询银行卡error");
        }
    });



});