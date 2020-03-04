<?php

	require "init.php";
	$sql="select * from doctor_tb";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'name' =>$row['name'],'available' =>$row['available'],'qualification' =>$row['qualification'],'fee'=>$row['fee']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>