package com.cl.entity.view;

import com.cl.entity.XiaoqutongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 小区通知
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 22:16:21
 */
@TableName("xiaoqutongzhi")
public class XiaoqutongzhiView  extends XiaoqutongzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoqutongzhiView(){
	}
 
 	public XiaoqutongzhiView(XiaoqutongzhiEntity xiaoqutongzhiEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoqutongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
