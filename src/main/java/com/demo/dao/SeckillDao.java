package com.demo.dao;

import com.demo.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface SeckillDao {


    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);


    Seckill queryById(long seckillId);


    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);



}

