<?php

	require "init.php";
	$patientId=$_GET["patientId"];
	$sql="select * from prescription_tb where patientId='$patientId' order by id desc";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'problem'=>$row['problem'],'patientId' =>$row['patientId'],'date'=>$row['date'],'nextDate'=>$row['nextDate'],'advise' =>$row['advise']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>