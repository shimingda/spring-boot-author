package com.ds.demo.check;

import com.ds.demo.constant.WarningConstant;
import com.ds.demo.utils.ExecUtil;
import com.ds.demo.utils.StringUtil;

import java.text.DecimalFormat;

/**
 * @author Simon
 * @create 2018-10-16 11:36
 * @desc
 **/
public class CPU {
    /**
     * 获取cpu温度
     *
     * @return
     */
    public static double getTemp() {

        String result = ExecUtil.execUtil(WarningConstant.SHELL_CAT_CPU);
        DecimalFormat df = new DecimalFormat("#.0");
        df.format(result);
        return Double.parseDouble(df.toString());
    }
}
