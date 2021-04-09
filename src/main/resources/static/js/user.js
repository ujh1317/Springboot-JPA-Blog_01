let index = {
	init: function() {
		$("#btn-save").on("click", () => { //funtion(){}, ()=>{}  this를 바인딩하기 위해서
			this.save();
		});
	},
	
	save: function() {
		//alert("user의 save함수 호출됨");
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		//console.log(data);
		
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		$.ajax({
			//회원가입 수행 요청
			type: "POST",
			url: "/blog_01/api/user",
			data: JSON.stringify(data), //http body데이터
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			alert("회원가입이 완료 되었습니다.");
			console.log(resp);
			location.href="/blog_01";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	}

}

index.init();