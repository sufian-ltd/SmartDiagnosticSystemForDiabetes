package com.example.smartdiagnosticsystemfordiabetes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("isUser.php")
    Call<ServerResponse> isUser(@Query("email") String email,@Query("password") String password);

    @GET("registration.php")
    Call<ServerResponse> registration(@Query("email") String email,@Query("password") String password,@Query("name") String name,
    @Query("gender") String gender,@Query("age") String age,@Query("bp") String bp,@Query("weight") String weight,
    @Query("contact") String contact,@Query("address") String address);

    @GET("getUser.php")
    Call<List<UserEntity>> getUser(@Query("email") String email, @Query("password") String password);

    @GET("getDoctors.php")
    Call<List<DoctorEntity>> getDoctors();

    @GET("getAllProgressReport.php")
    Call<List<ProgressReportEntity>> getAllProgressReport();

    @GET("saveProgressReport.php")
    Call<ServerResponse> saveProgressReport(@Query("patientId") int patientId,@Query("weight") String weight,
        @Query("blood") String blood,@Query("suger") String suger,@Query("albumin") String albumin,
        @Query("acitone") String acitone,@Query("hbA1c") String hbA1c,@Query("bp1") String bp1,
        @Query("gb1") String gb1,@Query("bp2") String bp2,@Query("gb2") String gb2,@Query("date") String date);
//
    @GET("getLabTestResult.php")
    Call<List<BiochemistryTestEntity>> getLabTestResult(@Query("tbName") String tbName,@Query("id") int id);
//
    @GET("getDatesByTbName.php")
    Call<List<LabTestEntity>> getDatesByTbName(@Query("tbName") String tbName);
//
    @GET("getAllPrescription.php")
    Call<List<PrescriptionEntity>> getAllPrescription(@Query("patientId") int patientId);
//
    @GET("getAllPrescriptionData.php")
    Call<List<PrescriptionDataEntity>> getAllPrescriptionData(@Query("prescriptionId") int prescriptionId);

    @GET("getAllLabTest.php")
    Call<List<LabTestEntity>> getAllLabTest(@Query("patientId") int patientId);
//
    @GET("makeAppointment.php")
    Call<ServerResponse> makeAppointment(@Query("patientId") int patientId, @Query("doctorId") int doctorId,
                 @Query("patientName") String patientName,@Query("doctorName") String doctorName,
                 @Query("date") String date,@Query("status") String status);
//
    @GET("getFoodPlan.php")
    Call<List<FoodPlanEntity>> getFoodPlan(@Query("patientId") int patientId);
//
//    @GET("order.php")
//    Call<ServerResponse> order(@Query("userId") int userId, @Query("productId") int productId,
//                               @Query("productName") String productName
//            , @Query("qtn") int qtn, @Query("cost") int cost, @Query("orderDate") String orderDate,
//                               @Query("deliveryDate") String deliveryDate, @Query("status") String status);
//    @GET("editProfile.php")
//    Call<ServerResponse> editProfile(@Query("id") int id, @Query("name") String name, @Query("email")
//            String email, @Query("password") String password, @Query("contact") String contact,
//                                     @Query("address") String address);
}
