package com.example.trial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.List;

/**
 * The type Redis config.
 */
@Configuration
public class RedisConfig {

    @Value("${spring.cache.redis.host}")
    private String host;

    @Value("${spring.cache.redis.port}")
    private Integer port;

    @Value("${spring.cache.redis.database}")
    private Integer dataBase;

    @Value("${spring.cache.redis.connectionTimeout}")
    private Long connectionTimeout;

    @Value("${spring.cache.redis.readTimeOut}")
    private Long readTimeOut;

    @Value("${spring.cache.redis.maxWait}")
    private Long maxWait;

    @Value("${spring.cache.redis.maxIdle}")
    private Integer maxIdle;

    @Value("${spring.cache.redis.minIdle}")
    private Integer minIdle;

    @Value("${spring.cache.redis.maxTotal}")
    private Integer maxTotal;


    /**
     * Jedis pool config jedis pool config.
     *
     * @return the jedis pool config
     */
    @Bean
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        return poolConfig;
    }

    /**
     * Jedis connection factory jedis connection factory.
     *
     * @return the jedis connection factory
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(
                host,
                port
        );

        configuration.setDatabase(dataBase);
        JedisClientConfiguration clientConfiguration =
                JedisClientConfiguration.builder().usePooling().poolConfig(jedisPoolConfig())
                        .and()
                        .connectTimeout(Duration.ofMillis(connectionTimeout))
                        .readTimeout(Duration.ofMillis(readTimeOut))
                        .build();

        return new JedisConnectionFactory(configuration, clientConfiguration);

    }

    /**
     * Redis template redis template.
     *
     * @return the redis template
     */
    @Bean
    RedisTemplate<String, List> redisTemplate() {
        RedisTemplate<String, List> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
