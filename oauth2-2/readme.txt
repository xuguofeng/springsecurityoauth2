## 实现了授权码模式和密码模式

## 使用Maven构建
mvn clean package dependency:copy-dependencies -DoutputDirectory=target/lib

## ##### 授权码模式 #####

## 授权码模式 - 获取code
http://localhost:7001/oauth/authorize?response_type=code&client_id=net5ijy&redirect_uri=http://localhost:8080&scope=all

## 授权码模式 - 获取token
http://localhost:7001/oauth/token

	POST请求

	Postman Authorization

		Basic Auth
		net5ijy
		12345678

	Body

		grant_type		authorization_code
		code			0s1LFa
		redirect_uri	http://localhost:8080
		scope			all

## 授权码模式 - 使用curl命令获取token
curl --user net5ijy:12345678 -X POST \
-d "grant_type=authorization_code&scope=all&redirect_uri=http%3a%2f%2flocalhost%3a8080&code=AZMoXe" \
http://192.168.186.1:7001/oauth/token

## 授权码模式 - 使用curl命令刷新token
curl --user net5ijy:12345678 -X POST \
-d "grant_type=refresh_token&refresh_token=e3ba6d93-189c-45f9-91d5-34d2773006e1" \
http://localhost:7001/oauth/token

## ##### 密码模式 #####

## 密码模式 - 获取token
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

## 密码模式 - 使用curl命令获取token
curl --user net5ijy:12345678 -X POST \
-d "grant_type=password&username=admin1&password=123456&scope=all" \
http://192.168.186.1:7001/oauth/token

## ##### 访问资源 #####

## 使用浏览器或Postman请求资源
http://localhost:7001/order/demo?access_token=804c9a89-8ba4-4ffc-a052-c049cbf89ed0
http://localhost:7001/users/list?access_token=804c9a89-8ba4-4ffc-a052-c049cbf89ed0