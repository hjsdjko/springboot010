package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FeiyongjiaonaDao;
import com.cl.entity.FeiyongjiaonaEntity;
import com.cl.service.FeiyongjiaonaService;
import com.cl.entity.view.FeiyongjiaonaView;

@Service("feiyongjiaonaService")
public class FeiyongjiaonaServiceImpl extends ServiceImpl<FeiyongjiaonaDao, FeiyongjiaonaEntity> implements FeiyongjiaonaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FeiyongjiaonaEntity> page = this.selectPage(
                new Query<FeiyongjiaonaEntity>(params).getPage(),
                new EntityWrapper<FeiyongjiaonaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FeiyongjiaonaEntity> wrapper) {
		  Page<FeiyongjiaonaView> page =new Query<FeiyongjiaonaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FeiyongjiaonaView> selectListView(Wrapper<FeiyongjiaonaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FeiyongjiaonaView selectView(Wrapper<FeiyongjiaonaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
