window.onbeforeunload = function() {
  return "페이지를 새로 고침하시겠습니까?";
};

function executeRemoveTempFile() {
  axios.get(ctx + '/removeTempFile')
    .then(response => {
      // 요청에 대한 성공 처리
      console.log(response.data);
    })
    .catch(error => {
      // 요청에 대한 실패 처리
      console.error(error);
    });
}

window.addEventListener('unload', function() {
  var confirmation = confirm("페이지를 새로 고침하시겠습니까?");
  if (confirmation) {
    executeRemoveTempFile();
  }
});

