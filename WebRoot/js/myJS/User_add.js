$(function(){ 
       $('#birthday').datepicker({
           maxDate:0,
        });
        
        
       $('#Userform').validate({
       		rules: {
       			"user.userName": {
       				required: true,
       				minlength:2,
       				maxlength:6,
       				remote: {
					    url: "json/name_unique",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        name: function() {
					            return $("#userName").val();
					        },
					        tableName:"licaiuser",
					        columnName:"userName",
					    }
					}
       				
       			},
       			
       			"user.password": {
       				required:true,
       				rangelength:[6,6],
       			},
       			"user.sex": {
       				required: true,
       			},
       			"user.name": {
       				required: true,
       				minlength:2,
       				remote: {
					    url: "json/name_unique",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        name: function() {
					            return $("#name").val();
					        },
					        tableName:"licaiuser",
					        columnName:"name",
					    }
					}
       			},
       			"user.birthday": {
       				required: true,
       			},
       			"user.mobile": {
					required: true,
					rangelength:[11,11],
					remote: {
					    url: "json/name_unique",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        name: function() {
					            return $("#mobile").val();
					        },
					        tableName:"licaiuser",
					        columnName:"mobile",
					    }
					}
				},
				"user.email": {
					required: true,
					email:true,
					remote: {
					    url: "json/name_unique",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        name: function() {
					            return $("#email").val();
					        },
					        tableName:"licaiuser",
					        columnName:"email",
					    }
					}
				},
				"user.id": {
					required: true,
					rangelength:[18,18],
					remote: {
					    url: "json/name_unique",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        name: function() {
					            return $("#id").val();
					        },
					        tableName:"licaiuser",
					        columnName:"id",
					    }
					}
				},
				"user.relation": {
					required:true,
				},
			},
			messages: {
       			"user.userName": {
       				required:"请输入用户名",
       				minlength:"用户名不少于2个字符",
       				maxlength:"用户名不多于6个字符",
       				remote:"用户名已存在",
       			},
       			"user.password": {
       				required:"请输入密码",
       				rangelength:"密码由6个字符组成",
       			},
       			"user.sex": {
       				required: "必填",
       			},
       			"user.name": {
       				required: "请输入姓名",
       				minlength:"姓名不少于2个字符",
       				remote:"姓名已存在",
       			},
       			"user.birthday": {
       				required: "请输入出生日期",
       			},
       			"user.mobile": {
					required: "请输入联系方式",
					rangelength:"手机号码有11位",
					remote:"联系方式已存在",
				},
				"user.email": {
					required:"请输入email",
					email:"email格式不对",
					remote:"email已存在",
				},
				"user.id": {
					required: "请输入身份证号码",
					rangelength: "身份证号码有18位",
					remote:"身份证已存在",
				},
				"user.relation": {
					required:"请输入关系",
				},
			},
       });
   });