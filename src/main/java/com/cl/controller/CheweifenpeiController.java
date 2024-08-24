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

import com.cl.entity.CheweifenpeiEntity;
import com.cl.entity.view.CheweifenpeiView;

import com.cl.service.CheweifenpeiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 车位分配
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@RestController
@RequestMapping("/cheweifenpei")
public class CheweifenpeiController {
    @Autowired
    private CheweifenpeiService cheweifenpeiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheweifenpeiEntity cheweifenpei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			cheweifenpei.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheweifenpeiEntity> ew = new EntityWrapper<CheweifenpeiEntity>();

		PageUtils page = cheweifenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweifenpei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheweifenpeiEntity cheweifenpei, 
		HttpServletRequest request){
        EntityWrapper<CheweifenpeiEntity> ew = new EntityWrapper<CheweifenpeiEntity>();

		PageUtils page = cheweifenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweifenpei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheweifenpeiEntity cheweifenpei){
       	EntityWrapper<CheweifenpeiEntity> ew = new EntityWrapper<CheweifenpeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheweifenpei, "cheweifenpei")); 
        return R.ok().put("data", cheweifenpeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheweifenpeiEntity cheweifenpei){
        EntityWrapper< CheweifenpeiEntity> ew = new EntityWrapper< CheweifenpeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheweifenpei, "cheweifenpei")); 
		CheweifenpeiView cheweifenpeiView =  cheweifenpeiService.selectView(ew);
		return R.ok("查询车位分配成功").put("data", cheweifenpeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheweifenpeiEntity cheweifenpei = cheweifenpeiService.selectById(id);
		cheweifenpei = cheweifenpeiService.selectView(new EntityWrapper<CheweifenpeiEntity>().eq("id", id));
        return R.ok().put("data", cheweifenpei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheweifenpeiEntity cheweifenpei = cheweifenpeiService.selectById(id);
		cheweifenpei = cheweifenpeiService.selectView(new EntityWrapper<CheweifenpeiEntity>().eq("id", id));
        return R.ok().put("data", cheweifenpei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheweifenpeiEntity cheweifenpei, HttpServletRequest request){
    	cheweifenpei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweifenpei);
        cheweifenpeiService.insert(cheweifenpei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheweifenpeiEntity cheweifenpei, HttpServletRequest request){
    	cheweifenpei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweifenpei);
        cheweifenpeiService.insert(cheweifenpei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheweifenpeiEntity cheweifenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheweifenpei);
        cheweifenpeiService.updateById(cheweifenpei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheweifenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
