package com.taimi.Util;/**
 * @ProjectName: robot-cloud-server
 * @Package: com.taimi
 * @ClassName: BeanSerializeUtil
 * @Author: kailin_zhou
 * @Description:
 * @Date: 2019/9/8 21:29
 * @Version: 1.0
 */

import org.springframework.stereotype.Component;

import java.io.*;

/**
 *@author kailin_zhou
 *@date 2019/9/8 21:29
 *@description TODO
 *@version v1.0
 **/
@Component
public class BeanSerializeUtil {
    //对象转化为字节码
    public  byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }
    //字节码转化为对象
    public  Object getObjectFromBytes(byte[] objBytes) throws Exception {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
