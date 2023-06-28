let refreshFlag = false;

function removeTempFile() {
  axios.get(ctx + '/removeTempFile')
    .then(response => {
      // 작업 완료
	
		var resultMSG = response.resultMSG;

      	console.log(resultMSG);
		alert(resultMSG);
    })
    .catch(error => {
      // 에러 처리
      console.error('Temp 파일 삭제 중 오류가 발생했습니다.', error);
    });
}

window.addEventListener('beforeunload', function(event) {
  if (!refreshFlag) {
    if (confirm("페이지를 새로고침 하시겠습니까?")) {
      refreshFlag = true;
      removeTempFile();
    } else {
      // 페이지를 새로고침하지 않을 경우에 대한 처리
    }
  }
});