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

import com.cl.entity.ShebeixunjianEntity;
import com.cl.entity.view.ShebeixunjianView;

import com.cl.service.ShebeixunjianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备巡检
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
@RestController
@RequestMapping("/shebeixunjian")
public class ShebeixunjianController {
    @Autowired
    private ShebeixunjianService shebeixunjianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeixunjianEntity shebeixunjian,
		HttpServletRequest request){
        EntityWrapper<ShebeixunjianEntity> ew = new EntityWrapper<ShebeixunjianEntity>();

		PageUtils page = shebeixunjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeixunjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeixunjianEntity shebeixunjian, 
		HttpServletRequest request){
        EntityWrapper<ShebeixunjianEntity> ew = new EntityWrapper<ShebeixunjianEntity>();

		PageUtils page = shebeixunjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeixunjian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeixunjianEntity shebeixunjian){
       	EntityWrapper<ShebeixunjianEntity> ew = new EntityWrapper<ShebeixunjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeixunjian, "shebeixunjian")); 
        return R.ok().put("data", shebeixunjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeixunjianEntity shebeixunjian){
        EntityWrapper< ShebeixunjianEntity> ew = new EntityWrapper< ShebeixunjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeixunjian, "shebeixunjian")); 
		ShebeixunjianView shebeixunjianView =  shebeixunjianService.selectView(ew);
		return R.ok("查询设备巡检成功").put("data", shebeixunjianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeixunjianEntity shebeixunjian = shebeixunjianService.selectById(id);
		shebeixunjian = shebeixunjianService.selectView(new EntityWrapper<ShebeixunjianEntity>().eq("id", id));
        return R.ok().put("data", shebeixunjian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeixunjianEntity shebeixunjian = shebeixunjianService.selectById(id);
		shebeixunjian = shebeixunjianService.selectView(new EntityWrapper<ShebeixunjianEntity>().eq("id", id));
        return R.ok().put("data", shebeixunjian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeixunjianEntity shebeixunjian, HttpServletRequest request){
    	shebeixunjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeixunjian);
        shebeixunjianService.insert(shebeixunjian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeixunjianEntity shebeixunjian, HttpServletRequest request){
    	shebeixunjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeixunjian);
        shebeixunjianService.insert(shebeixunjian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeixunjianEntity shebeixunjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeixunjian);
        shebeixunjianService.updateById(shebeixunjian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeixunjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
