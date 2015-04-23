$(function(){
/*page begin============================================================*/
    /*jquery函数=====自动加载页码======*/
	$.extend({"pageList":function(){
		var totalPage=$("#totalPageinput").val();
		var pageNum=$("#nowPageinput").val();
		var paginList=$(".paginList");
		if(totalPage<=1) return;
		//加上< 按钮
		paginList.append("<li class='paginItem' id='pagepre'><a><span class='pagepre'></span></a></li>");
		for(var i=0;i<totalPage;i++){
			if((i+1)==pageNum){
				paginList.append("<li class='paginItem pagebtn current' id='page"+(i+1)+"' value='"+(i+1)+"'><a>"+(i+1)+"</a></li>");
			}else if((i+1)!=pageNum)paginList.append("<li class='paginItem pagebtn' id='page"+(i+1)+"' value='"+(i+1)+"'><a>"+(i+1)+"</a></li>");
		}
		//加上> 按钮
		paginList.append("<li class='paginItem' id='pagenxt'><a><span class='pagenxt'></span></a></li>");
	}});
		
	

    /*jquery函数=====跳转页面======*/
	$.extend({"turn2pageNum":function(pageNum){
		$.ajax({
			url: "json/ItemCategory_list",
			data: "inOrOut="+$("#inOrOut").val()+"&pageNum="+pageNum+"&type=1",
			success: function(data){
				var itemCategories=data.itemCategories;
				$("#itemCategoriesList tr").remove();
				var iclist=$("#itemCategoriesList");
				$(itemCategories).each(function (i, value) {
					var appstr="";
					if(value.parentCatgID!=null)  
						appstr="<tr class='odd'>";
					else if(value.parentCatgID==null)
						appstr="<tr>";
						
					appstr=appstr+"<td><input name='check' type='checkbox' value='"+value.catgID+"' /></td>"+
					 "<td>"+value.catgID+"</td><td>"+value.catgName+"</td><td>"+(value.inOrOut==0?"收入":"支出")+"</td>"+
					 "<td>"+(value.parentCatgID==null?"":value.parentCatgID)+"</td>"+
					 "<td><a href='manager/ItemCategory_updateInput?itemCategory.catgID="+value.catgID+"' class='tablelink'>修改</a>"+
	        		 "<a href='manager/ItemCategory_delete?itemCategory.catgID="+value.catgID+"' class='tablelink'> 删除</a>"+
	        		 "</td></tr> ";
	        		iclist.append(appstr);
                });
			}   
	  });
	}});
	$.pageList();
	/*============前一页============*/      
	$(".paginList").on("click", "#pagepre", function() {
		var pageNum=$("#nowPageinput").val();
		if(pageNum==1) return;
		//移除current
		$("#page"+pageNum).removeClass("current");
		pageNum--;
		$.turn2pageNum(pageNum);
		//添加current
		$("#page"+pageNum).addClass("current");  
		$("#nowPageinput").val(pageNum);
	}); 
	
	/*============下一页============*/  
	$(".paginList").on("click", "#pagenxt", function() {
		var totalPage=$("#totalPageinput").val();
		//alert(totalPage);
		var pageNum=$("#nowPageinput").val();
		if(pageNum==totalPage) return;
		//移除current
		$("#page"+pageNum).removeClass("current");
		pageNum++;
		$.turn2pageNum(pageNum); 
		//添加current
		$("#page"+pageNum).addClass("current");   
		$("#nowPageinput").val(pageNum);
	}); 
	
	/*============点击某一页============*/ 
	$(".paginList").on("click", ".pagebtn", function() {
		var pageNum=$(this).val();
		//移除current
		$(".current").removeClass("current");
		//alert(pageNum);
		$.turn2pageNum(pageNum); 
		//添加current
		$("#page"+pageNum).addClass("current");   
		$("#nowPageinput").val(pageNum);
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
	
	$(".inputList").click(function(){
		window.location.href="manager/ItemCategory_list?inOrOut=0";
	});
	
	$(".outputList").click(function(){
		window.location.href="manager/ItemCategory_list?inOrOut=1";
	});
	
	$(".deleteMuti").click(function(){
		var checks=$("[name='check']:checked");
		var str="";  
		checks.each(function(){
			str+=$(this).val()+",";
		});
		str=str.substring(0,(str.length-1));
		//alert(str);
		//var json=JSON.stringify(str);  
		window.location.href="manager/ItemCategory_deleteMultiple?ItemCategoryIDsstr="+str;
	});
});