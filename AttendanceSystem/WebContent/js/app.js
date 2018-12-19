var url = "/AttendanceSystem";
function record(studentId) {
	var date = $("#date").val();
	if(!date){
		alert("请选择日期");
		return;
	}
	date = new Date(date);
	date = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	
	var status = $("#"+studentId+"-status").val();
	window.location.href=url+"/TeacherServlet?method=record&studentId="+studentId+"&date="+date+"&status="+status;
}