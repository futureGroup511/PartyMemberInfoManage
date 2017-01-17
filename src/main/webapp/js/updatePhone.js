function updatePhone(){
	var reg = new RegExp("^[0-9]*$");
	var phone=document.getElementById("phone").value;
	var newPhone=prompt("请输入你的新手机号",phone);
	if (reg.test(newPhone)&&newPhone!="")
	{
		window.location.href="/PartyMemberInfoManage/secretary/partySecretary_updatePhone?phone="+newPhone;
	}else{
		alert("请输入合法的手机号");
	}
}