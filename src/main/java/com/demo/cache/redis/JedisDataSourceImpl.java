package com.demo.cache.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("jdeisDataSource")
public class JedisDataSourceImpl implements JedisDataSource {

    final static Logger LOG = LoggerFactory.getLogger(JedisDataSourceImpl.class);

//    @Resource
    ShardedJedisPool shardedJedisPool;

    @Override
    public ShardedJedis getRedisClient() {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
        } catch (Exception e) {
            LOG.error("[jdeisDataSource] getRedisClient error : {}", e.getMessage(), e);
            if (null != shardedJedis) {
                shardedJedis.close();
            }
        }
        return shardedJedis;
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedis.close();
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        shardedJedis.close();
    }
}
