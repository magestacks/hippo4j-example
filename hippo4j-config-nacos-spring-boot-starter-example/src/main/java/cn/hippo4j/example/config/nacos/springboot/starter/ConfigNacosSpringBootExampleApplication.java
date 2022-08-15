package cn.hippo4j.example.config.nacos.springboot.starter;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicThreadPool
@SpringBootApplication(scanBasePackages = "cn.hippo4j.example.core")
public class ConfigNacosSpringBootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosSpringBootExampleApplication.class, args);
    }
}
