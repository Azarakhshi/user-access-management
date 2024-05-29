package com.amin.config.cache;

import com.amin.config.Properties;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.ClusterRedirectException;
import org.springframework.data.redis.ClusterStateFailureException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.TooManyClusterRedirectionsException;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
@Order(value = HIGHEST_PRECEDENCE)
@Profile("redis")
@Log4j2
public class AppRedisCacheConfiguration implements CacheErrorHandler {

    private final Properties properties;

    public AppRedisCacheConfiguration(Properties properties) {
        this.properties = properties;
    }

    @Bean
    @Primary
    @Profile("!test")
    public RedisCacheManager changeCacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.RedisCacheManagerBuilder.
                fromConnectionFactory(connectionFactory).cacheDefaults(RedisCacheConfiguration.defaultCacheConfig())
                .build();
    }

    @Bean("ttlCacheManager")
    @Profile("!test")
    public RedisCacheManager timeOutCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig().
                        entryTtl(
                                Duration.ofMinutes(properties.getCache().getEhcache().getTimeToLiveSeconds())
                        );

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(connectionFactory).cacheDefaults(redisCacheConfiguration)
                .build();
    }


    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        if (exception instanceof RedisSystemException || exception instanceof TooManyClusterRedirectionsException || exception instanceof ClusterRedirectException || exception instanceof ClusterStateFailureException) {
            log.error(exception.getMessage(), exception);
            return;
        }
        throw exception;
    }

    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        if (exception instanceof RedisSystemException || exception instanceof TooManyClusterRedirectionsException || exception instanceof ClusterRedirectException || exception instanceof ClusterStateFailureException) {
            log.error(exception.getMessage(), exception);
            return;
        }
        throw exception;
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        throw exception;
    }

    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        throw exception;
    }

}
