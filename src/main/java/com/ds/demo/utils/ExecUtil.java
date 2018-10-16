package com.ds.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Simon
 * @create 2018-10-16 11:34
 * @desc
 **/
public class ExecUtil {
    public static String execUtil(String cmd) {
        String result = "";
        try {
//            String[] cmd = new String[]{"cat", "/sys/class/thermal/thermal_zone0/temp"};
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            result = sb.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
        return result;
    }
}
