package com.cl.dao;

import com.cl.entity.FuwuyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwuyuyueView;


/**
 * 服务预约
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface FuwuyuyueDao extends BaseMapper<FuwuyuyueEntity> {
	
	List<FuwuyuyueView> selectListView(@Param("ew") Wrapper<FuwuyuyueEntity> wrapper);

	List<FuwuyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuyuyueEntity> wrapper);
	
	FuwuyuyueView selectView(@Param("ew") Wrapper<FuwuyuyueEntity> wrapper);
	

}
