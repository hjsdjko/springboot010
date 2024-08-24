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


import com.cl.dao.WeixiujinduDao;
import com.cl.entity.WeixiujinduEntity;
import com.cl.service.WeixiujinduService;
import com.cl.entity.view.WeixiujinduView;

@Service("weixiujinduService")
public class WeixiujinduServiceImpl extends ServiceImpl<WeixiujinduDao, WeixiujinduEntity> implements WeixiujinduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiujinduEntity> page = this.selectPage(
                new Query<WeixiujinduEntity>(params).getPage(),
                new EntityWrapper<WeixiujinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiujinduEntity> wrapper) {
		  Page<WeixiujinduView> page =new Query<WeixiujinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeixiujinduView> selectListView(Wrapper<WeixiujinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiujinduView selectView(Wrapper<WeixiujinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
