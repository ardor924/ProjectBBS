
ClassicEditor
	.create( document.querySelector( '#editor' ), {

    toolbar: {
      items1: [
        'findAndReplace', 'selectAll', '|',
        'insertImage', 'mediaEmbed', 'link', 'insertTable', 'htmlEmbed', '|',
        'code', 'horizontalLine', 'codeBlock', 'sourceEditing',  '|',	
        'pageBreak', '|',
        'alignment', '|',
        
      ],
      items2: [
        'alignment', '|',
        'heading', '|',
        'fontFamily', 'fontSize',  'fontColor', 'fontBackgroundColor', 'highlight','|',
        'bold', 'italic', 'strikethrough', 'underline',  'subscript', 'superscript', 'removeFormat', '|',
        'specialCharacters',  'blockQuote', '|', 
        'numberedList', 'bulletedList', '|', 
        'indent',  'outdent', '|',       
        'undo', 'redo', '|',
        
      ]
    },

/*	simpleUpload:
                {
                    uploadUrl: "/uploadImage",
                    withCredentials: true,
    },*/


	extraPlugins: [UploadAdapterPlugin],


        
    list: {
      properties: {
        styles: true,
        startIndex: true,
        reversed: true
      }
    },

    heading: {
      options: [
        { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
        { model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
        { model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
        { model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading3' }

      ]
    },

    placeholder: '내용을 입력해 주세요',

    fontFamily: {
      options: [
        'default',
        'd2coding',
        '스웨거',
        '조선일보명조',
        '리디바탕',
        '아임크리수진 OTF',
        'Leferi Point Type',
        '넥슨Lv1고딕 OTF',
        'S-Core Dream 5',
        '배달의민족 주아',
        '빙그레 메로나체',
        '빙그레 싸만코체',
        '빙그레체',
        '이순신 Regular',
        'KoPubWorld바탕체',
        'KoPubWorld돋움체',



      ],
      supportAllValues: true
    },

    fontSize: {
      options: [11, 13, 'default', 16, 19, 24, 28,30,34,45],
      supportAllValues: true
    },


    

    htmlEmbed: {
      showPreviews: true
    },

    link: {
      decorators: {
        addTargetToExternalLinks: true,
        defaultProtocol: 'https://',
        toggleDownloadable: {
          mode: 'manual',
          label: 'Downloadable',
          attributes: {
            download: 'file'
          }
        }
      }
    },

    indentBlock: {
            offset: 1,
            unit: 'em'
    },

} )
.then(newEditor => {
    editor = newEditor;
})
.catch(error => {
    console.error(error);
});






/*--------------------------------*/



class UploadAdapter {
    constructor(loader) {
        this.loader = loader;
    }

    upload() {
        return this.loader.file.then( file => new Promise(((resolve, reject) => {
            this._initRequest();
            this._initListeners( resolve, reject, file );
            this._sendRequest( file );
        })))
    }

    _initRequest() {
        const xhr = this.xhr = new XMLHttpRequest();
        xhr.open('POST', 'http://localhost:8080/myapp/uploadImage.do', true);
        xhr.responseType = 'json';
    }

    _initListeners(resolve, reject, file) {
        const xhr = this.xhr;
        const loader = this.loader;
        const genericErrorText = '파일을 업로드 할 수 없습니다.'

        xhr.addEventListener('error', () => {reject(genericErrorText)})
        xhr.addEventListener('abort', () => reject())
        xhr.addEventListener('load', () => {
            const response = xhr.response
            if(!response || response.error) {
                return reject( response && response.error ? response.error.message : genericErrorText );
            }

            resolve({
                default: response.url //업로드된 파일 주소
            })
        })
    }

    _sendRequest(file) {
        const data = new FormData()
        data.append('upload',file)
        this.xhr.send(data)
    }
}



function UploadAdapterPlugin(editor) {
  editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
    return new UploadAdapter(loader);
  };
}


