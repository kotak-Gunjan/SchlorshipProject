<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
/* @import url(https://fonts.googleapis.com/css?family=Roboto:300); */
.login-page {
	width: 700px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 600px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 50px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: rgb(146, 220, 250);
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: rgb(146, 220, 250);
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: rgb(146, 220, 250);
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	font-family: "Roboto", sans-serif;
	background: rgb(146, 220, 250);
}
</style>

</head>
<body>

	<div class="login-page">
		<div class="form">



			<%-- <td><c:out value="${student.studentId}"/> </td>
		<td><c:out value="${student.studentName}"/> </td> --%>




			<form   class="login-form" >
				<h2 align="center">Details of Student</h2>
				<table cellspacing="5px" cellpadding="5%" ; align="center">
					<!-- Student Registration -->
					
					<tr>
						<td>Name:</td>
						<td><input id="STUDENT_NAME" name="studentName"
							style="width: 150px;" value="${student.studentName}" disabled></td>

						<td>Date Of Birth:</td>
						<td><input id="STUDENT_DOB" name="sdob" style="width: 150px;"
							value="${student.studentDOB}" disabled></td>
					</tr>

					<tr>
						<td>Gender:</td>
						<td><input id="STUDENT_GENDER" name="studentGender"
							style="width: 150px;" value="${student.studentGender}" disabled /></td>

						<td>Mobile Number:</td>
						<td><input style="width: 150px;" name="studentMobileNo"
							id="STUDENT_MOBILE_NO" value="${student.studentMobileNo}"
							disabled></td>
					</tr>

					<tr>
						<td>Email:</td>
						<td><input name="studentEmail" style="width: 150px;"
							id="STUDENT_EMAIL" value="${student.studentEmail}" disabled /></td>

						<td>Institute Code:</td>
						<td><input style="width: 150px;" id="INSTITUTE_CODE"
							value="${institute.getInstituteCode()}" disabled /></td>
					</tr>

					<tr>
						<td>Aadhar Number:</td>
						<td><input style="width: 150px;" name="studentaadhar"
							id="STUDENT_IAADHAR_NO" value="${student.studentaadhar}" disabled /></td>

						<td>State:</td>
						<td><input style="width: 150px;" name="studentState"
							id="STUDENT_STATE" value="${student.studentState}" disabled /></td>
					</tr>

					<tr>
						<td>District:</td>
						<td><input style="width: 150px;" name="studentDistrict"
							id="STUDENT_DISTRICT" value="${student.studentDistrict}"
							 disabled /></td>
						<!--Student Basic Details  -->
						
						
						
						<td>Community :</td>
						<td><input name="community" style="width: 150px;"
							value="${student.studentBasicDetails.community}" disabled /></td>
					</tr>

					<tr>
						<td>Religion :</td>
						<td><input name="religion" style="width: 150px;"
							value="${student.studentBasicDetails.religion}" disabled /></td>

						<td>Father's Name:</td>
						<td><input name="fatherName" style="width: 150px;"
							value="${student.studentBasicDetails.fatherName}" disabled /></td>
					</tr>

					<tr>
						<td>Father's Profession :</td>
						<td><input type="text" name="fatherProfession"
							style="width: 150px;"
							value="${student.studentBasicDetails.fatherProfession}" disabled /></td>

						<td>Father's Income :</td>
						<td><input type="text" name="fatherIncome"
							style="width: 150px;"
							value="${student.studentBasicDetails.fatherIncome}" disabled /></td>
					</tr>




					<tr>
						<td>Mother's Name :</td>
						<td><input type="text" name="motherName"
							style="width: 150px;"
							value="${student.studentBasicDetails.motherName}" disabled /></td>

						<td>Mother's Profession :</td>
						<td><input type="text" name="motherProfession"
							style="width: 150px;"
							value="${student.studentBasicDetails.motherProfession}" disabled /></td>
					</tr>

					<tr>
						<td>Marital Status :</td>
						<td><input type="text" name="motherProfession"
							style="width: 150px;"
							value="${student.studentBasicDetails.maritalStatus}" disabled /></td>

						<td>Disability :</td>
						<td><input type="text" name="motherProfession"
							style="width: 150px;"
							value="${student.studentBasicDetails.isDisabled}" disabled /></td>
					</tr>

					<tr>
						<td>Disability Type :</td>
						<td><input name="typeOfDisability"
							placeholder="Disability Type" style="width: 150px;"
							value="${student.studentBasicDetails.typeOfDisability}" disabled></td>

						<td>Locality :</td>
						<td><input type="text" name="locality" placeholder="Locality"
							style="width: 150px;"
							value="${student.studentBasicDetails.locality}" disabled /></td>
					</tr>

					<tr>
						<td>City</td>
						<td><input type="text" name="city" placeholder="City"
							style="width: 150px;" value="${student.studentBasicDetails.city}"
							disabled /></td>
						<td>State</td>

						<td><input type="text" name="state" placeholder="State"
							style="width: 150px;"
							value="${student.studentBasicDetails.state}" disabled /></td>
					</tr>

					<tr>
						<td>Pincode :</td>
						<td><input type="text" style="width: 150px;" name="pincode"
							placeholder="Pincode"
							value="${student.studentBasicDetails.pincode}" disabled /></td>


						<!--  STUDENT ACADEMIC-->
						<%-- <td>Institute name:</td>
						<td><input id="inst_name" name="instituteName"
							value="${student.studentAcademic.instituteName}" disabled></td> --%>
					
					</tr>

					<tr>
						<td>Present course:</td>
						<td><input id="present_course" name="presentCourse"
							style="width: 150px;"
							value="${student.studentAcademic.presentCourse}" disabled></td>

						<td>Present course year:</td>
						<td><input id="present_course_year" name="presentCourseYear"
							style="width: 150px;"
							value="${student.studentAcademic.presentCourseYear}" disabled></td>
					</tr>

					<tr>
						<td>Mode of study:</td>
						<td><input id="mode_of_study" name="modeOfStudy"
							style="width: 150px;"
							value="${student.studentAcademic.modeOfStudy}" disabled></td>

						<td>Class start date:</td>
						<td><input id="class_start_date" name="classStartDate"
							style="width: 150px;"
							value="${student.studentAcademic.classStartDate}" disabled></td>
					</tr>

					<tr>
						<td>UNIVERSITY NAME:</td>
						<td><input id="university_name" name="universityName"
							style="width: 150px;"
							value="${student.studentAcademic.universityName}" disabled></td>

						<td>PREVIOUS COURSE:</td>
						<td><input id="previous_course" name="previousCourse"
							style="width: 150px;"
							value="${student.studentAcademic.previousCourse}" disabled></td>
					</tr>

					<tr>
						<td>PREVIOUS PASSING YEAR:</td>
						<td><input id="previous_passing_year"
							name="previousPassingYear" style="width: 150px;"
							value="${student.studentAcademic.previousPassingYear}" disabled></td>

						<td>ROLL NO 10th:</td>
						<td><input id="roll_no_tenth" name="rollNoTenth"
							style="width: 150px;"
							value="${student.studentAcademic.rollNoTenth}" disabled></td>
					</tr>

					<tr>
						<td>BOARD NAME 10th :</td>
						<td><input id="board_name_tenth" name="boardNameTenth"
							style="width: 150px;"
							value="${student.studentAcademic.boardNameTenth}" disabled></td>

						<td>PASSING YEAR 10th :</td>
						<td><input id="passing_year_tenth" name="passingYearTenth"
							style="width: 150px;"
							value="${student.studentAcademic.passingYearTenth}" disabled></td>
					</tr>

					<tr>
						<td>MARKS 10th :</td>
						<td><input id="marks_tenth" name="marksTenth"
							style="width: 150px;"
							value="${student.studentAcademic.marksTenth}" disabled></td>

						<td>ROLL NO 12th:</td>
						<td><input id="roll_no_twelth" name="rollNoTwelth"
							style="width: 150px;"
							value="${student.studentAcademic.rollNoTwelth}" disabled></td>
					</tr>

					<tr>
						<td>BOARD NAME 12th :</td>
						<td><input id="board_name_twelth" name="boardNameTwelth"
							style="width: 150px;"
							value="${student.studentAcademic.boardNameTwelth}" disabled></td>

						<td>PASSING YEAR 12th :</td>
						<td><input id="passing_year_twelth" name="passingYearTwelth"
							style="width: 150px;"
							value="${student.studentAcademic.passingYearTwelth}" disabled></td>
					</tr>

					<tr>
						<td>MARKS 12th :</td>
						<td><input id="marks_twelth" name="marksTwelth"
							style="width: 150px;"
							value="${student.studentAcademic.marksTwelth}" disabled></td>

						<td>ADMISSION FEE :</td>
						<td><input id="adm_fee" name="admissionFee"
							style="width: 150px;"
							value="${student.studentAcademic.admissionFee}" disabled></td>
					</tr>
					<tr>
						<td>TUITION FEE :</td>
						<td><input id="tui_fee" name="tuitionFee"
							style="width: 150px;"
							value="${student.studentAcademic.tuitionFee}" disabled></td>

						<td>OTHER FEE :</td>
						<td><input id="other_fee" name="otherFee"
							style="width: 150px;" value="${student.studentAcademic.otherFee}"
							disabled></td>
					</tr>
		
					<tr>
						<td>Bank Account No. :</td>
						<td><input name="accountNo"
							value="${student.studentBankDetails.accountNo}" 
							disabled /></td>
							
						<td>Bank Name :</td>
						<td><input name="bankName"
							value="${student.studentBankDetails.bankName}" 
							disabled /></td>
					</tr>
					<tr>
					<td>IFSC Code:</td>
					<td><input name="ifscCode"
							value="${student.studentBankDetails.ifscCode}" 
							disabled /></td>
					</tr>
					<tr><td>
<!-- 					<input <a href="accept.lti"/> type="submit" value="Accept" name="status."/></td>
					<td><input type="submit" value="Reject" name="status.statusId"/></td> -->
					<a  href="accept.lti">ACCEPT</a>
					<a href="reject.lti">REJECT</a>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>





