package com.cl.dao;

import com.cl.entity.XiaoqutongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoqutongzhiView;


/**
 * 小区通知
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface XiaoqutongzhiDao extends BaseMapper<XiaoqutongzhiEntity> {
	
	List<XiaoqutongzhiView> selectListView(@Param("ew") Wrapper<XiaoqutongzhiEntity> wrapper);

	List<XiaoqutongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoqutongzhiEntity> wrapper);
	
	XiaoqutongzhiView selectView(@Param("ew") Wrapper<XiaoqutongzhiEntity> wrapper);
	

}
