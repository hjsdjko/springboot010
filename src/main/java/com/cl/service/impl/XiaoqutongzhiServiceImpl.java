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


import com.cl.dao.XiaoqutongzhiDao;
import com.cl.entity.XiaoqutongzhiEntity;
import com.cl.service.XiaoqutongzhiService;
import com.cl.entity.view.XiaoqutongzhiView;

@Service("xiaoqutongzhiService")
public class XiaoqutongzhiServiceImpl extends ServiceImpl<XiaoqutongzhiDao, XiaoqutongzhiEntity> implements XiaoqutongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoqutongzhiEntity> page = this.selectPage(
                new Query<XiaoqutongzhiEntity>(params).getPage(),
                new EntityWrapper<XiaoqutongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoqutongzhiEntity> wrapper) {
		  Page<XiaoqutongzhiView> page =new Query<XiaoqutongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaoqutongzhiView> selectListView(Wrapper<XiaoqutongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoqutongzhiView selectView(Wrapper<XiaoqutongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
