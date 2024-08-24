package com.cl.dao;

import com.cl.entity.WeixiujinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiujinduView;


/**
 * 维修进度
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface WeixiujinduDao extends BaseMapper<WeixiujinduEntity> {
	
	List<WeixiujinduView> selectListView(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);

	List<WeixiujinduView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
	
	WeixiujinduView selectView(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
	

}
