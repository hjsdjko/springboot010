package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 费用缴纳
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@TableName("feiyongjiaona")
public class FeiyongjiaonaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FeiyongjiaonaEntity() {
		
	}
	
	public FeiyongjiaonaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 缴费编号
	 */
					
	private String jiaofeibianhao;
	
	/**
	 * 业主账号
	 */
					
	private String yezhuzhanghao;
	
	/**
	 * 业主姓名
	 */
					
	private String yezhuxingming;
	
	/**
	 * 住址
	 */
					
	private String zhuzhi;
	
	/**
	 * 年月
	 */
					
	private String nianyue;
	
	/**
	 * 电费
	 */
					
	private Double dianfei;
	
	/**
	 * 水费
	 */
					
	private Double shuifei;
	
	/**
	 * 物业费
	 */
					
	private Double wuyefei;
	
	/**
	 * 停车费
	 */
					
	private Double tingchefei;
	
	/**
	 * 应付费用
	 */
					
	private Double yingfufeiyong;
	
	/**
	 * 缴费日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiaofeiriqi;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：缴费编号
	 */
	public void setJiaofeibianhao(String jiaofeibianhao) {
		this.jiaofeibianhao = jiaofeibianhao;
	}
	/**
	 * 获取：缴费编号
	 */
	public String getJiaofeibianhao() {
		return jiaofeibianhao;
	}
	/**
	 * 设置：业主账号
	 */
	public void setYezhuzhanghao(String yezhuzhanghao) {
		this.yezhuzhanghao = yezhuzhanghao;
	}
	/**
	 * 获取：业主账号
	 */
	public String getYezhuzhanghao() {
		return yezhuzhanghao;
	}
	/**
	 * 设置：业主姓名
	 */
	public void setYezhuxingming(String yezhuxingming) {
		this.yezhuxingming = yezhuxingming;
	}
	/**
	 * 获取：业主姓名
	 */
	public String getYezhuxingming() {
		return yezhuxingming;
	}
	/**
	 * 设置：住址
	 */
	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}
	/**
	 * 获取：住址
	 */
	public String getZhuzhi() {
		return zhuzhi;
	}
	/**
	 * 设置：年月
	 */
	public void setNianyue(String nianyue) {
		this.nianyue = nianyue;
	}
	/**
	 * 获取：年月
	 */
	public String getNianyue() {
		return nianyue;
	}
	/**
	 * 设置：电费
	 */
	public void setDianfei(Double dianfei) {
		this.dianfei = dianfei;
	}
	/**
	 * 获取：电费
	 */
	public Double getDianfei() {
		return dianfei;
	}
	/**
	 * 设置：水费
	 */
	public void setShuifei(Double shuifei) {
		this.shuifei = shuifei;
	}
	/**
	 * 获取：水费
	 */
	public Double getShuifei() {
		return shuifei;
	}
	/**
	 * 设置：物业费
	 */
	public void setWuyefei(Double wuyefei) {
		this.wuyefei = wuyefei;
	}
	/**
	 * 获取：物业费
	 */
	public Double getWuyefei() {
		return wuyefei;
	}
	/**
	 * 设置：停车费
	 */
	public void setTingchefei(Double tingchefei) {
		this.tingchefei = tingchefei;
	}
	/**
	 * 获取：停车费
	 */
	public Double getTingchefei() {
		return tingchefei;
	}
	/**
	 * 设置：应付费用
	 */
	public void setYingfufeiyong(Double yingfufeiyong) {
		this.yingfufeiyong = yingfufeiyong;
	}
	/**
	 * 获取：应付费用
	 */
	public Double getYingfufeiyong() {
		return yingfufeiyong;
	}
	/**
	 * 设置：缴费日期
	 */
	public void setJiaofeiriqi(Date jiaofeiriqi) {
		this.jiaofeiriqi = jiaofeiriqi;
	}
	/**
	 * 获取：缴费日期
	 */
	public Date getJiaofeiriqi() {
		return jiaofeiriqi;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
