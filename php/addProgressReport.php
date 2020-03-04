<?php

require "init.php";

$patient_id=$_GET["patient_id"];
$weight=$_GET["weight"];
$blood=$_GET["blood"];
$suger=$_GET["suger"];
$albumin=$_GET["albumin"];
$acitone=$_GET["acitone"];
$hbA1c=$_GET["hbA1c"];
$bp1=$_GET["bp1"];
$gb1=$_GET["gb1"];
$bp2=$_GET["bp2"];
$gb2=$_GET["gb2"];
$date=$_GET["date"];

	$sql="insert into progress_report_tb (patient_id,weight,blood,suger,albumin,acitone,hbA1c,bp1,gb1,bp2,gb2,date) 
	values('$patient_id','$weight','$blood','$suger','$albumin','$acitone','$hbA1c','$bp1','$gb1','$bp2','$gb2','$date');";
	if(mysqli_query($con, $sql)){
		$status="inserted";
	}
	else{
		$status="not inserted";
	}

echo json_encode(array("response"=>$status));
mysqli_close($con);

?>