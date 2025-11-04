package TestPackage;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.*;

public class FirstClass {

	private static final String BASE_URL = "https://healthapp.yaksha.com/api";
	private static String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjdXJyZW50VXNlciI6IntcIlVzZXJJZFwiOjEsXCJFbXBsb3llZUlkXCI6MSxcIlVzZXJOYW1lXCI6XCJhZG1pblwiLFwiUGFzc3dvcmRcIjpcIlwiLFwiRW1haWxcIjpcImFkbWluQG1uay5jb21cIixcIkNyZWF0ZWRCeVwiOjEsXCJDcmVhdGVkT25cIjpcIjIwMTctMDctMTNUMTU6NTE6NTIuNjU3XCIsXCJNb2RpZmllZEJ5XCI6MSxcIk1vZGlmaWVkT25cIjpcIjIwMTktMDgtMjlUMTY6MTY6MDEuODQzXCIsXCJSb2xlc1wiOltdLFwiSXNBY3RpdmVcIjp0cnVlLFwiTmVlZHNQYXNzd29yZFVwZGF0ZVwiOmZhbHNlLFwiRW1wbG95ZWVcIjpudWxsLFwiTGFuZGluZ1BhZ2VSb3V0ZUlkXCI6bnVsbH0iLCJleHAiOjE3NjIzMjUxNjgsImlzcyI6ImxvY2FsaG9zdCIsImF1ZCI6ImxvY2FsaG9zdCJ9.z7cM8mSoDHeuvnEMDmBAzQs7ndVKKT5njE0mdecACZs";
	
	static void getAllStocks()
	{
		String endpoint="/PharmacyStock/AllStockDetails";
		String url=BASE_URL+endpoint;
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);		
		//response.then().log().body();
		List<Map<String,Object>> mm=response.jsonPath().getList("Results");
		System.out.println(mm);
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getStatusLine());
//		String ss=response.getStatusLine();
//		String ss1[]=ss.split(" ",3);
//		System.out.println(ss1[2]);
//		
		
		List<Map<String, Object>> results = mm;
