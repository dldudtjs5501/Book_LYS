/**
 * 
 */
//daumPostcode_API를 이용한 주소 검색
function Postcode(){ 
	new daum.Postcode({
		oncomplete:function(data){
			var fullRoadAddr = data.roadAddress; //도로명 주소 변수
			var extraRoadAddr =''; //도로명 조합형 주소 변수
			
			//ex>bname = 삼산동
			if(data.bname !==''&&/[동|로|가]$/g.test(data.bname)){  
				extraRoadAddr += data.bname;
				//alert(data.bname);
			}
			
			//건물명 , 공동 주택 ex)지산오차드힐 아파트
			if(data.buildingName !== ''&& data.apartment ==='Y'){
				extraRoadAddr +=(extraRoadAddr !==''?','+ data.buildingName : data.buildingName);
				//alert(extraRoadAddr);
			}
			
			//도로명, 지번 조합형 주소
			if(extraRoadAddr !==''){
				extraRoadAddr = '('+extraRoadAddr+')';
				//alert(extraRoadAddr); , 야음동 true
			}
			
			//도로명, 지번 주소의 유무에 따라 해당 조합형 주소 추가
			if(fullRoadAddr !== ''){
				fullRoadAddr += extraRoadAddr;
			}
			
			//우편번호와 주소정보를 해당 필드에 넣기
			document.getElementById('postcode').value = data.zonecode; //5자리 새 우편번호 사용
			document.getElementById('road').value = fullRoadAddr; //도로명 address
			document.getElementById('jibun').value = data.jibunAddress; //지번address
			
			//사용자가 '선택 안함'을 클릭 한 경우, 예상 주소 표시
			/*if(data.autoRoadAddress){
				//예상 되는 도로명 주소에 조합형 주소를 추가
				var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
				document.getElementById('guide').innerHTML = '(예상 도로명 주소 :'+ expRoadAddr +')';
			}else if(data.autoJibunAddress){
				var expJibunAddr = data.autoJibunAddress;
				document.getElementById('guide').innerHTML = '(예상 도로명 주소 :'+ expRoadAddr +')';
			}else{
				document.getElementById('guide').innerHTML = '';
			}*/
		}
	}).open();
}