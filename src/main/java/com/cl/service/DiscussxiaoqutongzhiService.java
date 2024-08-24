package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxiaoqutongzhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiaoqutongzhiView;


/**
 * 小区通知评论表
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface DiscussxiaoqutongzhiService extends IService<DiscussxiaoqutongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiaoqutongzhiView> selectListView(Wrapper<DiscussxiaoqutongzhiEntity> wrapper);
   	
   	DiscussxiaoqutongzhiView selectView(@Param("ew") Wrapper<DiscussxiaoqutongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiaoqutongzhiEntity> wrapper);
   	

}

