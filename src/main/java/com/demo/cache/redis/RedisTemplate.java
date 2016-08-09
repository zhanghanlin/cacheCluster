package com.demo.cache.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;

@Repository
public class RedisTemplate {

    final static Logger LOG = LoggerFactory.getLogger(RedisTemplate.class);

    @Resource
    JedisDataSource jedisDataSource;

    public void disconnect() {
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        shardedJedis.disconnect();
    }

    /**
     * 设置单个值
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        String result = null;

        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 获取单个值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }

        boolean broken = false;
        try {
            result = shardedJedis.get(key);

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Boolean exists(String key) {
        Boolean result = false;
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.exists(key);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public String type(String key) {
        String result = null;
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.type(key);

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 在某段时间后失效
     *
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, int seconds) {
        Long result = null;
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expire(key, seconds);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 在某个时间点失效
     *
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(String key, long unixTime) {
        Long result = null;
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expireAt(key, unixTime);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Long ttl(String key) {
        Long result = null;
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.ttl(key);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public boolean setbit(String key, long offset, boolean value) {
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        boolean result = false;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setbit(key, offset, value);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public boolean getbit(String key, long offset) {
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        boolean result = false;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getbit(key, offset);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public long setRange(String key, long offset, String value) {
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        long result = 0;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setrange(key, offset, value);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public String getRange(String key, long startOffset, long endOffset) {
        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getrange(key, startOffset, endOffset);

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            broken = true;
        } finally {
            jedisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }
}