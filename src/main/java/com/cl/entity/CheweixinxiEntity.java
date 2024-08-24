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
 * 车位信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@TableName("cheweixinxi")
public class CheweixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CheweixinxiEntity() {
		
	}
	
	public CheweixinxiEntity(T t) {
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
	 * 车位位置
	 */
					
	private String cheweiweizhi;
	
	/**
	 * 车位图片
	 */
					
	private String cheweitupian;
	
	/**
	 * 车位号
	 */
					
	private String cheweihao;
	
	/**
	 * 月停车费
	 */
					
	private Double yuetingchefei;
	
	/**
	 * 车位状态
	 */
					
	private String cheweizhuangtai;
	
	
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
	 * 设置：车位位置
	 */
	public void setCheweiweizhi(String cheweiweizhi) {
		this.cheweiweizhi = cheweiweizhi;
	}
	/**
	 * 获取：车位位置
	 */
	public String getCheweiweizhi() {
		return cheweiweizhi;
	}
	/**
	 * 设置：车位图片
	 */
	public void setCheweitupian(String cheweitupian) {
		this.cheweitupian = cheweitupian;
	}
	/**
	 * 获取：车位图片
	 */
	public String getCheweitupian() {
		return cheweitupian;
	}
	/**
	 * 设置：车位号
	 */
	public void setCheweihao(String cheweihao) {
		this.cheweihao = cheweihao;
	}
	/**
	 * 获取：车位号
	 */
	public String getCheweihao() {
		return cheweihao;
	}
	/**
	 * 设置：月停车费
	 */
	public void setYuetingchefei(Double yuetingchefei) {
		this.yuetingchefei = yuetingchefei;
	}
	/**
	 * 获取：月停车费
	 */
	public Double getYuetingchefei() {
		return yuetingchefei;
	}
	/**
	 * 设置：车位状态
	 */
	public void setCheweizhuangtai(String cheweizhuangtai) {
		this.cheweizhuangtai = cheweizhuangtai;
	}
	/**
	 * 获取：车位状态
	 */
	public String getCheweizhuangtai() {
		return cheweizhuangtai;
	}

}
