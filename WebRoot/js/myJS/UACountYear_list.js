gvChartInit();
$(function(){
	  gvChartInit();
      $("#myTable1").gvChart({
	  	chartType: "LineChart",
	    hideTable:false,
	    gvSettings: {
	        vAxis: { title: "金额" },
	        hAxis: { title: "月份" },
	        width: 720,
	        height: 300
	   }
	 });


     $("#myTable2").gvChart({
        chartType: "LineChart",
        hideTable:false,
        gvSettings: {
            vAxis: { title: "金额" },
            hAxis: { title: "月份" },
            width: 720,
            height: 300
        }
     });
     
	
	$(".go").click(function(){
		var role=$("#role").val();	
		var yearv=$("#timeRange").val();
		var userID=$("#userID").val();
		var beginTime=yearv+"-01-01";
		var endTime=yearv+"-12-31";
		if (role==1)
			window.location.href="familyMember/UACountMonth_yearCount?userID="+userID+"&beginTime="+beginTime+"&endTime="+endTime+"&role=1";
		else if(role==2)
			window.location.href="houseHold/UACountMonth_yearCount?userID="+userID+"&beginTime="+beginTime+"&endTime="+endTime+"&role=2";
	});
});