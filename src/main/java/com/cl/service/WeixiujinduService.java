package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiujinduEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiujinduView;


/**
 * 维修进度
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface WeixiujinduService extends IService<WeixiujinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiujinduView> selectListView(Wrapper<WeixiujinduEntity> wrapper);
   	
   	WeixiujinduView selectView(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiujinduEntity> wrapper);
   	

}

