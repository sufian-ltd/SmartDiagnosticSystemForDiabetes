<?php

require "init.php";

$patientId=$_GET["patientId"];
$doctorId=$_GET["doctorId"];
$patientName=$_GET["patientName"];
$doctorName=$_GET["doctorName"];
$date=$_GET["date"];
$status=$_GET["status"];

	$sql="insert into appointment_tb (patientId,doctorId,patientName,doctorName,date,status) 
	values('$patientId','$doctorId','$patientName','$doctorName','$date','$status');";
	if(mysqli_query($con, $sql)){
		$status="inserted";
	}
	else{
		$status="not inserted";
	}

echo json_encode(array("response"=>$status));
mysqli_close($con);

?>