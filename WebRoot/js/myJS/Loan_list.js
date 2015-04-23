$(function(){
	$("#allChecks").click(function(){
		var checks=$("[name='check']");
		checks.each(function()
		{
			var flag=$(this).prop("checked");
			$(this).prop("checked",!flag);
		});
	});
	
	
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
	$.extend({"turn2pageNum":function(pageNum){
		$.ajax({
			url: "json/Loan_list",
			data: "&pageNum="+pageNum+"&type=1",
			success: function(data){
				var loans=data.loans;
				$("#loanList tr").remove();
				var loanlist=$("#loanList");
				var userID=data.userID;
				$(loans).each(function (i, value) {
					var appstr="";
					appstr="<tr><td><input name='check' type='checkbox' value='"+value.loanID+"' /></td>"+
					 "<td>"+value.loanID+"</td><td>"+value.accountID+"</td><td>"+value.capital+"</td><td>"+value.periodInterest+"</td>"+
					 "<td>"+value.periodMoney+"</td><td>"+value.LPeriod+"</td><td>"+value.LMoney+"</td><td>"+value.LTime+"</td>"+
					 "<td>"+value.periodTime+"月</td><td>"+value.catgID+"</td><td>"+(value.note==null?"":value.note)+"</td>";
					 //status
					 if(value.status==0) appstr+="<td>未还款</td>";
					 else if(value.status==1) appstr+="<td>还款中</td>";
					 else if(value.status==2) appstr+="<td>已还清</td>";
					 //操作
					 if(value.status==0) appstr+="<td><a href='houseHold/Loan_delete?loan.loanID="+value.loanID+"' class='tablelink'> 删除</a>"+
					 "<a href='houseHold/Repayment_add.jsp' class='tablelink'> 修改</a>";
					 if(value.status!=2) appstr+="<a href='houseHold/Repayment_addInput?repayment.loanID="+value.loanID+"' class='tablelink'> 还款</a>";
	        		 appstr+="<a href='houseHold/Repayment_list?repayment.loanID="+value.loanID+"' class='tablelink'> 查看还款记录</a></td></tr>";
		        
	        		 loanlist.append(appstr);
                });
                //移除current
				$(".current").removeClass("current");
				//alert(pageNum);
				//添加current
				$("#page"+pageNum).addClass("current"); 
				//alert(data.totalCount);
				$("#totalCountinput").val(data.totalCount); 
				$("#nowPageinput").val(pageNum);
			}   
	  });
	}});
	
	$(".paginList").on("click", "#pagepre", function() {
		var pageNum=$("#nowPageinput").val();
		if(pageNum==1) return;
		pageNum--;
		$.turn2pageNum(pageNum);
	});
	
	/*============下一页============*/  
	$(".paginList").on("click", "#pagenxt", function() {
		
		var totalCount=$("#totalCountinput").val();
		var totalPage=(totalCount%10)==0?Math.floor(totalCount/10):Math.floor(totalCount/10)+1;
		var pageNum=$("#nowPageinput").val();
		//alert(pageNum==totalPage);
		if(pageNum==totalPage) return;
		pageNum++;
		$.turn2pageNum(pageNum); 
	}); 
	
	/*============点击某一页============*/ 
	$(".paginList").on("click", ".pagebtn", function() {
		var pageNum=$(this).val();
		var pageNow=$("#nowPageinput").val();
		if(pageNum==pageNow) return false;
		$.turn2pageNum(pageNum);
	});
	
	$.pageList();
});