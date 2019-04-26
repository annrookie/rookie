# rookie-common
* 通用工具类：主要包含简单的工具类  
* 项目结构  
```
   rookie-common
   ├── com
         ├── rookie
               ├── common
                     ├── exception 异常处理
                     ├── filter    过滤器
                     ├── resource  静态常量资源  
                     └── util      工具类
 ```
### 目录结构介绍  
* exception：异常处理  
    * UtilException：util异常处理类  
* filter：过滤器接口  
    * Accept：过滤器接收接口，boolean filter(T t)  
    * Filter：过滤器过滤接口，T filter(T t)
* resource : 静态常量资源   
    * Constant：静态常量类  
        * 常用静态正则：如日期、邮箱正则等  
        * 常用静态常量：如空字符串、长度  
    * AreaCode：行政区域类  
        * Properties pro：已加载的行政区域信息  
        * Map<String,String> getProvince：获取省份信息  
        * List<Map<String,Object>> getCity：获取省市行政区域信息  
        * List<Map<String,Object>> getArea：获取所有省市县行政区域信息  
* util：工具类  
    * StrUtil：字符串工具类  
    * ArrayUtil：数组工具类  
    * ComUtil：校验工具类  
    * IdcardUtil：身份证工具类  
    * DateUtil：日期工具类
        