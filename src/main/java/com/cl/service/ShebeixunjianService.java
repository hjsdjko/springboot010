package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShebeixunjianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeixunjianView;


/**
 * 设备巡检
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
public interface ShebeixunjianService extends IService<ShebeixunjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeixunjianView> selectListView(Wrapper<ShebeixunjianEntity> wrapper);
   	
   	ShebeixunjianView selectView(@Param("ew") Wrapper<ShebeixunjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeixunjianEntity> wrapper);
   	

}

