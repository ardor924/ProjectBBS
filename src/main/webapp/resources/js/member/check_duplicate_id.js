/*아이디 중복검사 확인 */
// 중복 검사를 수행하는 함수
async function checkDuplicateID() {
  const memberIDInput = document.getElementById('memberID');
  const memberIDValue = memberIDInput.value;

  try {
    const response = await axios.post('/checkDuplicateID.do', { memberID: memberIDValue });
    const isDuplicate = response.data.isDuplicate;

    if (isDuplicate) {
      alert('중복된 아이디입니다. 다른 아이디를 입력해주세요.');
    } else {
      alert('사용 가능한 아이디입니다.');
    }
  } catch (error) {
    console.error(error);
    alert('중복 검사 요청에 실패했습니다. 다시 시도해주세요.');
  }
};

// 중복 검사 버튼 클릭 이벤트 핸들러
const checkButton = document.getElementById('check-duplicate-button');
checkButton.addEventListener('click', checkDuplicateID);