package com.coding;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuelu
 * 2019/11/25.
 */
public class RedisClusterTest {

    public static void main(String[] args) {
        Set<HostAndPort> hosts = new HashSet<>();
        hosts.add(HostAndPort.parseString("localhost:7000"));
        Jedis jedis = new Jedis("127.0.0.1", 32768);
        String resp = jedis.set("lock:xue:name", "xxx", "NX", "PX", 5000);
        System.out.println("resp:"+resp);
        System.out.println("lock 1st success!");
        String value = jedis.get("lock:xue:name");
        System.out.println(value);

        resp = jedis.set("lock:xue:name", "xxx", "NX", "PX", 5000);
        System.out.println("lock 2ed success!");
        System.out.println("resp:"+resp);
    }
}
