package com.cl.dao;

import com.cl.entity.CheweifenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweifenpeiView;


/**
 * 车位分配
 * 
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
public interface CheweifenpeiDao extends BaseMapper<CheweifenpeiEntity> {
	
	List<CheweifenpeiView> selectListView(@Param("ew") Wrapper<CheweifenpeiEntity> wrapper);

	List<CheweifenpeiView> selectListView(Pagination page,@Param("ew") Wrapper<CheweifenpeiEntity> wrapper);
	
	CheweifenpeiView selectView(@Param("ew") Wrapper<CheweifenpeiEntity> wrapper);
	

}
