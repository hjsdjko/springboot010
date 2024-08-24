package com.cl.dao;

import com.cl.entity.FeiyongjiaonaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FeiyongjiaonaView;


/**
 * 费用缴纳
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface FeiyongjiaonaDao extends BaseMapper<FeiyongjiaonaEntity> {
	
	List<FeiyongjiaonaView> selectListView(@Param("ew") Wrapper<FeiyongjiaonaEntity> wrapper);

	List<FeiyongjiaonaView> selectListView(Pagination page,@Param("ew") Wrapper<FeiyongjiaonaEntity> wrapper);
	
	FeiyongjiaonaView selectView(@Param("ew") Wrapper<FeiyongjiaonaEntity> wrapper);
	

}
