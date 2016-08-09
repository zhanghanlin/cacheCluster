package com.demo.cache.redis;

public interface JedisClient {

    String set(String key, String value);

    String get(String key);

    Long hset(String key, String item, String value);

    String hget(String key, String item);

    Long hdel(String key, String item);

    Long incr(String key);

    Long decr(String key);

    /**
     * @param key
     * @param second
     * @return
     * @Description: 设置存存活时间
     */
    Long expire(String key, int second);

    /**
     * @param key
     * @return 秒
     * >= 0     剩余秒数
     * = -1    永久存活
     * = -2    已经消除
     * @Description: 判断key多久过期
     */
    Long ttl(String key);
}
