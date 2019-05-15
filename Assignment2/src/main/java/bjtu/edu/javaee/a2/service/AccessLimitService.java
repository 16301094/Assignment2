package bjtu.edu.javaee.a2.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class AccessLimitService {

    //每秒只发出5个令牌
    RateLimiter rateLimiter = RateLimiter.create(5);

    /**
     * 尝试获取令牌
     * @return
     */
    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }
}
