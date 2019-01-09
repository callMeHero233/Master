$(function(){
    //
    ERR_CONTAINER.init();
})


var ERR_CONTAINER = {
    //初始化
    init:function(){
        //绑定事件
        this.bindEvent();
    },
    //绑定事件
    bindEvent:function(){

        //显示异常信息事件
        $("#errContainer").find(".showDetailedInfo").on("click",function(){
            var errMsgEle = ' <div class = "errMsgEle" style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">\n'
                            + ' <div>' + $("#errContainer .errMsgContent").val() +'</div>\n'
                            + '</div>';
            //异常信息展示
            layer.open({
                type: 1
                ,title: "异常信息"
                ,closeBtn: false
                ,area: '900px;'
                ,shade: 0.8
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['关闭']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: errMsgEle
                ,success: function(layero){
                    return;
                }
            });
            //标题居中
            $(".layui-layer-title").css("text-align","center");
        })
    }
};