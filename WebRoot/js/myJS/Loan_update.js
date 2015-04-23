$(function(){ 
    
    	$('#lTime').datetimepicker({
    	 	maxDate: 0
    	});
    	
    	$.extend($.validator.messages, {
   		 	required: "必填字段",
   		 	maxlength: $.validator.format("请输入一个 长度最多是 {0} 的字符串"),
			minlength: $.validator.format("请输入一个 长度最少是 {0} 的字符串"),
		});
		
		 
        
		/*$函数=====获取二级收支类别======
		由于$()二级菜单必须等待一级菜单加载完成才可以加载，故直接放入一级加载的函数的后半部分*/
		$.extend({'parentCatgIDChange':function(){
			$.ajax({
				  url: "json/ItemCategory_secondClassList",
				  data: "inOrOut=1&parentCatgID="+$("#parentCatgID").val(),
				  success: function(data){
				  		var ics=data.itemCategories;
				  		var icID=$("#icID").val();
				  		$("#catgID").html("");
				  		if(ics==''){ alert("无二级类别");return;}
				  		$(ics).each(function (i, value) {  
                    		$("#catgID").append("<option value='"+value.catgID+"'>"+value.catgName+"</option>");
                		});
				  		$("#catgID").val(icID);
				  		$("#icID").val("");
				  },
			});   
		}});
		
		/*$函数=====获取一级收支类别======*/
		$.extend({'InOrOutChange':function(){
			$.ajax({
				  url: "json/ItemCategory_addInput",
				  data: "inOrOut=1&type=1",
				  success: function(data){
				  		var ics=data.itemCategories;
				  		var picID=$("#picID").val();
				  		$("#parentCatgID").html("");
				  		if(ics==''){ alert("无一级类别");return;}
				  		$(ics).each(function (i, value) {
				  				$("#parentCatgID").append("<option value='"+value.catgID+"'>"+value.catgName+"</option>");
                		}); 
				  		$("#parentCatgID").val(picID);
				  		$("#picID").val("");
                		$.parentCatgIDChange();  
				  },
			});   
		}});
		
		$.InOrOutChange(); 
		
		$("#parentCatgID").change(function(){
       		$.parentCatgIDChange();  	/*$函数调用方式*/  
        });
       
       /*$函数=====获取用户的所有账户======*/
		$.extend({'allAccounts':function(){
			if($("#userID").val()=="") {
				alert("请重新登陆！");
				window.location.href="http://localhost:8080/familyFinancial/";
			}
			$.ajax({
				  url: "json/Account_list",
				  data: "userID="+$("#userID").val()+"&type=1",
				  success: function(data){
				  		var accounts=data.accounts;
				  		var uaaccountID=$("#uaAccountID").val();
				  		$("#accountID").html("");
				  		if(accounts==""){ alert("用户没有可以使用的绑定账户");return;}
				  		$(accounts).each(function (i, value) {  
				  			var accounttype="";
				  			var accountName=value.accountName==null?"":value.accountName;
				  			var accountNum=value.accountNum==null?"":value.accountNum;
				  			if(value.type==0) accounttype="现金账户";
				  			else if(value.type==1) accounttype="电子账户";
				  			else if(value.type==2) accounttype="银行账户";
				  			$("#accountID").append("<option value='"+value.accountID+"'>"+accountName+accountNum+"("+accounttype+")</option>");
                		}); 
				  		$("#accountID").val(uaaccountID);
				  },
			});   
		}});
		
	   $.allAccounts();
       $("#Loanform").validate();
       
    }); 