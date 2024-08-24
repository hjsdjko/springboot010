package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheweifenpeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweifenpeiView;


/**
 * 车位分配
 *
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface CheweifenpeiService extends IService<CheweifenpeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheweifenpeiView> selectListView(Wrapper<CheweifenpeiEntity> wrapper);
   	
   	CheweifenpeiView selectView(@Param("ew") Wrapper<CheweifenpeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheweifenpeiEntity> wrapper);
   	

}

