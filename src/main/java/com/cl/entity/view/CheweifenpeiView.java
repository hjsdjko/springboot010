package com.cl.entity.view;

import com.cl.entity.CheweifenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 车位分配
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@TableName("cheweifenpei")
public class CheweifenpeiView  extends CheweifenpeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheweifenpeiView(){
	}
 
 	public CheweifenpeiView(CheweifenpeiEntity cheweifenpeiEntity){
 	try {
			BeanUtils.copyProperties(this, cheweifenpeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
