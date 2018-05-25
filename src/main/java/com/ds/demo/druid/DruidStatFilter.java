package com.ds.demo.druid;

import javax.servlet.annotation.WebFilter;  
import javax.servlet.annotation.WebInitParam;  
  
import com.alibaba.druid.support.http.WebStatFilter;  
 /**
  * 
  * @author Simon
  * @version 2018年5月24日
  *
  *	url 
  */
@WebFilter(filterName="druidStatFilter",urlPatterns="/*",  
initParams={  
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源  
})  
public class DruidStatFilter extends WebStatFilter {  
  
}  