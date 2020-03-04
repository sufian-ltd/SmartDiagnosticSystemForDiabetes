<?php

	require "init.php";
	$tbName=$_GET["tbName"];

	$sql="select * from $tbName";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'date' =>$row['date']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>