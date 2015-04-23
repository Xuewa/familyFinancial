$(function(){
	gvChartInit();
    $("#myTable1").gvChart({
       chartType: "PieChart",
       hideTable:false,
       gvSettings: {
            vAxis: { title: "类别" },
            hAxis: { title: "金额" },
            width: 720,
            height: 300
       }
    });


     $("#myTable2").gvChart({
        chartType: "PieChart",
        hideTable:false,
        gvSettings: {
            vAxis: { title: "类别" },
            hAxis: { title: "金额" },
            width: 720,
            height: 300
        }
     });
     
     $("#myTable3").gvChart({
         chartType: "PieChart",
         hideTable:false,
         gvSettings: {
             vAxis: { title: "类别" },
             hAxis: { title: "金额" },
             width: 720,
             height: 300
         }
      });
     
     $("#myTable4").gvChart({
         chartType: "PieChart",
         hideTable:false,
         gvSettings: {
             vAxis: { title: "类别" },
             hAxis: { title: "金额" },
             width: 720,
             height: 300
         }
      });
     
     $("#myTable5").gvChart({
         chartType: "PieChart",
         hideTable:false,
         gvSettings: {
             vAxis: { title: "类别" },
             hAxis: { title: "金额" },
             width: 720,
             height: 300
         }
      });
	
	$('#timeRange').simpleCanleder();
	
	$(".go").click(function(){
		
		if($("#timeRange").val()=="") {
			alert("请选择查询的月份");
			$("#timeRange").focus();
			return false;
		} 
		var monthv=$("#timeRange").val().replace("-",",");
		var beginTime=monthv+",01";
		beginTime=beginTime.replace(",","-").replace(",","-");
		var date=new Date(beginTime);
		var year=date.getFullYear();
		var month=date.getMonth()+1;
        var day = new Date(year,month,0); 
        day=day.getDate();
        day=(day<=9)?("0"+day):day;
		var endTime=monthv+","+day;
		endTime=endTime.replace(",","-").replace(",","-");
		var userID=$("#userID").val();
		var role=$("#role").val();	
		//alert(role);
		if (role==1)
			window.location.href="familyMember/UACountMonth_monthCount?userID="+userID+"&beginTime="+beginTime+"&endTime="+endTime+"&role=1";
		else if(role==2)
			window.location.href="houseHold/UACountMonth_monthCount?userID="+userID+"&beginTime="+beginTime+"&endTime="+endTime+"&role=2";
	});
});