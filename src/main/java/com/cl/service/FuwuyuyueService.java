package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FuwuyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwuyuyueView;


/**
 * 服务预约
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface FuwuyuyueService extends IService<FuwuyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuyuyueView> selectListView(Wrapper<FuwuyuyueEntity> wrapper);
   	
   	FuwuyuyueView selectView(@Param("ew") Wrapper<FuwuyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuyuyueEntity> wrapper);
   	

}

