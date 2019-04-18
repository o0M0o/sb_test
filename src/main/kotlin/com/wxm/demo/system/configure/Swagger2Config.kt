package com.wxm.demo.system.configure

import java.util.ArrayList

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import springfox.documentation.schema.ModelRef
import springfox.documentation.service.Parameter

/**
 * swagger2配置文件
 * @author wang xiaoming
 */
@EnableSwagger2
@Configuration
class Swagger2Config {
	/**
	 * 'X-TOKEN' 是可选的为单点登录添加的字段
	 * 测试中先忽略此字段
	 */
	@Bean
	fun createRestApi(): Docket  {
		val ticketPar = ParameterBuilder()
    	ticketPar.name("X-TOKEN")
				.description("token for Authentication")
    			.modelRef(ModelRef("string"))
				.parameterType("header")
                .required(false)
				.build()

        val pars = ArrayList<Parameter>()
    	pars.add(ticketPar.build())
        return Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(RequestHandlerSelectors.any())  
				.paths(PathSelectors.any())
                .build()  
                .globalOperationParameters(pars)  
                .apiInfo(apiInfo())
	}

	private fun apiInfo(): ApiInfo  {
		return ApiInfoBuilder()
				.title("demo")
				.contact(Contact("demo", "www.wxm.com", "fly_in_wind@qq.com"))
				.version("1.0")
				.description("API 文档").build()
	}
}



