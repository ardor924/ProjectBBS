function testFunction(){
	var str = "테스트성공!!"
	console.log(str)
}


/*JS 스크립트 로드 실험용 */
/*실험용 */
console.log("ctx/resources/js : "+ctx_resources+"/js")
var script = document.createElement('script');
script.src = ctx_resources+"/js/posting/test.js"
document.head.appendChild(script);
  script.onload = function() {
    var printt = testFunction();

  };

/*실험용 */