package com.cl.dao;

import com.cl.entity.ShebeixunjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeixunjianView;


/**
 * 设备巡检
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
public interface ShebeixunjianDao extends BaseMapper<ShebeixunjianEntity> {
	
	List<ShebeixunjianView> selectListView(@Param("ew") Wrapper<ShebeixunjianEntity> wrapper);

	List<ShebeixunjianView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeixunjianEntity> wrapper);
	
	ShebeixunjianView selectView(@Param("ew") Wrapper<ShebeixunjianEntity> wrapper);
	

}
