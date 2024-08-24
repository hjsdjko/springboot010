package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GuzhangbaoxiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GuzhangbaoxiuView;


/**
 * 故障报修
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
public interface GuzhangbaoxiuService extends IService<GuzhangbaoxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuzhangbaoxiuView> selectListView(Wrapper<GuzhangbaoxiuEntity> wrapper);
   	
   	GuzhangbaoxiuView selectView(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuzhangbaoxiuEntity> wrapper);
   	

}

