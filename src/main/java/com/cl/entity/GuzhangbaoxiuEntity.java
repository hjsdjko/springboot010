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
 * 故障报修
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
@TableName("guzhangbaoxiu")
public class GuzhangbaoxiuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GuzhangbaoxiuEntity() {
		
	}
	
	public GuzhangbaoxiuEntity(T t) {
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
	 * 报修编号
	 */
					
	private String baoxiubianhao;
	
	/**
	 * 设备名称
	 */
					
	private String shebeimingcheng;
	
	/**
	 * 设备型号
	 */
					
	private String shebeixinghao;
	
	/**
	 * 设备类型
	 */
					
	private String shebeileixing;
	
	/**
	 * 设备位置
	 */
					
	private String shebeiweizhi;
	
	/**
	 * 故障情况
	 */
					
	private String guzhangqingkuang;
	
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
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	/**
	 * 申请日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingriqi;
	
	
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
	 * 设置：报修编号
	 */
	public void setBaoxiubianhao(String baoxiubianhao) {
		this.baoxiubianhao = baoxiubianhao;
	}
	/**
	 * 获取：报修编号
	 */
	public String getBaoxiubianhao() {
		return baoxiubianhao;
	}
	/**
	 * 设置：设备名称
	 */
	public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
	}
	/**
	 * 获取：设备名称
	 */
	public String getShebeimingcheng() {
		return shebeimingcheng;
	}
	/**
	 * 设置：设备型号
	 */
	public void setShebeixinghao(String shebeixinghao) {
		this.shebeixinghao = shebeixinghao;
	}
	/**
	 * 获取：设备型号
	 */
	public String getShebeixinghao() {
		return shebeixinghao;
	}
	/**
	 * 设置：设备类型
	 */
	public void setShebeileixing(String shebeileixing) {
		this.shebeileixing = shebeileixing;
	}
	/**
	 * 获取：设备类型
	 */
	public String getShebeileixing() {
		return shebeileixing;
	}
	/**
	 * 设置：设备位置
	 */
	public void setShebeiweizhi(String shebeiweizhi) {
		this.shebeiweizhi = shebeiweizhi;
	}
	/**
	 * 获取：设备位置
	 */
	public String getShebeiweizhi() {
		return shebeiweizhi;
	}
	/**
	 * 设置：故障情况
	 */
	public void setGuzhangqingkuang(String guzhangqingkuang) {
		this.guzhangqingkuang = guzhangqingkuang;
	}
	/**
	 * 获取：故障情况
	 */
	public String getGuzhangqingkuang() {
		return guzhangqingkuang;
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
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：申请日期
	 */
	public void setShenqingriqi(Date shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getShenqingriqi() {
		return shenqingriqi;
	}

}
