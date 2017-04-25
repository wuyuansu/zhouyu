package com.demo.dao;

import com.demo.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface SuccessKilledDao {


    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);


    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}

