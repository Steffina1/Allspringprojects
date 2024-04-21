package com.cloudvendor.restapidemo.config;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.time.Duration;

@Configuration
public class EhCcaheConfig {

    @Bean
    public CacheManager CacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
      CacheManager cacheManager= provider.getCacheManager();
        CacheConfiguration<Integer, Object> configuration=CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, Object.class, ResourcePoolsBuilder
                .heap(100)
                .offheap(10, MemoryUnit.MB))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(10)))
                        .build();
       javax.cache.configuration.Configuration<Integer, Object> cacheConfig= Eh107Configuration.fromEhcacheCacheConfiguration(configuration);
       cacheManager.createCache("", cacheConfig);
       return cacheManager;
    }

}
