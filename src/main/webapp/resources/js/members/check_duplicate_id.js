/*아이디 중복검사 확인 */
// 중복 검사를 수행하는 함수
 async function checkDuplicateID() {
  const memberIDInput = document.getElementById('memberID');
  const memberIDValue = memberIDInput.value;
  const memberIDRegex = /^[a-zA-Z0-9]{4,20}$/;

  try {
    const response = await axios.post(window.ctx+'/member/join/checkID', { memberID: memberIDValue }); // 서버로 전송되는 데이터 객체
    const isDuplicate = response.data.isDuplicate;
	const statusMessage = response.data.statusMessage;

	console.log("isDuplicate : "+isDuplicate)
	
	

    if (isDuplicate) {
      alert(statusMessage);
	} else if (!memberIDRegex.test(memberIDValue)) {
	  alert("아이디는 영문과 숫자로 이루어진 4~20자여야 합니다.");
	}else {
      alert(statusMessage);
    }
  } catch (error) {
    console.error(error);
    alert('중복 검사 요청에 실패했습니다. 다시 시도해주세요.');
  }
};

// 중복 검사 버튼 클릭 이벤트 핸들러
const checkButton = document.getElementById('check-duplicate-button');
checkButton.addEventListener('click', checkDuplicateID);