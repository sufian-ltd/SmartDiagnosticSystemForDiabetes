<?php

	require "init.php";
	$email=$_GET["email"];
	$password=$_GET["password"];
	$sql="select * from patient_tb where email='$email' and password='$password'";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'email' =>$row['email'],
	  'password'=>$row['password'],'name' =>$row['name'],'gender' =>$row['gender'],'age' =>$row['age'],'bp'=>$row['bp'],'weight'=>$row['weight'],'contact'=>$row['contact'],'address'=>$row['address']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>