$(function(){
/*search begin===========================================================*/
	$('#beginTimeinput').datetimepicker({
	 	maxDate: 0
	});
	$('#endTimeinput').datetimepicker({
	 	maxDate: 0
	});
	
	$(".go").click(function(){
		//var userID=$("#userID").val();
		var beginTime=$("#beginTimeinput").val();
		var endTime=$("#endTimeinput").val();
		if(beginTime=="") {
			alert("请选择查询的开始时间");
			$("#beginTimeinput").focus();
			return false;
		} 
		if(endTime=="") {
			alert("请选择查询的结束时间");
			$("#endTimeinput").focus();
			return false;
		} 
		$.turn2pageNum(1,beginTime,endTime,1);
	});
/*search end===========================================================*/
/*page begin============================================================*/
    /*jquery函数=====自动加载页码======*/
	$.extend({"pageList":function(){
		var totalCount=$("#totalCountinput").val();
		var totalPage=(totalCount%10)==0?Math.floor(totalCount/10):Math.floor(totalCount/10)+1;
		//alert(totalCount);
		//加载左边页码说明
		var message=$(".message");
		message.empty();
		message.append("共<i class='blue'>"+totalCount+"</i>条记录，共<i>"+totalPage+"</i>页，当前显示第&nbsp;<i class='blue'>1</i>页");
		
		//加载右边页码按钮
		var paginList=$(".paginList");
		$(".paginList li").remove();
		if(totalPage<=1) return;
		//加上< 按钮
		paginList.append("<li class='paginItem' id='pagepre'><a><span class='pagepre'></span></a></li>");
		for(var i=0;i<totalPage;i++){
			if((i+1)==1){
				paginList.append("<li class='paginItem pagebtn current' id='page"+(i+1)+"' value='1'><a>1</a></li>");
			}else if((i+1)!=1)
				paginList.append("<li class='paginItem pagebtn' id='page"+(i+1)+"' value='"+(i+1)+"'><a>"+(i+1)+"</a></li>");
		}
		//加上> 按钮
		paginList.append("<li class='paginItem' id='pagenxt'><a><span class='pagenxt'></span></a></li>");
	}});
	
	

    /*jquery函数=====跳转页面======*/
	$.extend({"turn2pageNum":function(pageNum,beginTime,endTime,pageType){
		$.ajax({
			url: "json/UsualActivity_list",
			data: "userID="+$("#userID").val()+"&beginTime="+beginTime+"&endTime="+endTime+"&pageNum="+pageNum+"&type=1",
			success: function(data){
				var uass=data.uass;
				$("#uaList tr").remove();
				var ualist=$("#uaList");
				var userID=data.userID;
				$(uass).each(function (i, value) {
					var appstr="";
					appstr="<tr><td><input name='check' type='checkbox' value='"+value.usualActivityID+"' /></td>"+
					 "<td>"+value.usualActivityID+"</td><td>"+(value.inOrOut==0?"收入":"支出")+"</td><td>"+value.userID+"</td><td>"+value.accountID+"</td>"+
					 "<td>"+value.catgID+"</td><td>"+value.money+"</td><td>"+value.time+"</td><td>"+(value.note==null?"":value.note)+"</td>"+
					 "<td><a href='familyMember/UsualActivity_updateInput?ua.usualActivityID="+value.usualActivityID+"' class='tablelink'>修改</a>"+
	        		 "<a href='familyMember/UsualActivity_delete?ua.usualActivityID="+value.usualActivityID+"&userID="+userID+"' class='tablelink'> 删除</a>"+
	        		 "</td></tr> ";
	        		ualist.append(appstr);
                });
                //移除current
				$(".current").removeClass("current");
				//alert(pageNum);
				//添加current
				$("#page"+pageNum).addClass("current"); 
				//alert(data.totalCount);
				$("#totalCountinput").val(data.totalCount); 
				$("#nowPageinput").val(pageNum);
				$("#beginTime").val(beginTime);
				$("#endTime").val(endTime);
				if(pageType==1) $.pageList();
			}   
	  });
	}});
	
	$.pageList();
/*==============根据日期查询begin=============================*/	
	/*============查询当天的所有收支============*/ 
	$(".dayList").click(function(){
		var beginTime=new Date();
  		var endTime=new Date();
  		var month=(beginTime.getMonth()+1);
  		month=(month<=9)?("0"+month):month;
  		var date=beginTime.getDate();
  		date=(date<=9)?("0"+date):date;
  		beginTime =beginTime.getFullYear() +"-"+month+"-" + date+" 00:00";
  		
  		month=(endTime.getMonth()+1);
  		month=(month<=9)?("0"+month):month;
  		date=endTime.getDate();
  		date=(date<=9)?("0"+date):date;
  		endTime =endTime.getFullYear() +"-"+month+"-" + date+" 23:59";
		$.turn2pageNum(1,beginTime,endTime,1);
		
	});
	
	/*============查询当周的所有收支============*/ 
	$(".weekList").click(function(){
   		var now=new Date();
  		var beginTime=new Date();
  		var endTime=new Date();
  		var n=now.getDay();
  		beginTime.setDate(now.getDate()-n+1);
  		endTime.setDate(now.getDate()-n+7);
  		if(n==0){
  			beginTime.setDate(now.getDate()-6);
  	  		endTime.setDate(now.getDate()-n);
  		}
  		var month=(beginTime.getMonth()+1);
  		month=(month<=9)?("0"+month):month;
  		var date=beginTime.getDate();
  		date=(date<=9)?("0"+date):date;
  		beginTime =beginTime.getFullYear() +"-"+month+"-" + date+" 00:00";
  		 
  		month=(endTime.getMonth()+1);
  		month=(month<=9)?("0"+month):month;
  		date=endTime.getDate();
  		date=(date<=9)?("0"+date):date;
  		endTime =endTime.getFullYear() +"-"+month + "-" + date+" 23:59"; 
		//alert(beginTime);alert(endTime);
		$.turn2pageNum(1,beginTime,endTime,1);
	});
	
	/*============查询当月的所有收支============*/ 
	$(".monthList").click(function(){
		var date=new Date();
		var year=date.getFullYear();
		var month=date.getMonth()+1;
		month=(month<=9)?("0"+month):month;
		//alert(month);
		var beginTime = year +"-" + month + "-01 00:00";  
        var day = new Date(year,month,0); 
        day=day.getDate();
        day=(day<=9)?("0"+day):day;
        var endTime = year + "-" + month + "-" + day+" 23:59";//获取当月最后一天日期   
        //alert(beginTime);alert(endTime); 
       	$.turn2pageNum(1,beginTime,endTime,1);
	});
/*==============根据日期查询end=============================*/		

/*page begin============================================================*/	
	/*============上一页：因为新append出来的元素无法直接绑定事件，
	要求用on函数或live函数，其中on函数用法较特别，查阅api文档===========*/ 
	$(".paginList").on("click", "#pagepre", function() {
		var beginTime=$("#beginTime").val();
		var endTime=$("#endTime").val();
		var pageNum=$("#nowPageinput").val();
		if(pageNum==1) return;
		pageNum--;
		$.turn2pageNum(pageNum,beginTime,endTime,0);
	});
	
	/*============下一页============*/  
	$(".paginList").on("click", "#pagenxt", function() {
		var beginTime=$("#beginTime").val();
		var endTime=$("#endTime").val();
		var totalCount=$("#totalCountinput").val();
		var totalPage=(totalCount%10)==0?Math.floor(totalCount/10):Math.floor(totalCount/10)+1;
		var pageNum=$("#nowPageinput").val();
		//alert(pageNum==totalPage);
		if(pageNum==totalPage) return;
		pageNum++;
		$.turn2pageNum(pageNum,beginTime,endTime,0); 
	}); 
	
	/*============点击某一页============*/ 
	$(".paginList").on("click", ".pagebtn", function() {
		var beginTime=$("#beginTime").val();
		var endTime=$("#endTime").val();
		var pageNum=$(this).val();
		var pageNow=$("#nowPageinput").val();
		if(pageNum==pageNow) return false;
		$.turn2pageNum(pageNum,beginTime,endTime,0);
	});

/*page end============================================================*/
	
	$("#allChecks").click(function(){
		var checks=$("[name='check']");
		checks.each(function()
		{
			var flag=$(this).prop("checked");
			$(this).prop("checked",!flag);
		});
	});
	
});