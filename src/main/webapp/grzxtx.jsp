<%--
  Created by IntelliJ IDEA.
  User: 16477
  Date: 2019/6/3
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>p2p网贷平台</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="css/common.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/user.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <script type="text/javascript" src="script/jquery.min.js"></script>
    <script type="text/javascript" src="script/common.js"></script>
    <script src="script/user.js" type="text/javascript"></script>
    <script type="text/javascript" src="script/BankQuery.js"></script>

</head>
<body>
<header>
    <div class="header-top min-width">
        <div class="container fn-clear"> <strong class="fn-left">咨询热线：400-668-6698<span class="s-time">服务时间：9:00 - 18:00</span></strong>
            <ul class="header_contact">
                <li class="c_1"> <a class="ico_head_weixin" id="wx"></a>
                    <div class="ceng" id="weixin_xlgz" style="display: none;">
                        <div class="cnr"> <img src="images/code.png"> </div>
                        <b class="ar_up ar_top"></b> <b class="ar_up_in ar_top_in"></b> </div>
                </li>
                <li class="c_2"><a href="#" target="_blank" title="官方QQ" alt="官方QQ"><b class="ico_head_QQ"></b></a></li>
                <li class="c_4"><a href="#" target="_blank" title="新浪微博" alt="新浪微博"><b class="ico_head_sina"></b></a></li>
            </ul>
            <ul class="fn-right header-top-ul">
                <li> <a href="index.html" class="app">返回首页</a> </li>
                <li>
                    <div class=""><a href="register.html" class="c-orange" title="免费注册">免费注册</a></div>
                </li>
                <li>
                    <div class=""><a href="login.html" class="js-login" title="登录">登录</a></div>
                </li>
            </ul>
        </div>
    </div>
    <div class="header min-width">
        <div class="container">
            <div class="fn-left logo"> <a class="" href="index.html"> <img src="images/logo.png"  title=""> </a> </div>
            <ul class="top-nav fn-clear">
                <li class="on"> <a href="index.html">首页</a> </li>
                <li> <a href="list.html" class="">我要投资</a> </li>
                <li> <a href="帮助中心.html">安全保障</a> </li>
                <li class="top-nav-safe"> <a href="个人中心首页.html">我的账户</a> </li>
                <li> <a href="公司简介.html">关于我们</a> </li>
            </ul>
        </div>
    </div>
</header>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <div class="credit-ad"><img src="images/clist1.jpg" width="1200" height="96"></div>
        <div id="personal-left" class="personal-left">
            <ul>
                <li class="pleft-cur"><span><a href="个人中心首页.html"><i class="dot dot1"></i>账户总览</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="个人中心-资金记录 .html">资金记录</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="个人中心-投资记录.html">投资记录</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="个人中心-回款计划.html">回款计划</a></span></li>
                <li class=""><span><a href="个人中心-开通第三方1.html"><i class="dot dot02"></i>开通第三方</a> </span> </li>
                <li><span><a href="个人中心-充值1.html"><i class="dot dot03"></i>充值</a></span></li>
                <li class=""><span><a href="个人中心-提现1.html"><i class="dot dot04"></i>提现</a></span></li>
                <li style="position:relative;" class=""> <span> <a href="个人中心-我的红包.html"> <i class="dot dot06"></i> 我的红包 </a> </span> </li>
                <li class=""><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="个人中心-兑换历史.html">兑换历史</a></span></li>
                <li style="position:relative;"> <span> <a href="个人中心-系统消息.html"><i class="dot dot08"></i>系统信息 </a> </span> </li>
                <li><span><a href="个人中心-账户设置.html"><i class="dot dot09"></i>账户设置</a></span></li>
            </ul>
        </div>
        <label id="typeValue" style="display:none;"> </label>
        <script>
            //<![CDATA[
            function showSpan(op){
                $("body").append("<div id='mask'></div>");
                $("#mask").addClass("mask").css("display","block");

                $("#"+op).css("display","block");
            }

            function displaySpan(op){
                $("#mask").css("display","none");
                $("#"+op).css("display","none");
            }
            //]]>
        </script>

        <div class="personal-main">
            <div class="personal-deposit">
                <h3><i>提现</i></h3>
                <form class="layui-form"  method="post" action="/tx"  onsubmit="return yztx()">
                    <input type="hidden" name="form" value="form">
                    <div class="deposit-form" style="margin-top:0px;border-top:0px none;">
                        <h6>填写提现金额</h6>
                        <ul>
                            <li> <span class="deposit-formleft">可用余额：</span> <span class="deposit-formright"> <i>
                <label id="form:blance"> <span id="zhye">111${user.zhye}</span></label>
                </i>元 </span> </li>
                            <li> <span class="deposit-formleft">提现金额：</span> <span class="deposit-formright">

                <input id="money" onblur="tx()"  type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入数字"  class="deposite-txt" maxlength="10"><span id="moneyAlt" style="color: red;"></span>
                元 </span> <span id="actualMoneyErrorDiv"><span id="actualMoney_message" style="display:none" class="error"></span></span> </li>


                            <li style="height: 100px;margin-left: 10px">
                                <span class="deposit-formleft">收款银行卡：</span><div id="Bank"></div>
                            </li>
                            <li>
                                <input type="button"  value="提现" class="btn-depositok" onclick="return txSubmit()">
                            </li>
                        </ul>
                    </div>
                </form>
                <div class="deposit-tip"> 温馨提示：<br>
                    1、用户需在完成身份认证、开通丰付托管账户并绑定银行卡后，方可申请提现；<br>

                    2、工作日当天16:00前提交的提现申请将在当天处理，默认为T+1到账；<br>
                    3、提现金额单次不能超过5W；<br>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $("#form\\:actualMoney").focus(
                function(){
                    $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe"});
                    if($("#form\\:actualMoney").val() == value) {
                        $("#form\\:actualMoney").val("")
                        $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
                    }
                }).blur(
                function(){
                    $(this).css("border","1px solid #D0D0D0");
                    if($("#form\\:actualMoney").val() == "") {
                        $(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal"});
                    }
                })

            function keyUpcheck()
            {
                $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
            }
        </script>
        <div class="clear"></div>
    </div>
</div>


<script type="text/javascript" src="layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单初始赋值
        form.val('example', {
            "username": "贤心" // "name": "value"
            ,"password": "123456"
            ,"interest": 1
            ,"like[write]": true //复选框选中状态
            ,"close": true //开关状态
            ,"sex": "女"
            ,"desc": "我爱 layui"
        })


    });
