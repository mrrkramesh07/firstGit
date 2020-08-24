/*function employeeValidation(){*/
	
/*	var fName = document.getElementById("firstname").value;
	var Age= document.getElementById("age").value;
	
	
	
	if(fName == ""){
	alert("First name can not be empty");
	return false;
	}
	
	if(Age == ""){
		alert("Age can not be empty");
		return false;
		}
	

	if(isNaN(Age) == true){
		alert("Age should be number");
		return false;
		}
	
	if( parseInt(Age) <1|| parseInt(Age)>100){
		alert("Age should be betwwen 1 to 100");
		return false;
		}
	else{
	return true;
	
	}
	
}*/
	
	  function employeeValidation(){
		  
	var correct_way=/^[A-Za-z]+$/;
	var FirstName=document.getElementById("firstname").value;
		var Age=document.getElementById("age").value;
	
	if(FirstName==""){
		document.getElementById("Firstname_message").innerHTML="** Please fill the blank";
			return false;
	}
	if(FirstName.length<3||FirstName.length>25){
		document.getElementById("Firstname_message").innerHTML="** length should be 3-25";
		return false;
	}
/*	if(FirstName==!(correct_way)){
		document.getElementById("Firstname_message").innerHTML="** write in alphabactical ordered;
		return false;
	}
*/
	
	if(Age==""){
			document.getElementById("Age_message").innerHTML="** please fill the Age";
			
			return false;
	} 
	if( parseInt(Age) <1|| parseInt(Age)>100){
		document.getElementById("Age_message").innerHTML="** please fill the proper Age";
		return false;
	}
	
	else {
		return true;
	}
	 }
	
