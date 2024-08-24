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


import com.cl.dao.DiscussshequxinwenDao;
import com.cl.entity.DiscussshequxinwenEntity;
import com.cl.service.DiscussshequxinwenService;
import com.cl.entity.view.DiscussshequxinwenView;

@Service("discussshequxinwenService")
public class DiscussshequxinwenServiceImpl extends ServiceImpl<DiscussshequxinwenDao, DiscussshequxinwenEntity> implements DiscussshequxinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshequxinwenEntity> page = this.selectPage(
                new Query<DiscussshequxinwenEntity>(params).getPage(),
                new EntityWrapper<DiscussshequxinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshequxinwenEntity> wrapper) {
		  Page<DiscussshequxinwenView> page =new Query<DiscussshequxinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshequxinwenView> selectListView(Wrapper<DiscussshequxinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshequxinwenView selectView(Wrapper<DiscussshequxinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
