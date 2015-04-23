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
         			remote:{
         				url: "json/name_unique",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        name: function() {
					            return $("#catgName").val();
					        },
					        tableName:"ItemCategory",
					        columnName:"catgName",
					    }
         			}
         		},
         	},
         	messages: {
         		"itemCategory.catgName":{
         			required:"请输入收支类别名称",
         			maxlength:"不要超过10个字符",
         			remote:"该名称已经存在",
         		},
         	},
         });
    });