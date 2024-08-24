package com.cl.dao;

import com.cl.entity.DiscussxiaoqutongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiaoqutongzhiView;


/**
 * 小区通知评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface DiscussxiaoqutongzhiDao extends BaseMapper<DiscussxiaoqutongzhiEntity> {
	
	List<DiscussxiaoqutongzhiView> selectListView(@Param("ew") Wrapper<DiscussxiaoqutongzhiEntity> wrapper);

	List<DiscussxiaoqutongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiaoqutongzhiEntity> wrapper);
	
	DiscussxiaoqutongzhiView selectView(@Param("ew") Wrapper<DiscussxiaoqutongzhiEntity> wrapper);
	

}
