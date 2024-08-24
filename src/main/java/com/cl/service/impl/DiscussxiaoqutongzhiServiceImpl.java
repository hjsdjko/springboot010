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


import com.cl.dao.DiscussxiaoqutongzhiDao;
import com.cl.entity.DiscussxiaoqutongzhiEntity;
import com.cl.service.DiscussxiaoqutongzhiService;
import com.cl.entity.view.DiscussxiaoqutongzhiView;

@Service("discussxiaoqutongzhiService")
public class DiscussxiaoqutongzhiServiceImpl extends ServiceImpl<DiscussxiaoqutongzhiDao, DiscussxiaoqutongzhiEntity> implements DiscussxiaoqutongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiaoqutongzhiEntity> page = this.selectPage(
                new Query<DiscussxiaoqutongzhiEntity>(params).getPage(),
                new EntityWrapper<DiscussxiaoqutongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiaoqutongzhiEntity> wrapper) {
		  Page<DiscussxiaoqutongzhiView> page =new Query<DiscussxiaoqutongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxiaoqutongzhiView> selectListView(Wrapper<DiscussxiaoqutongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiaoqutongzhiView selectView(Wrapper<DiscussxiaoqutongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
