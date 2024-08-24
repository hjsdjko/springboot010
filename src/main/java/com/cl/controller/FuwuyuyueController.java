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

import com.cl.entity.FuwuyuyueEntity;
import com.cl.entity.view.FuwuyuyueView;

import com.cl.service.FuwuyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@RestController
@RequestMapping("/fuwuyuyue")
public class FuwuyuyueController {
    @Autowired
    private FuwuyuyueService fuwuyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuyuyueEntity fuwuyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			fuwuyuyue.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();

		PageUtils page = fuwuyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwuyuyueEntity fuwuyuyue, 
		HttpServletRequest request){
        EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();

		PageUtils page = fuwuyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuyuyueEntity fuwuyuyue){
       	EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuyuyue, "fuwuyuyue")); 
        return R.ok().put("data", fuwuyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuyuyueEntity fuwuyuyue){
        EntityWrapper< FuwuyuyueEntity> ew = new EntityWrapper< FuwuyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuyuyue, "fuwuyuyue")); 
		FuwuyuyueView fuwuyuyueView =  fuwuyuyueService.selectView(ew);
		return R.ok("查询服务预约成功").put("data", fuwuyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuyuyueEntity fuwuyuyue = fuwuyuyueService.selectById(id);
		fuwuyuyue = fuwuyuyueService.selectView(new EntityWrapper<FuwuyuyueEntity>().eq("id", id));
        return R.ok().put("data", fuwuyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuyuyueEntity fuwuyuyue = fuwuyuyueService.selectById(id);
		fuwuyuyue = fuwuyuyueService.selectView(new EntityWrapper<FuwuyuyueEntity>().eq("id", id));
        return R.ok().put("data", fuwuyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
    	fuwuyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwuyuyue);
        fuwuyuyueService.insert(fuwuyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
    	fuwuyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwuyuyue);
        fuwuyuyueService.insert(fuwuyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuyuyue);
        fuwuyuyueService.updateById(fuwuyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwuyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            fuwuyuyue.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();
        int count = fuwuyuyueService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuyuyue), params), params));
        return R.ok().put("data", count);
    }


}
