package ccn.hippo4j.example.server.springboot.starter;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RequiredArgsConstructor
@EnableDynamicThreadPool
@SpringBootApplication(scanBasePackages = "cn.hippo4j.example.core")
public class ServerSpringBootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerSpringBootExampleApplication.class, args);
    }

    private final Executor messageConsumeDynamicThreadPool;

    private TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal();

    @PostConstruct
    public void test() {
        transmittableThreadLocal.set("123");
        for (int i = 0; i < 3; i++) {
            CompletableFuture.runAsync(() -> System.out.println(transmittableThreadLocal.get()), messageConsumeDynamicThreadPool);
        }
        transmittableThreadLocal.set("1234");
        for (int i = 0; i < 3; i++) {
            CompletableFuture.runAsync(() -> System.out.println(transmittableThreadLocal.get()), messageConsumeDynamicThreadPool);
        }
    }
}
