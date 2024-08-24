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

import com.cl.entity.GuzhangbaoxiuEntity;
import com.cl.entity.view.GuzhangbaoxiuView;

import com.cl.service.GuzhangbaoxiuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 故障报修
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
@RestController
@RequestMapping("/guzhangbaoxiu")
public class GuzhangbaoxiuController {
    @Autowired
    private GuzhangbaoxiuService guzhangbaoxiuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuzhangbaoxiuEntity guzhangbaoxiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			guzhangbaoxiu.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();

		PageUtils page = guzhangbaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guzhangbaoxiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuzhangbaoxiuEntity guzhangbaoxiu, 
		HttpServletRequest request){
        EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();

		PageUtils page = guzhangbaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guzhangbaoxiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuzhangbaoxiuEntity guzhangbaoxiu){
       	EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guzhangbaoxiu, "guzhangbaoxiu")); 
        return R.ok().put("data", guzhangbaoxiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuzhangbaoxiuEntity guzhangbaoxiu){
        EntityWrapper< GuzhangbaoxiuEntity> ew = new EntityWrapper< GuzhangbaoxiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guzhangbaoxiu, "guzhangbaoxiu")); 
		GuzhangbaoxiuView guzhangbaoxiuView =  guzhangbaoxiuService.selectView(ew);
		return R.ok("查询故障报修成功").put("data", guzhangbaoxiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuzhangbaoxiuEntity guzhangbaoxiu = guzhangbaoxiuService.selectById(id);
		guzhangbaoxiu = guzhangbaoxiuService.selectView(new EntityWrapper<GuzhangbaoxiuEntity>().eq("id", id));
        return R.ok().put("data", guzhangbaoxiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuzhangbaoxiuEntity guzhangbaoxiu = guzhangbaoxiuService.selectById(id);
		guzhangbaoxiu = guzhangbaoxiuService.selectView(new EntityWrapper<GuzhangbaoxiuEntity>().eq("id", id));
        return R.ok().put("data", guzhangbaoxiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
    	guzhangbaoxiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guzhangbaoxiu);
        guzhangbaoxiuService.insert(guzhangbaoxiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
    	guzhangbaoxiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guzhangbaoxiu);
        guzhangbaoxiuService.insert(guzhangbaoxiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guzhangbaoxiu);
        guzhangbaoxiuService.updateById(guzhangbaoxiu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guzhangbaoxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yezhu")) {
            guzhangbaoxiu.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();
        int count = guzhangbaoxiuService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guzhangbaoxiu), params), params));
        return R.ok().put("data", count);
    }


}
