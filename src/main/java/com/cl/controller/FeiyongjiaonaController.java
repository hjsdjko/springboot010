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

import com.cl.entity.FeiyongjiaonaEntity;
import com.cl.entity.view.FeiyongjiaonaView;

import com.cl.service.FeiyongjiaonaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 费用缴纳
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@RestController
@RequestMapping("/feiyongjiaona")
public class FeiyongjiaonaController {
    @Autowired
    private FeiyongjiaonaService feiyongjiaonaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FeiyongjiaonaEntity feiyongjiaona,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			feiyongjiaona.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FeiyongjiaonaEntity> ew = new EntityWrapper<FeiyongjiaonaEntity>();

		PageUtils page = feiyongjiaonaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongjiaona), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FeiyongjiaonaEntity feiyongjiaona, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			feiyongjiaona.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FeiyongjiaonaEntity> ew = new EntityWrapper<FeiyongjiaonaEntity>();

		PageUtils page = feiyongjiaonaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongjiaona), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FeiyongjiaonaEntity feiyongjiaona){
       	EntityWrapper<FeiyongjiaonaEntity> ew = new EntityWrapper<FeiyongjiaonaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( feiyongjiaona, "feiyongjiaona")); 
        return R.ok().put("data", feiyongjiaonaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FeiyongjiaonaEntity feiyongjiaona){
        EntityWrapper< FeiyongjiaonaEntity> ew = new EntityWrapper< FeiyongjiaonaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( feiyongjiaona, "feiyongjiaona")); 
		FeiyongjiaonaView feiyongjiaonaView =  feiyongjiaonaService.selectView(ew);
		return R.ok("查询费用缴纳成功").put("data", feiyongjiaonaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FeiyongjiaonaEntity feiyongjiaona = feiyongjiaonaService.selectById(id);
		feiyongjiaona = feiyongjiaonaService.selectView(new EntityWrapper<FeiyongjiaonaEntity>().eq("id", id));
        return R.ok().put("data", feiyongjiaona);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FeiyongjiaonaEntity feiyongjiaona = feiyongjiaonaService.selectById(id);
		feiyongjiaona = feiyongjiaonaService.selectView(new EntityWrapper<FeiyongjiaonaEntity>().eq("id", id));
        return R.ok().put("data", feiyongjiaona);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeiyongjiaonaEntity feiyongjiaona, HttpServletRequest request){
    	feiyongjiaona.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(feiyongjiaona);
        feiyongjiaonaService.insert(feiyongjiaona);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FeiyongjiaonaEntity feiyongjiaona, HttpServletRequest request){
    	feiyongjiaona.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(feiyongjiaona);
    	feiyongjiaona.setUserid((Long)request.getSession().getAttribute("userId"));
        feiyongjiaonaService.insert(feiyongjiaona);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FeiyongjiaonaEntity feiyongjiaona, HttpServletRequest request){
        //ValidatorUtils.validateEntity(feiyongjiaona);
        feiyongjiaonaService.updateById(feiyongjiaona);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        feiyongjiaonaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,FeiyongjiaonaEntity feiyongjiaona, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            feiyongjiaona.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<FeiyongjiaonaEntity> ew = new EntityWrapper<FeiyongjiaonaEntity>();
        int count = feiyongjiaonaService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongjiaona), params), params));
        return R.ok().put("data", count);
    }


}
