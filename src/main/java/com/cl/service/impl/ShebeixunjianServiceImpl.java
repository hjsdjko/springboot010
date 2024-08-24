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


import com.cl.dao.ShebeixunjianDao;
import com.cl.entity.ShebeixunjianEntity;
import com.cl.service.ShebeixunjianService;
import com.cl.entity.view.ShebeixunjianView;

@Service("shebeixunjianService")
public class ShebeixunjianServiceImpl extends ServiceImpl<ShebeixunjianDao, ShebeixunjianEntity> implements ShebeixunjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeixunjianEntity> page = this.selectPage(
                new Query<ShebeixunjianEntity>(params).getPage(),
                new EntityWrapper<ShebeixunjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeixunjianEntity> wrapper) {
		  Page<ShebeixunjianView> page =new Query<ShebeixunjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShebeixunjianView> selectListView(Wrapper<ShebeixunjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeixunjianView selectView(Wrapper<ShebeixunjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
