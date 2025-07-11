package stirling.software.proprietary.security;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import stirling.software.proprietary.security.filter.IPRateLimitingFilter;

@Component
@RequiredArgsConstructor
public class RateLimitResetScheduler {

    private final IPRateLimitingFilter rateLimitingFilter;

    @Scheduled(cron = "0 0 0 * * MON") // At 00:00 every Monday TODO: configurable
    public void resetRateLimit() {
        rateLimitingFilter.resetRequestCounts();
    }
}