</script>
<!--网站底部-->
<div id="footer" class="ft">
    <div class="ft-inner clearfix">
        <div class="ft-helper clearfix">
            <dl>
                <dt>关于我们</dt>
                <dd><a href="公司简介.html">公司简介</a><a href="管理团队.html">管理团队</a><a href="网站公告.html">网站公告</a></dd>
            </dl>
            <dl>
                <dt>相关业务</dt>
                <dd><a href="list.html">我要投资</a><a href="我要借款.html">我要借款</a></dd>
            </dl>
            <dl>
                <dt>帮助中心</dt>
                <dd><a href="帮助中心.html">新手入门</a><a href="个人中心首页.html">我的账户</a><a href="list.html">债权转让</a></dd>
            </dl>
            <dl>
                <dt>联系我们</dt>
                <dd><a href="联系我们.html">联系我们</a></dd>
            </dl>
        </div>
        <div class="ft-service">
            <dl>
                <dd>
                    <p><strong>400-660-1268</strong><br>
                        工作日 9:00-22:00<br>
                        官方交流群:<em>12345678</em><br>
                        工作日 9:00-22:00 / 周六 9:00-18:00<br>
                    </p>
                    <div class="ft-serv-handle clearfix"><a class="icon-hdSprite icon-ft-sina a-move a-moveHover" title="亿人宝新浪微博" target="_blank" href="#"></a><a class="icon-hdSprite icon-ft-qqweibo a-move a-moveHover" title="亿人宝腾讯微博" target="_blank" href="#"></a><a class="icon-ft-qun a-move a-moveHover" title="亿人宝QQ群" target="_blank" href="#"></a><a class="icon-hdSprite icon-ft-email a-move a-moveHover mrn" title="阳光易贷email" target="_blank" href="mailto:xz@yirenbao.com"></a></div>
                </dd>
            </dl>
        </div>
        <div class="ft-wap clearfix">
            <dl>
                <dt>官方二维码</dt>
                <dd><span class="icon-ft-erweima"><img src="images/code.png" style="display: inline;"></span></dd>
            </dl>
        </div>
    </div>
    <div class="ft-record">
        <div class="ft-approve clearfix"><a class="icon-approve approve-0 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-1 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a></div>
        <div class="ft-identity">©2015 亿人宝 All rights reserved&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省亿人宝投资管理有限公司&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank" href="http://www.miitbeian.gov.cn/">皖ICP备12345678号-1</a></div>
    </div>
</div>
<script src="script/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="script/datepicker.js" type="text/javascript"></script>
<script type="text/javascript" src="script/CzTx.js"></script>

</body>
</html>

