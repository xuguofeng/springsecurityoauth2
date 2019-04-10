## 实现了授权码模式和密码模式

## 获取code
http://localhost:7001/oauth/authorize?response_type=code&client_id=net5ijy&redirect_uri=http://localhost:8080&scope=all

## 获取token
http://localhost:7001/oauth/token

	POST请求

	Postman Authorization

		Basic Auth
		net5ijy
		12345678

	Body

		grant_type		authorization_code
		code			QJxLvv
		redirect_uri	http://localhost:8080
		scope			all

## 密码模式获取token
http://localhost:7001/oauth/token

	POST请求

	Postman Authorization

		Basic Auth
		net5ijy
		12345678

	Body

		username		admin001
		password		123456
		grant_type		password
		scope			all

## 请求资源
http://localhost:7001/order/demo?access_token=afd3c4af-8481-41cd-9ce0-bf8d773d6763

## curl命令
curl --user net5ijy:12345678 -X POST -d "grant_type=authorization_code&scope=all&redirect_uri=http%3a%2f%2flocalhost%3a8080&code=A9FwZt" http://localhost:7001/oauth/token

## 密码模式
curl --user net5ijy:12345678 -X POST -d "grant_type=password&username=admin&password=123456&scope=all" http://localhost:7001/oauth/token
