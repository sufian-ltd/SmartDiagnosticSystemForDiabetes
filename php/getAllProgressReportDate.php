<?php

	require "init.php";
	$sql="select id,date from progress_report_tb order by id desc";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'patientId'=>$row['patientId'],'weight' =>$row['weight'],'blood'=>$row['blood'],'suger'=>$row['suger'],'albumin' =>$row['albumin'],'acitone' =>$row['acitone'],'hbA1c' =>$row['hbA1c'],'bp1' =>$row['bp1'],'gb1' =>$row['gb1'],'bp2' =>$row['bp2'],'gb2' =>$row['gb2'],'date' =>$row['date']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>