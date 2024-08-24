package com.cl.dao;

import com.cl.entity.GuzhangbaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GuzhangbaoxiuView;


/**
 * 故障报修
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
public interface GuzhangbaoxiuDao extends BaseMapper<GuzhangbaoxiuEntity> {
	
	List<GuzhangbaoxiuView> selectListView(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);

	List<GuzhangbaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
	
	GuzhangbaoxiuView selectView(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
	

}
