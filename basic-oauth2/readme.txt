## 最基础版的OAuth2.0

## 自定义Security登录用户名和密码
security.user.name=admin
security.user.password=123456

## 自定义appid和密码
security.oauth2.client.client-id=net5ijy
security.oauth2.client.client-secret=123456

## 获取code
http://localhost:7000/oauth/authorize?response_type=code&client_id=net5ijy&redirect_uri=http://localhost:8080&scope=all

## 获取token
http://localhost:7000/oauth/token

	POST请求

	Postman Authorization

		Basic Auth
		net5ijy
		123456

	Body

		grant_type		authorization_code
		code			QJxLvv
		redirect_uri	http://localhost:8080
		scope			all

## 请求资源
http://localhost:7000/order/demo?access_token=f0ecbabe-8605-4750-9bc7-436429230ba6

## curl命令
curl --user net5ijy:123456 -X POST -d "grant_type=authorization_code&scope=all&redirect_uri=http%3a%2f%2flocalhost%3a8080&code=MdE3eF" http://localhost:7000/oauth/token

## 密码模式
curl --user net5ijy:123456 -X POST -d "grant_type=password&username=admin&password=123456&scope=all" http://localhost:7000/oauth/token
