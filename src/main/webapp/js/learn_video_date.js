
$(document).ready(function() {
	countTime();
});


function countTime() {
	$.ajax({
		url: "/PartyMemberInfoManage/party/partyMemberAction_updateLearnTime",
		type: 'POST',
		dataType: 'json',
		
		data:{"time":60},
		success: function(data){
		}
	});

	setTimeout('countTime()', 60000);    //60秒更新
}
