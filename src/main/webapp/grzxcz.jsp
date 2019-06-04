<%--
  Created by IntelliJ IDEA.
  User: 16477
  Date: 2019/6/3
  Time: 10:07
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
    <script type="text/javascript" src="script/jquery-1.7.1.min.js"></script>
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

            $(function(){
                $('.quick-tit').click(function(){

                    $(this).addClass('pay-cur');
                    $(this).siblings().removeClass('pay-cur');
                    $('.quick-main').show();
                    $('.online-main').hide();

                    $(".pay-tipcon").hide();
                    $(".pay-tipcon2").show();

                })

                $('.online-tit').click(function(){

                    $(this).addClass('pay-cur');
                    $(this).siblings().removeClass('pay-cur');
                    $('.quick-main').hide();
                    $('.online-main').show();

                    $(".pay-tipcon2").hide();
                    $(".pay-tipcon").show();
                })
            });
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
        <script>
            //<![CDATA[
            function checkRecharge() {


            }



        </script>
        <div class="personal-main">
            <div class="personal-pay">
                <h3><i>充值</i></h3>
                <div class="quick-pay-wrap">
                    <h4> <span class="quick-tit pay-cur"><em>快捷支付</em></span> </h4>

                    <form  class="layui-form" id="form" name="form" method="post" action="" >
                        <div class="quick-main">
                            <div class="fl quick-info">
                                <div class="info-1" style="width:350px;"> <span class="info-tit">充值金额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span class="info1-input">
                  <input id="czMoney" type="text" onblur="cz()" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入数字"   class="pay-money-txt" maxlength="10" >
                  <em>元</em> </span> <span id="czMoneyAlt" style="color: red;margin-left: 70px"></span><span  class="quick-error"> </span> </div>
                                <div class="info-tips"></div>
                                <div class="info-2" style="width: 700px;height: 120px"> <span class="info-tit">请选择支付银行卡</span>
                                   <div id="Bank">

                                    </div>
                                    <span class="quick-error3" id="bankCardError"></span> </div>
                                <div class="bank-check" id="bank-check2"> <b class="selected" id="bankProtocol1"></b><span class="bank-agree">我同意并接受<a href="#" target="_blank">《亿人宝投资咨询与管理服务电子协议》</a></span> <span class="error" id="bankProtocol_message" style="display:none;margin-top:-3px;">请同意协议内容！</span> </div>
                                <input type="button" name="" value="充值" class="btn-paycz" onclick="return czSubmit()">
                            </div>
                        </div>
                    </form>

                    <div class="online-main" style="display:none;">
                        <form id="recharge" name="recharge" method="post" action="#" target="_blank">
                            <div class="online-mar">
                                <div class="quick-info quick-info-width">
                                    <div class="info-1"> <span class="info-tit">充值金额</span> <span class="info1-input">
                    <input id="recharge:actualMoney" type="text" name="recharge:actualMoney" class="pay-money-txt" maxlength="10" onblur="checkRecharge()" onkeydown="amount(this);keyUpcheck()" onkeyup="amount(this);keyUpcheck()">
                    <em>元</em> </span> <span id="actualMoneyErrorDiv" class="quick-error2"> </span> </div>
                                </div>
                            </div>
                            <div> <span><font style=" color:#848484;font-weight:bold; margin-left:80px; height:32px; line-height:32px; font-size:12px;">亿人宝提醒您：充值前，请核实您的可用支付额度！</font></span> </div>
                            <div class="pay-bank" id="pay-bank">
                                <h6>请选择充值银行</h6>
                                <span id="showpay" style="display:none;">icbc</span>
                                <ul id="paysSpan" style="height:150px;">
                                    <li><img src="images/bank_002.gif" property1="icbc" class="on"><em></em><i></i></li>
                                    <li><img src="images/bank_006.gif" property1="abc"><em></em></li>
                                    <li><img src="images/bank_001.gif" property1="boc"><em></em></li>
                                    <li><img src="images/bank_004.gif" property1="ccb"><em></em></li>
                                    <li><img src="images/bank_008.gif" property1="hxb"><em></em></li>
                                    <li><img src="images/bank_007.gif" property1="comm"><em></em></li>
                                    <li><img src="images/bank_003.gif" property1="cmb"><em></em></li>
                                    <li><img src="images/bank_011.gif" property1="ceb"><em></em></li>
                                    <li><img src="images/bank_015.gif" property1="cncb"><em></em></li>
                                    <li><img src="images/bank_010.gif" property1="cmsb"><em></em></li>
                                    <li><img src="images/bank_012.gif" property1="cgb"><em></em></li>
                                    <li><img src="images/bank_bos.gif" property1="shb"><em></em></li>
                                    <li><img src="images/bccb.gif" property1="bjb"><em></em></li>
                                    <li><img src="images/bank-nsyh.gif" property1="rcb"><em></em></li>
                                    <li><img src="images/bank-xyyh.gif" property1="cib"><em></em></li>
                                </ul>
                                <span class="pay-other"><span class="paytxt">选择其他银行卡</span><i class="paydown"></i></span> </div>
                            <div class="pay-bankstate"> <span class="bankstate-head"><i class="fl">请关注您的充值金额是否超限：</i><i class="fr" id="show-pay-hotLine">工商银行客服热线：95588</i></span>
                                <table>
                                    <tbody>
                                    <tr>
                                        <td>单笔限额（元）</td>
                                        <td>每日限额（元）</td>
                                        <td>需要满足条件</td>
                                        <td>备注</td>
                                    </tr>
                                    <tr>
                                        <td width="15%">5000</td>
                                        <td width="15%">5000</td>
                                        <td width="20%">工银e支付</td>
                                        <td width="50%" rowspan="5">请到中国工商银行各营业网点办理成为个人网上银行客户并开通网上支付功能（静态密码用户进行网上支付如超过累计金额请直接到营业网点申领电子口令卡或USB Key）；</td>
                                    </tr>
                                    <tr>
                                        <td>500</td>
                                        <td>1000</td>
                                        <td>电子口令卡</td>
                                    </tr>
                                    <tr>
                                        <td>2000</td>
                                        <td>5000</td>
                                        <td>短信认证</td>
                                    </tr>
                                    <tr>
                                        <td>50万</td>
                                        <td>100万</td>
                                        <td>电子密码</td>
                                    </tr>
                                    <tr>
                                        <td>100万</td>
                                        <td>100万</td>
                                        <td>U盾</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="bank-check" id="bank-check"> <b class="selected" id="bankProtocol"></b><span class="bank-agree">我同意并接受<a href="/node/Candyprivacypolicy/candyprivacypolicy_tzzxyglfwdzxy" target="_blank">《亿人宝金融投资咨询与管理服务电子协议》</a></span> <span class="error" id="bankProtocol_message" style="display:none;margin-top:-3px;">请同意协议内容！</span> </div>
                            <input type="submit" name="recharge:j_idt96" value="充值" class="btn-paycz" onclick="return getShowPayVal()">
                            <input type="hidden" name="javax.faces.ViewState" id="javax.faces.ViewState">
                        </form>
                    </div>
                    <div class="pay-tipcon" style="display:none;"> <b>充值提示：</b><br>
                        1．亿人宝充值过程免费，不向用户收取任何手续费。<br>
                        2．为了您的账户安全，请在充值前进行身份认证、手机绑定以及交易密码设置。<br>
                        3．您的账户资金将通过丰付支付第三方平台进行充值。<br>
                        4．请注意您的银行卡充值限制，以免造成不便。<br>
                        5．如果充值金额没有及时到账，请联系客服—400-999-8850 </div>
                    <div class="pay-tipcon2"> <b>温馨提示：</b><br>
                        1. 投资人充值过程全程免费，不收取任何手续费。<br>
                        2. 为防止套现，所充资金必须经投标回款后才能提现。<br>
                        3. 使用快捷支付进行充值，可能会受到不同银行的限制，如需大额充值请使用网银充值进行操作。<br>
                        4. 充值/提现必须为银行借记卡，不支持存折、信用卡充值。<br>
                        5. 严禁利用充值功能进行信用卡套现、转账、洗钱等行为，一经发现，将封停账号30天。<br>
                        6. 充值期间，请勿关闭浏览器，待充值成功并返回首页后，所充资金才能入账，如有疑问，请联系客服。<br>
                        7. 充值需开通银行卡网上支付功能，如有疑问请咨询开户行客服。<br>
                    </div>
                </div>
            </div>
            <div class="alert-450 alert-h220" id="alert-rechargeFailture" style="display:none;">
                <div class="alert-title">
                    <h3>登录网上银行充值</h3>
                    <span class="alert-close" onclick="displaySpan('alert-rechargeFailture')"></span></div>
                <div class="alert-main">
                    <form id="rechargeFailtureForm">
                        <p class="msg1"><i class="no-icon"></i><i class="msgtxt">充值失败</i>您可以：<a href="#"><font color="#28A7E1">选择其他银行充值</font></a>或查看<a href="#"><font color="#28A7E1">充值帮助</font></a></p>
                    </form>
                </div>
            </div>
            <div class="clear"></div>
            <div class="alert-400 alert-h220" id="alert-ClickDialog" style="display:none;">
                <div class="alert-title">
                    <h3>消息</h3>
                </div>
                <div class="alert-main">
                    <p class="msg4"> </p>
                    <p class="msg-a"><a class="btn-ok btn-145" onclick="displaySpan('alert-ClickDialog')" href="#">关 闭</a></p>
                </div>
            </div>
            <div class="alert-400 alert-h220" id="alert-unbindMsgDialog" style="display:none;">
                <div class="alert-title">
                    <h3>消息</h3>
                </div>
                <div class="alert-main">
                    <p class="msg4"> </p>
                    <p class="msg-a"><a class="btn-ok btn-145" onclick="displaySpan('alert-unbindMsgDialog')" href="#">关 闭</a></p>
                </div>
            </div>
            <script type="text/javascript">
                $("#recharge\\:actualMoney").val("单笔大于0元");
                var value = "单笔大于0元";
                $("#recharge\\:actualMoney").focus(
                    function(){
                        $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe"});
                        if($("#recharge\\:actualMoney").val() == value) {
                            $("#recharge\\:actualMoney").val("")
                            $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
                        }
                    }).blur(
                    function(){
                        $(this).css("border","1px solid #D0D0D0");
                        if($("#recharge\\:actualMoney").val() == "") {
                            $("#recharge\\:actualMoney").val("单笔大于0元").css("color", "#D0D0D0");
                            $(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal"});
                        }
                    })

                $("#form\\:actualMoney1").val("单笔大于0元");
                $("#form\\:actualMoney1").focus(
                    function(){
                        $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe", "height":"38px"});
                        if($("#form\\:actualMoney1").val() == value) {
                            $("#form\\:actualMoney1").val("");
                            $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial", "height":"38px"});
                        }
                    }).blur(
                    function(){
                        $(this).css("border","1px solid #D0D0D0");
                        if($("#form\\:actualMoney1").val() == "") {
                            $("#form\\:actualMoney1").val("单笔大于0元").css("color", "#D0D0D0");
                            $(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal", "height":"38px"});
                        }
                    })

                $("#form2\\:actualMoney2").val("单笔大于0元");
                $("#form2\\:actualMoney2").focus(
                    function(){
                        $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe", "height":"38px"});
                        if($("#form2\\:actualMoney2").val() == value) {
                            $("#form2\\:actualMoney2").val("")
                            $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial", "height":"38px"});
                        }
                    }).blur(
                    function(){
                        $(this).css("border","1px solid #D0D0D0");
                        if($("#form2\\:actualMoney2").val() == "") {
                            $("#form2\\:actualMoney2").val("单笔大于0元").css("color", "#D0D0D0");
                            $(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal", "height":"38px"});
                        }
                    })

                function keyUpcheck()
                {
                    $(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
                }

                $("#form\\:bankCardNo").val("请输入银行卡号");
                var cardValue = "请输入银行卡号";
                $("#form\\:bankCardNo").focus(
                    function(){
                        $(this).css({"font-size":"14px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe", "color": "rgb(75, 73, 72)"});
                        if($("#form\\:bankCardNo").val() == cardValue) {
                            $("#form\\:bankCardNo").val("")
                            $(this).css({"font-size":"14px","font-weight":"bold","font-family":"Arial"});
                        }
                    }).blur(
                    function(){
                        $(this).css("border","1px solid #D0D0D0");
                        if($("#form\\:bankCardNo").val() == "") {
                            $("#form\\:bankCardNo").val("请输入银行卡号").css("color", "#D0D0D0");
                            $(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal"});
                        }
                    })
            </script>
            <div class="alert-450" id="alert-tyht" style="display:none;">
                <div class="alert-title">
                    <h3>提示信息</h3>
                    <span class="alert-close" onclick="displaySpan('alert-tyht')"></span></div>
                <div class="alert-main" style="margin-bottom: 35px;margin-left: 25px;">
                    <p class="msg4"> 你需要阅读并同意《亿人宝金融投资咨询与管理服务电子协议》 </p>
                </div>
            </div>
        </div>
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

