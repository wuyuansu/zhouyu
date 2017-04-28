package com.demo.dao;

import com.demo.entity.Seckill;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/4/25.
 */
public class RedisDao {
    private JedisPool jedisPool;
    public RedisDao(String ip, int port){jedisPool=new JedisPool(ip,port);}
    private RuntimeSchema<Seckill> schema=RuntimeSchema.createFrom(Seckill.class);

    public String pubSeckill(Seckill seckill){
        try{
            Jedis jedis=jedisPool.getResource();
            try{String key="seckill:" + seckill.getSeckillId();
            byte[] bytes= ProtobufIOUtil.toByteArray(seckill,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            int timeout=60*60;
            String result=jedis.setex(key.getBytes(),timeout,bytes);
            return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){}return null;
    }

    public Seckill getSeckill(long seckillId){
        Jedis jedis=jedisPool.getResource();
        try {
            String key="seckill:"+seckillId;
        try{
            byte[] bytes=jedis.get(key.getBytes());
            if (bytes!=null){
                Seckill seckill=schema.newMessage();
                ProtobufIOUtil.mergeFrom(bytes,seckill,schema);
                return seckill;}
            }finally {
            jedis.close();
        }
        }catch (Exception e){}return null;
    }
}
