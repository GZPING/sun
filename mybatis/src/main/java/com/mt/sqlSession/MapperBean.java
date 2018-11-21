package com.mt.sqlSession;

/**
 * Created by GD on 2018/10/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import java.util.List;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/10/23 22:50
 * @Since 1.0V
 */

public class MapperBean {

    private String interfaceName; //接口名
    private List<Function> list; //接口下所有方法

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<Function> getList() {
        return list;
    }

    public void setList(List<Function> list) {
        this.list = list;
    }
}
