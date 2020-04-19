package com.cxyxs.auto.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description：
 * Author: 程序猿学社
 * Date:  2020/2/2 21:02
 * Modified By:
 */
@Component
public class AutoFill  implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //考虑到没有createTime字段，也执行了,所以，这里需要增加判断
        boolean flag = metaObject.hasGetter("createTime");
        if(flag){
            setFieldValByName("createTime",new Date(),metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object flag = getFieldValByName("updateTime",metaObject);
        //如果有给修改时间赋值，就不用给该字段赋值
        if(flag == null){
            setFieldValByName("updateTime",new Date(),metaObject);
        }
    }
}
