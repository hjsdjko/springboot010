package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.WeixiujinduEntity;
import com.cl.entity.view.WeixiujinduView;

import com.cl.service.WeixiujinduService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修进度
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@RestController
@RequestMapping("/weixiujindu")
public class WeixiujinduController {
    @Autowired
    private WeixiujinduService weixiujinduService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiujinduEntity weixiujindu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			weixiujindu.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiujinduEntity> ew = new EntityWrapper<WeixiujinduEntity>();

		PageUtils page = weixiujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiujindu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiujinduEntity weixiujindu, 
		HttpServletRequest request){
        EntityWrapper<WeixiujinduEntity> ew = new EntityWrapper<WeixiujinduEntity>();

		PageUtils page = weixiujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiujindu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiujinduEntity weixiujindu){
       	EntityWrapper<WeixiujinduEntity> ew = new EntityWrapper<WeixiujinduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiujindu, "weixiujindu")); 
        return R.ok().put("data", weixiujinduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiujinduEntity weixiujindu){
        EntityWrapper< WeixiujinduEntity> ew = new EntityWrapper< WeixiujinduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiujindu, "weixiujindu")); 
		WeixiujinduView weixiujinduView =  weixiujinduService.selectView(ew);
		return R.ok("查询维修进度成功").put("data", weixiujinduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiujinduEntity weixiujindu = weixiujinduService.selectById(id);
		weixiujindu = weixiujinduService.selectView(new EntityWrapper<WeixiujinduEntity>().eq("id", id));
        return R.ok().put("data", weixiujindu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiujinduEntity weixiujindu = weixiujinduService.selectById(id);
		weixiujindu = weixiujinduService.selectView(new EntityWrapper<WeixiujinduEntity>().eq("id", id));
        return R.ok().put("data", weixiujindu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiujinduEntity weixiujindu, HttpServletRequest request){
    	weixiujindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiujindu);
        weixiujinduService.insert(weixiujindu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiujinduEntity weixiujindu, HttpServletRequest request){
    	weixiujindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiujindu);
        weixiujinduService.insert(weixiujindu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiujinduEntity weixiujindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiujindu);
        weixiujinduService.updateById(weixiujindu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiujinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
