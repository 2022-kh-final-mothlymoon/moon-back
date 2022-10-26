package kh.sellermoon;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
// 라이플 사이클 관리 받기 위해서 우리는 Bean을 등록 한다.
// 이렇게 하는 것은 직접 인스턴스화 하는 것과 어떠한 차이가 있는 걸까요?
// ApplicationContext 혹은 BeanFactory를 누릴 수 있다.
// 이른 인스턴스화나 게으른 인스턴스화를 선택할 수 있다.
// 자원 반납에 대해서 신경쓰지 않아도 된다.
@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig(){
	    return new HikariConfig();
	}
	@Bean
	public DataSource datasource(){
	 DataSource dataSource = new HikariDataSource(hikariConfig());
	 return dataSource;
	}
	@Autowired
	private ApplicationContext applicationContext = null;
	@Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	    factoryBean.setDataSource(dataSource);
	    factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
	    return factoryBean.getObject();
	  }
	@Bean
	public SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
