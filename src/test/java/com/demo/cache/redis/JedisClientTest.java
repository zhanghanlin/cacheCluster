package com.demo.cache.redis;

import com.demo.cache.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@FixMethodOrder(MethodSorters.JVM)
public class JedisClientTest extends BaseTest {

    static final Logger LOG = LoggerFactory.getLogger(JedisClientTest.class);

    @Resource
    JedisClient jedisClient;

    @Test
    public void testSet() {
        String res = jedisClient.set("test", "testVal");
        LOG.info("set : {}", res);
    }

    @Test
    public void testGet() {
        String res = jedisClient.get("test");
        LOG.info("get : {}", res);
    }

    @Test
    public void testHSet() {
        Long res = jedisClient.hset("htest", "htest item", "htest val");
        LOG.info("hset : {}", res);
    }

    @Test
    public void testHGet() {
        String res = jedisClient.hget("htest", "htest item");
        LOG.info("hget : {}", res);
    }

    @Test
    public void testHDel() {
        Long res = jedisClient.hdel("htest", "htest item");
        LOG.info("hdel : {}", res);
    }
}
