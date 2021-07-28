package rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 规则
 *
 * @author wangxl
 * @date 2021/7/28 21:37
 */
@Configuration
public class MyRule {

    @Bean
    public IRule rule() {
        // 随机规则
        return new RandomRule();
    }

}
