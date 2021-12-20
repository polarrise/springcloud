package cn.how2j.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import cn.hutool.core.util.NetUtil;

@SpringBootApplication
@EnableConfigServer   //主要是 @EnableConfigServer 这个注解表示本springboot 是个配置服务器.使用的是 8030 端口
@EnableDiscoveryClient
@EnableEurekaClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        int port = 8030;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ConfigServerApplication.class).properties("server.port=" + port).run(args);

    }
}
/**
 * 1.pom:主要是 spring-cloud-config-server 这个 jar 包
 * 2.ConfigServerApplication:主要是 @EnableConfigServer 这个注解表示本springboot 是个配置服务器。使用的是 8030 端口
 * 3.application.yml:uri 表示 git 地址：https://github.com/how2j/springcloudConfig/。  label表示 分支:master。searchPaths 表示目录：respo
 */