//		for(Map<String, Object> m:mm)
//		{
//			System.out.println(m.get("ItemId"));
//			System.out.println(m.get("ItemName"));
//			System.out.println(m.get("GenericName"));
//		}
//		results.forEach(result -> {
//			Assert.assertNotNull(result.get("ItemId"), "ItemId should not be null.");
//			Assert.assertNotNull(result.get("ItemName"), "ItemName should not be null.");
//			Assert.assertNotNull(result.get("GenericName"), "GenericName should not be null.");
//		});
		//System.out.println("passed");
	}
	static void getMainStore()
	{
		String endpoint="/PharmacySettings/MainStore";
		String url=BASE_URL+endpoint;
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		//response.then().log().body();
		Map<String,Object> mm=response.jsonPath().getMap("Results");
		System.out.println(mm);
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getStatusLine());
//		String ss=response.getStatusLine();
//		String ss1[]=ss.split(" ",3);
//		System.out.println(ss1[2]);
//		Map<String, Object> results = mm;
//		for(Map.Entry<String,Object> m:mm.entrySet())
//		{
//			System.out.println(mm.get("StoreId"));
//		}
//		Integer storeId = (Integer) results.get("StoreId");
//		Assert.assertNotNull(storeId, "StoreId should not be null.");
//		System.out.println("passed");
//
	}
	static void getRequisitionByDateRange()
	{
		String fromDate = "2020-01-01";
		String toDate = "2024-11-19";
		String endpoint="/DispensaryRequisition/Dispensary/1?FromDate=" + fromDate + "&ToDate=" + toDate;		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String,Object>> mm=response.jsonPath().getList("Results.requisitionList");
		System.out.println(mm);
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getStatusLine());
//		String ss=response.getStatusLine();
//		String ss1[]=ss.split(" ",3);
//		System.out.println(ss1[2]);
//		List<Map<String, Object>> requisitionList = mm;
//		List<Integer> requisitionIds = requisitionList.stream()
//				.map(requisition -> (Integer) requisition.get("RequisitionId")).collect(Collectors.toList());
//		Set<Integer> uniqueRequisitionIds = new HashSet<>(requisitionIds);
//		System.out.println(uniqueRequisitionIds);
//		Assert.assertEquals(uniqueRequisitionIds.size(), requisitionIds.size(), "RequisitionIds should be unique.");
//
//		// 4. Validate that RequisitionNo and RequisitionStatus are not null
//		requisitionList.forEach(requisition -> {
//			Assert.assertNotNull(requisition.get("RequistionNo"), "RequistionNo should not be null.");
//			Assert.assertNotNull(requisition.get("RequisitionStatus"), "RequisitionStatus should not be null.");
//		});
//
//		System.out.println("passed");
	}
	static void getPatientConsumptions() //null value is returning
	{
	String endpoint="/PatientConsumption/PatientConsumptions";
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> patientConsumptions = response.jsonPath().getList("Results");		
		System.out.println(patientConsumptions);
//		for(Map<String,Object> mm:patientConsumptions)
//		{
//			System.out.println(mm.get("PatientId"));
//			
//		}
		//https://healthapp.yaksha.com/api/PatientConsumption/PatientConsumptions
		//https://healthapp.yaksha.com/api/PatientConsumption/PatientConsumptions
		
//		for (Map<String, Object> patientConsumption : patientConsumptions) {
//			Assert.assertNotNull(patientConsumption.get("PatientId"), "PatientId should not be null.");
//			Assert.assertNotNull(patientConsumption.get("HospitalNo"), "HospitalNo should not be null.");}
//		System.out.println("Passed");
	}
	static void getPatientConsumptionInfoByPatientIdAndVisitId() //Null Value is returining
	{
		String patientId = "114";
		String patientVisitId = "53";
		String endpoint="/PatientConsumption/PatientConsumptionInfo?patientId="+ patientId + "&patientVisitId=" + patientVisitId;		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
    	List<Map<String,Object>> mm=response.jsonPath().getList("Results.PatientConsumption");
		System.out.println(mm);
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getStatusLine());
//		String ss=response.getStatusLine();
//		String ss1[]=ss.split(" ",3);
//		System.out.println(ss1[2]);

	}
	static void getBillingSchemeBySchemeId()
	{
		String schemeId = "4";
		
		String endpoint="/PatientConsumption/PharmacyIpBillingScheme?schemeId="+schemeId;		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		Map<String, Object> billingScheme = response.jsonPath().getMap("Results");
		int schemeIdFromResponse = (Integer) billingScheme.get("SchemeId");
		Assert.assertEquals(String.valueOf(schemeIdFromResponse), schemeId, "SchemeId should be " + schemeId + ".");
		System.out.println(schemeIdFromResponse);
		// 4. Validate that SchemeCode is not null
		String schemeCode = (String) billingScheme.get("SchemeCode");
		System.out.println(schemeCode);
		Assert.assertNotNull(schemeCode, "SchemeCode should not be null.");


	}

	static void getBillingSummaryByPatientId()
	{
		String patientId = "114";
		
		String endpoint="/PharmacySales/PatientBillingSummary?patientId="+patientId;		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		Map<String, Object> billingSummary = response.jsonPath().getMap("Results");
		int patientIdFromResponse = (Integer) billingSummary.get("PatientId");
		Assert.assertEquals(String.valueOf(patientIdFromResponse), patientId, "PatientId should be " + patientId + ".");
		System.out.println(patientIdFromResponse);
		// 4. Validate that TotalDue is not null
		Float totalDue = (Float) billingSummary.get("TotalDue");
		Assert.assertNotNull(totalDue, "TotalDue should not be null.");
		System.out.println(totalDue);


	}
	
	static void getConsumptionsListOfAPatientById() //Null Value
	{
		
		String patientId = "114";
		String patientVisitId = "53";
		String endpoint="/PatientConsumption/ConsumptionsOfPatient?patientId=" + patientId+ "&patientVisitId=" + patientVisitId;
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> consumptionsList = response.jsonPath().getList("Results");
		List<Integer> patientConsumptionIds = consumptionsList.stream()
				.map(consumption -> (Integer) consumption.get("PatientConsumptionId")).collect(Collectors.toList());
		System.out.println(patientConsumptionIds);
		Set<Integer> uniqueIds = new HashSet<>(patientConsumptionIds);
		Assert.assertEquals(patientConsumptionIds.size(), uniqueIds.size(), "PatientConsumptionId should be unique.");

		// 4. Validate that TotalAmount is not null
		consumptionsList.forEach(consumption -> {
			Assert.assertNotNull(consumption.get("TotalAmount"), "TotalAmount should not be null.");
		});


	}
	static void getReturnConsumptionsList()
	{
		String endpoint="/PatientConsumption/Returns";		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> returnConsumptions = response.jsonPath().getList("Results");
		List<Integer> consumptionReturnReceiptNos = returnConsumptions.stream()
				.map(consumption -> (Integer) consumption.get("ConsumptionReturnReceiptNo"))
				.collect(Collectors.toList());
		System.out.println(consumptionReturnReceiptNos);
		Set<Integer> uniqueReceiptNos = new HashSet<>(consumptionReturnReceiptNos);
		System.out.println(uniqueReceiptNos);
		Assert.assertEquals(consumptionReturnReceiptNos.size(), uniqueReceiptNos.size(),
				"ConsumptionReturnReceiptNo should be unique.");

		// 4. Validate that PatientId is not null
		for (Map<String, Object> consumption : returnConsumptions) {
			System.out.println(consumption.get("PatientId"));
			Assert.assertNotNull(consumption.get("PatientId"), "PatientId should not be null.");
		}
		
	}
	
	static void getDischargedPatients()
	{
		String fromDate = "2020-01-01";
		String toDate = "2024-11-19";

		String endpoint="/Admission/DischargedPatients?admissionStatus=discharged&FromDate=" + fromDate + "&ToDate=" + toDate;		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> dischargedPatients = response.jsonPath().getList("Results");
		List<Integer> patientVisitIds = dischargedPatients.stream()
				.map(patient -> (Integer) patient.get("PatientVisitId")).collect(Collectors.toList());
		Set<Integer> uniquePatientVisitIds = new HashSet<>(patientVisitIds);
		Assert.assertEquals(patientVisitIds.size(), uniquePatientVisitIds.size(), "PatientVisitId should be unique.");

		List<Integer> patientAdmissionIds = dischargedPatients.stream()
				.map(patient -> (Integer) patient.get("PatientAdmissionId")).collect(Collectors.toList());
		Set<Integer> uniquePatientAdmissionIds = new HashSet<>(patientAdmissionIds);
		Assert.assertEquals(patientAdmissionIds.size(), uniquePatientAdmissionIds.size(),
				"PatientAdmissionId should be unique.");

		// 4. Validate that PatientId is not null
		for (Map<String, Object> patient : dischargedPatients) {
			System.out.println(patient.get("PatientId"));
			Assert.assertNotNull(patient.get("PatientId"), "PatientId should not be null.");
		}
		
	}
	
	static void getFilmTypesInRadiology()
	{
		
		String endpoint="/radiology/FilmTypes";		
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> results = response.jsonPath().getList("Results");
		Assert.assertNotNull(results, "Results should not be null.");
		Assert.assertFalse(results.isEmpty(), "Results should not be empty.");

		// 4. Verify FilmTypeId is not null and unique
		Set<Integer> filmTypeIds = new HashSet<>();
		for (Map<String, Object> result : results) {
			Integer filmTypeId = (Integer) result.get("FilmTypeId");
			System.out.println(filmTypeId);
			Assert.assertNotNull(filmTypeId, "FilmTypeId should not be null.");
			Assert.assertTrue(filmTypeIds.add(filmTypeId),
					"FilmTypeId should be unique. Duplicate found: " + filmTypeId);
		}
		
	}
	
	static void getRequisitionsByOrderStatusAndDateRange()
	{
		String fromDate = "2024-01-15";
		String toDate = "2025-01-20";
		String orderStatus = "active";
		String reportOrderStatus = "pending";
		String typeList = "[1,2,3,4]";
		String endpoint="/radiology/Requisitions?reqOrderStatus=" + orderStatus + "&reportOrderStatus=" + reportOrderStatus+ "&typeList=" + typeList + "&fromDate=" + fromDate + "&toDate=" + toDate;
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> results = response.jsonPath().getList("Results");
		System.out.println(results);
		Assert.assertNotNull(results, "Results should not be null.");
		Assert.assertFalse(results.isEmpty(), "Results should not be empty.");

		// 4. Verify ImagingRequisitionId exists and is unique
		Set<Integer> imagingRequisitionIds = new HashSet<>();
		for (Map<String, Object> result : results) {
			Integer imagingRequisitionId = (Integer) result.get("ImagingRequisitionId");
			System.out.println(imagingRequisitionId);
			Assert.assertNotNull(imagingRequisitionId, "ImagingRequisitionId should not be null.");
			Assert.assertTrue(imagingRequisitionIds.add(imagingRequisitionId),
					"ImagingRequisitionId should be unique. Duplicate found: " + imagingRequisitionId);
		}
				
	}

	static void getImagingReportsWithStatusAndDateRange()
	{
		String fromDate = "2024-01-14";
		String toDate = "2025-01-21";
		String reportOrderStatus = "final";
		String typeList = "[1,2,3,4]";
		String endpoint="/radiology/ImagingReports?reportOrderStatus=" + reportOrderStatus + "&fromDate=" + fromDate+ "&toDate=" + toDate + "&typeList=" + typeList;
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		response.then().log().body();
		List<Map<String, Object>> results = response.jsonPath().getList("Results");
		Assert.assertNotNull(results, "Results should not be null.");
		Assert.assertFalse(results.isEmpty(), "Results should not be empty.");

		// 4. Verify ImagingRequisitionId exists and is unique
		Set<Integer> imagingRequisitionIds = new HashSet<>();
		for (Map<String, Object> result : results) {
			Integer imagingRequisitionId = (Integer) result.get("ImagingRequisitionId");
			Assert.assertNotNull(imagingRequisitionId, "ImagingRequisitionId should not be null.");
			Assert.assertTrue(imagingRequisitionIds.add(imagingRequisitionId),
					"ImagingRequisitionId should be unique. Duplicate found: " + imagingRequisitionId);
		}

	}
	
	static void getAdmittedPatientData()
	{
		String module = "radiology";
		int visitId = 147;
		String endpoint="/Billing/InPatientProvisionalItems?patientId=176&patientVisitId=" + visitId + "&module=" + module;
		String url=BASE_URL+endpoint;
		System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		//response.then().log().body();
		Map<String, Object> results = response.jsonPath().getMap("Results");
		Assert.assertNotNull(results, "Results should not be null.");

		// Validate the Patient object
		Map<String, Object> patient = (Map<String, Object>) results.get("Patient");
		//System.out.println(patient);
		Assert.assertNotNull(patient, "Patient object should not be null.");
		Assert.assertEquals(patient.get("PatientId"), 176, "PatientId should match the expected value.");

		// 4. Validate the BillItems array
		List<Map<String, Object>> billItems = (List<Map<String, Object>>) results.get("BillItems");
		System.out.println(billItems);
		Assert.assertNotNull(billItems, "BillItems array should not be null.");
		Assert.assertFalse(billItems.isEmpty(), "BillItems array should not be empty.");

		// Validate each BillItem (without using forEach loop)
		for (Map<String, Object> item : billItems) {
			Assert.assertNotNull(item.get("PatientId"), "PatientId should not be null.");
			Assert.assertEquals(item.get("PatientId"), 176, "PatientId in BillItem should match the expected value.");
			Assert.assertNotNull(item.get("Price"), "Price should not be null.");
			Assert.assertEquals(item.get("BillStatus"), "provisional", "BillStatus should be 'provisional'.");
			Assert.assertEquals(item.get("BillingType"), "inpatient", "BillingType should be 'inpatient'.");
			Assert.assertEquals(item.get("VisitType"), "inpatient", "VisitType should be 'inpatient'.");
		}

	}

	static void getInPatientProvItems()
	{
		
		String endpoint="/Billing/InPatientProvisionalItems?patientId=176&patientVisitId=147&module=radiology";
		String url=BASE_URL+endpoint;
		//System.out.println(url);
		Response response=RestAssured.given().header("authorization","bearer "+token).get(url);
		//response.then().log().body();
		Map<String, Object> results = response.jsonPath().getMap("Results.Patient");
		System.out.println(results);
		Assert.assertNotNull(results, "BillItems should not be null.");
		Assert.assertFalse(results.isEmpty(), "BillItems should not be empty.");

	

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getAllStocks();
		//getMainStore();
		//getRequisitionByDateRange();
		getPatientConsumptions(); //null Values
		//getPatientConsumptionInfoByPatientIdAndVisitId(); // Null Values
		//getBillingSchemeBySchemeId();
		//getBillingSummaryByPatientId();
		//getConsumptionsListOfAPatientById(); //Null Values
		//getReturnConsumptionsList();
		//getDischargedPatients();
		//getFilmTypesInRadiology();
		//getRequisitionsByOrderStatusAndDateRange();
		//getImagingReportsWithStatusAndDateRange();
		//getAdmittedPatientData();
		//getInPatientProvItems();
	}

}
