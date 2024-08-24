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
 * 设备信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
@TableName("shebeixinxi")
public class ShebeixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebeixinxiEntity() {
		
	}
	
	public ShebeixinxiEntity(T t) {
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
	 * 图片
	 */
					
	private String tupian;
	
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
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	/**
	 * 设备用途
	 */
					
	private String shebeiyongtu;
	
	/**
	 * 设备详情
	 */
					
	private String shebeixiangqing;
	
	/**
	 * 设备保质期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shebeibaozhiqi;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 设备状态
	 */
					
	private String shebeizhuangtai;
	
	
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
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
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
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
	/**
	 * 设置：设备用途
	 */
	public void setShebeiyongtu(String shebeiyongtu) {
		this.shebeiyongtu = shebeiyongtu;
	}
	/**
	 * 获取：设备用途
	 */
	public String getShebeiyongtu() {
		return shebeiyongtu;
	}
	/**
	 * 设置：设备详情
	 */
	public void setShebeixiangqing(String shebeixiangqing) {
		this.shebeixiangqing = shebeixiangqing;
	}
	/**
	 * 获取：设备详情
	 */
	public String getShebeixiangqing() {
		return shebeixiangqing;
	}
	/**
	 * 设置：设备保质期
	 */
	public void setShebeibaozhiqi(Date shebeibaozhiqi) {
		this.shebeibaozhiqi = shebeibaozhiqi;
	}
	/**
	 * 获取：设备保质期
	 */
	public Date getShebeibaozhiqi() {
		return shebeibaozhiqi;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：设备状态
	 */
	public void setShebeizhuangtai(String shebeizhuangtai) {
		this.shebeizhuangtai = shebeizhuangtai;
	}
	/**
	 * 获取：设备状态
	 */
	public String getShebeizhuangtai() {
		return shebeizhuangtai;
	}

}
