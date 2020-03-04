<?php

require "init.php";
$email=$_GET["email"];
$password=$_GET["password"];
$name=$_GET["name"];
$gender=$_GET["gender"];
$age=$_GET["age"];
$bp=$_GET["bp"];
$weight=$_GET["weight"];
$contact=$_GET["contact"];
$address=$_GET["address"];

$sql="select * from patient_tb where email = '$email' and password = '$password'";
$result=mysqli_query($con,$sql);
if(mysqli_num_rows($result)>0){
	$status="exist";
}
else{
	$sql="insert into patient_tb (email,password,name,gender,age,bp,weight,contact,address) 
	values('$email','$password','$name','$gender','$age','$bp','$weight','$contact','$address');";
	if(mysqli_query($con, $sql)){
		$status="inserted";
	}
	else{
		$status="not inserted";
	}
}
echo json_encode(array("response"=>$status));
mysqli_close($con);

?>