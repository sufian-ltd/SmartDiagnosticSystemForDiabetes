<?php

	require "init.php";
	$patientId=$_GET["patientId"];
	$sql="select * from test_report_tb where patientId='$patientId'";
	$result=mysqli_query($con,$sql);
	$response=array();
	while ($row=mysqli_fetch_array($result)) {
	  array_push($response,array('id'=>$row['id'],'patientId'=>$row['patientId'],'prescriptionId' =>$row['prescriptionId'],'biochemistry'=>base64_encode($row['biochemistry']),'immunology'=>base64_encode($row['immunology']),'blood' =>base64_encode($row['blood']),'hormone' =>base64_encode($row['hormone']),'digestiveSystem' =>base64_encode($row['digestiveSystem']),'stressAdrenalFatigue' =>base64_encode($row['stressAdrenalFatigue']),'microbiology' =>base64_encode($row['microbiology']),'mineralDeficiency' =>base64_encode($row['mineralDeficiency']),'eco' =>base64_encode($row['eco']),'ecg' =>base64_encode($row['ecg']),'date' =>$row['date']));
	}
	echo json_encode($response);
	mysqli_close($con);

?>