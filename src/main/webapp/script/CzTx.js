function tx() {
    //获取用户输入的金额
   var money = parseFloat($("#money").val());
   //获取用户账户余额
   var zhye = parseFloat($("#zhye").text());
    if(money>zhye||money>50000){
        $("#money").val(" ");
    }
}
function txSubmit(){
    if($("#money").val().length<=0){
        $("#moneyAlt").text("请输入提现金额，最少为1，最多为5W");
        return false;
    }
    else if(parseInt($("#money").val())==0){
        $("#moneyAlt").text("提现金额最少为1，最多为5W");
        return false;
    }
    $("#moneyAlt").text(" ");
    $.ajax({
        url:'/tx',
        type:'post',
        data:{money:$("#money").val()},
        success:function (data) {
            alert(data);
            location.href='grzxtx.jsp'
        },
        error:function () {
            console.log("提现提交错误");
        }
    });
}







function cz() {
    //获取用户输入的金额
    var money = parseFloat($("#czMoney").val());
    if (money > 50000) {
        $("#czMoney").val(" ");
    }
}
function czSubmit() {

    if($("#czMoney").val().length<=0){
        $("#czMoneyAlt").text("  请输入充值金额，最少为1，最多为5W");
        return false;
    }
    else if(parseInt($("#czMoney").val())==0){
        $("#czMoneyAlt").text("  充值金额最少为1，最多为5W");
        return false;
    }
    $("#czMoneyAlt").text(" ");
    $.ajax({
        url:'/cz',
        type:'post',
        data:{money:$("#czMoney").val()},
        success:function (data) {
            alert(data);
            location.href='grzxcz.jsp'
        },
        error:function () {
            console.log("充值提交错误");
        }
    });
}

