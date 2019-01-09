var INDEX_CONTAINER = {
    //初始化信息
    init:function () {
        //加载数据
        this.loadDemoList();
    },
    //初始化框架
    initLayout:function(){

    },
    //绑定事件
    bindEvent:function(){

    },
    loadDemoList:function(){
        var url = "main/queryDemoList.do";
        $.ajax({
            type:"post",
            async:true,
            url:url,
            success:function(data){
                console.log(data);
            },
            error:function(){

            }
        });
    }
};

//加载信息
$(function(){
    INDEX_CONTAINER.init();
})