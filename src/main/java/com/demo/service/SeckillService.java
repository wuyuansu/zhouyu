package com.demo.service;

import com.demo.dto.Exposer;
import com.demo.dto.SeckillExecution;
import com.demo.entity.Seckill;
import com.demo.exception.RepeatKillException;
import com.demo.exception.SeckillCloseException;
import com.demo.exception.SeckillException;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface SeckillService {

    /**
     * 查询全部的秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);

    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;
}

