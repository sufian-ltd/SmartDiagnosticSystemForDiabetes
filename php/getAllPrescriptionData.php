<?php

	require "init.php";
	$prescriptionId=$_GET["prescriptionId"];
	$sql="select * from prescription_data_tb where prescriptionId='$prescriptionId'";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'prescriptionId'=>$row['prescriptionId'],'medicine' =>$row['medicine'],'time1'=>$row['time1'],'day1'=>$row['day1'],'eatTime' =>$row['eatTime']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>