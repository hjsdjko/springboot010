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
 * 设备巡检
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
@TableName("shebeixunjian")
public class ShebeixunjianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebeixunjianEntity() {
		
	}
	
	public ShebeixunjianEntity(T t) {
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
	 * 设备名称
	 */
					
	private String shebeimingcheng;
	
	/**
	 * 设备型号
	 */
					
	private String shebeixinghao;
	
	/**
	 * 设备位置
	 */
					
	private String shebeiweizhi;
	
	/**
	 * 设备类型
	 */
					
	private String shebeileixing;
	
	/**
	 * 巡检结果
	 */
					
	private String xunjianjieguo;
	
	/**
	 * 安全隐患
	 */
					
	private String anquanyinhuan;
	
	/**
	 * 巡检时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date xunjianshijian;
	
	
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
	 * 设置：巡检结果
	 */
	public void setXunjianjieguo(String xunjianjieguo) {
		this.xunjianjieguo = xunjianjieguo;
	}
	/**
	 * 获取：巡检结果
	 */
	public String getXunjianjieguo() {
		return xunjianjieguo;
	}
	/**
	 * 设置：安全隐患
	 */
	public void setAnquanyinhuan(String anquanyinhuan) {
		this.anquanyinhuan = anquanyinhuan;
	}
	/**
	 * 获取：安全隐患
	 */
	public String getAnquanyinhuan() {
		return anquanyinhuan;
	}
	/**
	 * 设置：巡检时间
	 */
	public void setXunjianshijian(Date xunjianshijian) {
		this.xunjianshijian = xunjianshijian;
	}
	/**
	 * 获取：巡检时间
	 */
	public Date getXunjianshijian() {
		return xunjianshijian;
	}

}
