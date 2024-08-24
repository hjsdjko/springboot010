package com.cl.dao;

import com.cl.entity.DiscussshequxinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshequxinwenView;


/**
 * 社区新闻评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface DiscussshequxinwenDao extends BaseMapper<DiscussshequxinwenEntity> {
	
	List<DiscussshequxinwenView> selectListView(@Param("ew") Wrapper<DiscussshequxinwenEntity> wrapper);

	List<DiscussshequxinwenView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshequxinwenEntity> wrapper);
	
	DiscussshequxinwenView selectView(@Param("ew") Wrapper<DiscussshequxinwenEntity> wrapper);
	

}
