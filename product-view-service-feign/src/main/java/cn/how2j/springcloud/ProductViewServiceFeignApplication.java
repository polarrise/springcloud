package cn.how2j.springcloud;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import brave.sampler.Sampler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients       //表示用于使用 Feign 方式
@EnableCircuitBreaker    //使得它可以把信息共享给监控中心。 用于断路器监控
public class ProductViewServiceFeignApplication {

    public static void main(String[] args) {
        //判断 rabiitMQ 是否启动
        int rabbitMQPort = 5672;
        if(NetUtil.isUsableLocalPort(rabbitMQPort)) {
            System.err.printf("未在端口%d 发现 rabbitMQ服务，请检查rabbitMQ 是否启动", rabbitMQPort );
            System.exit(1);
        }
        int port = 0;
        int defaultPort = 8012;
        Future<Integer> future = ThreadUtil.execAsync(() ->{
            int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8012 、 8013  或者  8014，超过5秒将默认使用"+defaultPort);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String strPort = scanner.nextLine();
                if(!NumberUtil.isInteger(strPort)) {
                    System.err.println("只能是数字");
                    continue;
                }
                else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });
        try{
            port=future.get(5,TimeUnit.SECONDS);
        }
        catch (InterruptedException | ExecutionException | TimeoutException e){
            port = defaultPort;
        }
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductViewServiceFeignApplication.class).properties("server.port=" + port).run(args);
    }
    //在启动类里配置 Sampler 抽样策略： ALWAYS_SAMPLE 表示持续抽样。  用于服务链路追踪
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}


/**
 * 服务链路跟踪:
 * 1.product-data-service和product-view-service都需要增加 zipkin 的jar包。
 * <dependency>
 * 		<groupId>org.springframework.cloud</groupId>
 * 		<artifactId>spring-cloud-starter-zipkin</artifactId>
 * 	</dependency>
 * 2.数据视图微服务配置文件都需要加
 * spring:
 *   zipkin:
 *     base-url: http://localhost:9411
 * 3.在启动类里配置 Sampler 抽样策略： ALWAYS_SAMPLE 表示持续抽样
 * @Bean
 * public Sampler defaultSampler() {
 * 	return Sampler.ALWAYS_SAMPLE;
 * }
 */
