function myFunction(){
	var uName=document.getElementById("user_name").value;
	var Pass=document.getElementById("Password").value;
	var date=document.getElementById("Date").value;
if(uName==""){
alert("**Please fill the username");
	return false;	
}
if(Pass==""){
	alert("Plz fill the Password");
	return false;
}
if(date==""){
	alert("Date cant be empty");
	return false;
}
else{
return true;
}
}