package org.net5ijy.oauth2.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MyBatisConfiguration {

	@Bean
	@Autowired
	@ConditionalOnMissingBean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource)
			throws IOException {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		// 设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);

		// 设置别名包
		sqlSessionFactoryBean.setTypeAliasesPackage("org.net5ijy.oauth2.bean");

		// 设置mapper映射文件所在的包
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = "classpath*:org/net5ijy/oauth2/mapper/**.xml";
		sqlSessionFactoryBean
				.setMapperLocations(pathMatchingResourcePatternResolver
						.getResources(packageSearchPath));

		return sqlSessionFactoryBean;
	}
}
