package com.xxh.fang.Dao;

import org.springframework.stereotype.Repository;

import com.xxh.fang.entity.PayAccountFlowPo;

@Repository
public interface PayAccountFlowDao {

	int addPayAccountFlow(PayAccountFlowPo accountFlowPo);

}
