$(function(){ 
    	$('#rTime').datepicker({
    	 	maxDate: 0
    	});
    
    	$.extend($.validator.messages, {
   		 	required: "必填字段",
   		 	number: "必须填写数字",
   		 	maxlength: $.validator.format("请输入一个 长度最多是 {0} 的字符串"),
			minlength: $.validator.format("请输入一个 长度最少是 {0} 的字符串"),
			//min: $.validator.format("不小于 {0} 的字符串"),
		});
		
        $("#Repaymentform").validate();
        
        $("#fineMoney").blur(function(){
        	if($(this).val()!=''){
        		var fineMoney=parseFloat($(this).val());
        		var rCapital=parseFloat($("#rCapital").val());
        		var rInterest=parseFloat($("#rInterest").val());
        		
        		if(fineMoney==0) $("#fineMoney2").val(0);
        		else $("#fineMoney2").val(fineMoney);
        		$("#rMoney").val(fineMoney+rCapital+rInterest);
        	}
        });
        
       $("#fineMoney").blur();
        
        
    });