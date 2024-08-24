package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshequxinwenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshequxinwenView;


/**
 * 社区新闻评论表
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface DiscussshequxinwenService extends IService<DiscussshequxinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshequxinwenView> selectListView(Wrapper<DiscussshequxinwenEntity> wrapper);
   	
   	DiscussshequxinwenView selectView(@Param("ew") Wrapper<DiscussshequxinwenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshequxinwenEntity> wrapper);
   	

}

