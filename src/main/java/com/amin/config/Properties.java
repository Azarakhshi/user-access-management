package com.amin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
@Getter
@Setter
public class Properties {

    private Cache cache = new Cache();

    @Getter
    public static class Cache {
        private Ehcache ehcache = new Ehcache();
        private Redis redis = new Redis();


        @Getter
        @Setter
        public static class Ehcache {
            private int timeToLiveSeconds = Defaults.cache.Ehcache.timeToLiveSeconds;
            private long maxEntries = Defaults.cache.Ehcache.maxEntries;
        }


        @Getter
        @Setter
        public static class Redis {
            private String[] server = Defaults.cache.redis.server;
            private int expiration = Defaults.cache.redis.expiration;
            private boolean cluster = Defaults.cache.redis.cluster;
            private int connectionPoolSize = Defaults.cache.redis.connectionPoolSize;
            private int connectionMinimumIdSize = Defaults.cache.redis.connectionMinimumIdSize;
            private int subScriptConnectionPoolSize = Defaults.cache.redis.subScriptConnectionPoolSize;
            private int subScriptConnectionMinimumIdSize = Defaults.cache.redis.subScriptConnectionMinimumIdSize;
        }
    }

}
