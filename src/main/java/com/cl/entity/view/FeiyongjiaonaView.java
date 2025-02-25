package com.cl.entity.view;

import com.cl.entity.FeiyongjiaonaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 费用缴纳
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@TableName("feiyongjiaona")
public class FeiyongjiaonaView  extends FeiyongjiaonaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FeiyongjiaonaView(){
	}
 
 	public FeiyongjiaonaView(FeiyongjiaonaEntity feiyongjiaonaEntity){
 	try {
			BeanUtils.copyProperties(this, feiyongjiaonaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
