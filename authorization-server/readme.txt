## 授权服务器

## 获取code
http://localhost:7002/oauth/authorize?response_type=code&client_id=tencent&redirect_uri=http://localhost:8080&scope=all

## 获取token
http://localhost:7002/oauth/token

	POST请求

	Postman Authorization

		Basic Auth
		tencent
		12345678

	Body

		grant_type		authorization_code
		code			QJxLvv
		redirect_uri	http://localhost:8080
		scope			all

## 请求资源
http://localhost:7003/order/demo?access_token=675b7a16-974b-4d5f-bd77-29b178534218
