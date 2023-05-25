/* 프로필 사진 업로드 로직*/ 

    // input typr='file'
    const fileInput = document.getElementById('memberPhoto');

    // button and a link
    const uploadButton = document.getElementById('profile-image-upload-btn');
    const uploadLink = document.getElementById('my-photo-frame');
  
    // 지정한 변수가 선택될때 input창클릭 
    uploadButton.addEventListener('click', () => {
        fileInput.click(); // 파일 선택 창 트리거
    });
    uploadLink.addEventListener('click', () => {
        fileInput.click(); // 파일 선택 창 트리거
    });
  
    // input창 클릭
    fileInput.addEventListener('change', () => {
      const selectedFiles = fileInput.files;

        // 선택한 파일 수 제한
        if (selectedFiles.length > 3) {
          alert('최대 1개까지 파일을 선택할 수 있습니다.');
          return;
        }
    
        for (let i = 0; i < selectedFiles.length; i++) {
          const file = selectedFiles[i];
        
          // 확장자 제한 (jpg, gif, png, bmp, webp)
          const allowedExtensions = /(\.jpg|\.jpeg|\.gif|\.png|\.bmp|\.webp)$/i;
          if (!allowedExtensions.test(file.name)) {
            alert('.jpg, .jpeg, .gif, .png, .bmp, .webp 등의\n이미지 파일만 선택할 수 있습니다.');
            return;
          }
      
          // 파일 크기 제한 (2MB)
          const maxSize = 2 * 1024 * 1024; // 2MB
          if (file.size > maxSize) {
            alert('각 파일의 크기는 2MB를 초과할 수 없습니다.');
            return;
          }
        }        
   

      // 선택한 파일 처리 또는 미리보기 등 추가 동작 수행
      if (selectedFiles.length > 0) {
        const formData = new FormData();
        formData.append('memberPhoto', selectedFiles[0]); // 파일 추가

      // Axios를 사용하여 Ajax 요청 생성
       axios.post(window.ctx+'/member/profilePhoto', formData) 
        .then(response => {
          // 응답 처리 로직
          const imageURL = response.data; // 응답으로 받은 이미지 URL
          console.log('응답 성공! 받은 데이터:', imageURL);
          alert('이미지 업로드가 완료되었습니다.');

          // mPhoto 요소를 가져옴
          const memberPhotoElement = document.getElementById('memberPhoto');

          // 이미지를 생성하고 소스를 응답으로 받은 URL로 설정
          const imageElement = new Image();
          imageElement.src = imageURL;

          // 이미지가 로드되었을 때 mPhoto 요소에 추가
          imageElement.onload = () => {
           memberPhotoElement.appendChild(imageElement);
          };

          // 이미지 로드에 실패했을 때의 처리
          imageElement.onerror = () => {
            // 오류 처리 로직
            console.error('이미지 로드 실패');
            alert('이미지 로드에 실패했습니다.');
          };
        })
        .catch(error => {
          // 응답이 실패인 경우에 대한 처리
          console.error('응답 실패! 상태 코드:', error.response.status);
          alert('이미지 업로드에 실패했습니다. 다시 시도해주세요.');
        });
    }
  });