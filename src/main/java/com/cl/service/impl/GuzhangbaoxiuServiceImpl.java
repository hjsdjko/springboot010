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


import com.cl.dao.GuzhangbaoxiuDao;
import com.cl.entity.GuzhangbaoxiuEntity;
import com.cl.service.GuzhangbaoxiuService;
import com.cl.entity.view.GuzhangbaoxiuView;

@Service("guzhangbaoxiuService")
public class GuzhangbaoxiuServiceImpl extends ServiceImpl<GuzhangbaoxiuDao, GuzhangbaoxiuEntity> implements GuzhangbaoxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuzhangbaoxiuEntity> page = this.selectPage(
                new Query<GuzhangbaoxiuEntity>(params).getPage(),
                new EntityWrapper<GuzhangbaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuzhangbaoxiuEntity> wrapper) {
		  Page<GuzhangbaoxiuView> page =new Query<GuzhangbaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GuzhangbaoxiuView> selectListView(Wrapper<GuzhangbaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuzhangbaoxiuView selectView(Wrapper<GuzhangbaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
