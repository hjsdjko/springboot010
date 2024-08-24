package com.cl.entity.view;

import com.cl.entity.ShebeixunjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 设备巡检
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:20
 */
@TableName("shebeixunjian")
public class ShebeixunjianView  extends ShebeixunjianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebeixunjianView(){
	}
 
 	public ShebeixunjianView(ShebeixunjianEntity shebeixunjianEntity){
 	try {
			BeanUtils.copyProperties(this, shebeixunjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
