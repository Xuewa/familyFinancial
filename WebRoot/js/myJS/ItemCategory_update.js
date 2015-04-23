$(function(){ 
       $("#inOrOut").change(function(){
       		$.ajax({
				  url: "json/ItemCategory_addInput",
				  data: "inOrOut="+$("#inOrOut").val()+"&type=1",
				  success: function(data){
				  		var ics=data.itemCategories;
				  		$("#parentCatgID").html("");
				  		$("#parentCatgID").append("<option value=''>无</option>");
				  		$(ics).each(function (i, value) {  
                    		$("#parentCatgID").append("<option value='"+value.catgID+"'>"+value.catgName+"</option>");
                		});  
				  },
			});
       })
       
         $('#ItemCategoryform').validate({
         	rules: {
         		"itemCategory.catgName":{
         			required:true,
         			maxlength:10,
         			
         		},
         	},
         	messages: {
         		"itemCategory.catgName":{
         			required:"请输入收支类别名称",
         			maxlength:"不要超过10个字符",
         			
         		},
         	},
         });
         
         $('.btn').click(function(){
         	var old=$('#oldinOrOut').val();
         	var newval=$("#inOrOut").val();
         	//alert(old);alert(newval);
         	if(old!=newval) $('#parentChange').val(1);
         	else{
         		old=$('#oldparentCatgID').val();
         		alert(old);
         		newval=$("#parentCatgID").val();
         		if(old!=newval) $('#parentChange').val(1);
         		else $('#parentChange').val(0);
         	}
         });
    });