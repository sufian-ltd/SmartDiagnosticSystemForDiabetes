<?php

	require "init.php";
	$patientId=$_GET["patientId"];
	$sql="select * from food_plan_tb where patientId='$patientId'";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'patientId' =>$row['patientId'],
	  'plan'=>$row['plan']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>