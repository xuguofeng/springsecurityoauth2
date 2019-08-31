## 授权服务器

## 使用Maven构建
mvn clean package dependency:copy-dependencies -DoutputDirectory=target/lib

## 获取code
http://localhost:7002/oauth/authorize?response_type=code&client_id=net5ijy&redirect_uri=http://localhost:8080&scope=all

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

## 授权码模式 - 使用curl命令获取token
curl --user net5ijy:12345678 -X POST \
-d "grant_type=authorization_code&scope=all&redirect_uri=http%3a%2f%2flocalhost%3a8080&code=xLb76o" \
http://192.168.186.1:7002/oauth/token

## 授权码模式 - 使用curl命令刷新token
curl --user net5ijy:12345678 -X POST \
-d "grant_type=refresh_token&refresh_token=80eae5f1-d3f8-4d7e-ab79-379519dfaa46" \
http://192.168.186.1:7002/oauth/token