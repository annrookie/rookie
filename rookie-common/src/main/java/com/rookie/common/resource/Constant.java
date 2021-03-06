package com.rookie.common.resource;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/12 14:41
 */
public class Constant {
    /**
     * 常见常量
     */
    public static final String EMPTY = "";
    public static final String NULL = "null";
    public static final int NEG_ONE = -1;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int SEVEN = 7;

    /**
     * 最大分钟数 60
     * 最大秒数 60
     * 最大小时数 24
     * 一小时秒数 3600
     * 一天的秒数 86400
     */
    public static final int MINUTE_MAX = 60;
    public static final int SECOND_MAX = 60;
    public static final int HOUR_MAX = 24;
    public static final int HOUR_SECOND = 3600;
    public static final int DAY_SECOND = 86400;

    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String UTF_8 = "UTF-8";
    public static final String GBK = "GBK";

    public static final String WIN = "windows";
    /**
     * 日期格式
     */
    public static final String[] DATE_FORMAT = {"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd", "yyyy年MM月dd日"};

    /**
     * 日期格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_NORMAL = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准日期格式 yyyy-MM-dd
     */
    public static final String DATE_DAY = "yyyy-MM-dd";

    /**
     * 中国公民身份证号码最小长度。
     */
    public static final int IDCARD_LENGTH_15 = 15;
    /**
     * 中国公民身份证号码最大长度。
     */
    public static final int IDCARD_LENGTH_18 = 18;

    /**
     * 每位加权因子
     */
    public static final int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    /**
     * 平年每月天数
     */
    public static final int[] MONTH_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     * 闰年每月天数
     */
    public static final int[] LEAP_MONTH_LENGTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static final String[] WEEK_CN = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    public static final String[] WEEK_EN = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
    public static final String[] WEEK_NUM = {"1", "2", "3", "4", "5", "6", "7"};

    //常见正则表达式------------------------------------------
    /**
     * 数字、26个英文字母或者下划线组成的字符串
     */
    public static final String REG_COMMON = "^\\w+$";

    /**
     * 英文字母和数字
     */
    public static final String REG_WORD_NUMBER = "^[A-Za-z0-9]+$";

    /**
     * 英文字母
     */
    public static final String REG_WORD = "^[A-Za-z]+$";

    /**
     * 汉字
     */
    public static final String REG_CHINESE = "^[\\u4E00-\\u9FA5A]{0,}$";

    /**
     * 数字
     */
    public static final String REG_NUMBER = "^[0-9]*$";

    /**
     * 正整数
     */
    public static final String REG_ABS_INTEGER = "^[1-9]\\d*$";

    /**
     * 负整数
     */
    public static final String REG_NEG_INTEGER = "^-[1-9]\\d*$";

    /**
     * 自然数 >=0 的整数
     */
    public static final String REG_NAT_INTEGER = "^\\d+$";

    /**
     * 小数
     */
    public static final String REG_FLOAT = "^(-?\\d+)(\\.\\d+)?$";

    /**
     * 邮箱验证 http://emailregex.com/
     */
    public static final String REG_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    /**
     * 域名
     */
    public static final String REG_HOST = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";

    /**
     * URL地址验证
     */
    public static final String REG_URL = "^((ht|f)tps?):\\/\\/([\\w\\-]+(\\.[\\w\\-]+)*\\/)*[\\w\\-]+(\\.[\\w\\-]+)*\\/?(\\?([\\w\\-\\.,@?^=%&:\\/~\\+#]*)+)?";

    /**
     * 手机号码
     */
    public static final String REG_MOBILE = "^(13[0-9]|14[5|7|9]|15[0|1|2|3|5|6|7|8|9]|166|17[0|1|3|5|6|7|8]|18[0|1|2|3|5|6|7|8|9]|19[8|9])\\d{8}$";

    /**
     * 电话号码
     */
    public static final String REG_PHONE = "^(\\(\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$";

    /**
     * 企业电话
     */
    public static final String REG_CORP_PHONE = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";

    /**
     * 身份证
     */
    public static final String REG_IDCARD = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";

    /**
     * 日期校验
     * yyyy-MM-dd | yyyy/MM/dd | yyyyMMdd | yyyy.MM.dd | yyyy年MM月dd日
     */
    public static final String REG_DATE = "^(\\d{2,4})([/\\-\\.年]?)(\\d{1,2})([/\\-\\.月]?)(\\d{1,2})日?(([\\s+]?)(\\d{1,2})([:\\s+\\.时]?)(\\d{1,2})([\\s+\\.分]?)([:\\s+\\.分]?)(\\d{1,2})秒?)?$";

    /**
     * ipv4
     */
    public static final String REG_IPV4 = "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";

    /**
     * ipv6
     */
    public static final String REG_IPV6 = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";

    /**
     * mac地址
     */
    public static final String REG_MAC = "((?:[A-F0-9]{1,2}[:-]){5}[A-F0-9]{1,2})|(?:0x)(\\d{12})(?:.+ETHER)";

    /**
     * 车牌号码正则 包含新能源
     */
    public static final String REG_PLATE = "^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$";

    /** 身份证省县市编码  */
    /*
7. 身份证号(15位、18位数字)：^\d{15}|\d{18}$
8. 短身份证号码(数字、字母x结尾)：^([0-9]){7,18}(x|X)?$ 或 ^\d{8,18}|[0-9x]{8,18}|[0-9X]{8,18}?$
9. 帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
10. 密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)：^[a-zA-Z]\w{5,17}$
11. 强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间)：^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$
12. 日期格式：^\d{4}-\d{1,2}-\d{1,2}
13. 一年的12个月(01～09和1～12)：^(0?[1-9]|1[0-2])$
14. 一个月的31天(01～09和1～31)：^((0?[1-9])|((1|2)[0-9])|30|31)$
15. 钱的输入格式：
16. 1.有四种钱的表示形式我们可以接受:"10000.00" 和 "10,000.00", 和没有 "分" 的 "10000" 和 "10,000"：^[1-9][0-9]*$
17. 2.这表示任意一个不以0开头的数字,但是,这也意味着一个字符"0"不通过,所以我们采用下面的形式：^(0|[1-9][0-9]*)$
18. 3.一个0或者一个不以0开头的数字.我们还可以允许开头有一个负号：^(0|-?[1-9][0-9]*)$
19. 4.这表示一个0或者一个可能为负的开头不为0的数字.让用户以0开头好了.把负号的也去掉,因为钱总不能是负的吧.下面我们要加的是说明可能的小数部分：^[0-9]+(.[0-9]+)?$
20. 5.必须说明的是,小数点后面至少应该有1位数,所以"10."是不通过的,但是 "10" 和 "10.2" 是通过的：^[0-9]+(.[0-9]{2})?$
21. 6.这样我们规定小数点后面必须有两位,如果你认为太苛刻了,可以这样：^[0-9]+(.[0-9]{1,2})?$
22. 7.这样就允许用户只写一位小数.下面我们该考虑数字中的逗号了,我们可以这样：^[0-9]{1,3}(,[0-9]{3})*(.[0-9]{1,2})?$
23. 8.1到3个数字,后面跟着任意个 逗号+3个数字,逗号成为可选,而不是必须：^([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$
24. 备注：这就是最终结果了,别忘了"+"可以用"*"替代如果你觉得空字符串也可以接受的话(奇怪,为什么?)最后,别忘了在用函数时去掉去掉那个反斜杠,一般的错误都在这里
25. xml文件：^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\.[x|X][m|M][l|L]$
26. 中文字符的正则表达式：[\u4e00-\u9fa5]
27. 双字节字符：[^\x00-\xff] (包括汉字在内，可以用来计算字符串的长度(一个双字节字符长度计2，ASCII字符计1))
28. 空白行的正则表达式：\n\s*\r (可以用来删除空白行)
29. HTML标记的正则表达式：<(\S*?)[^>]*>.*?</\1>|<.*? /> (网上流传的版本太糟糕，上面这个也仅仅能部分，对于复杂的嵌套标记依旧无能为力)
30. 首尾空白字符的正则表达式：^\s*|\s*$或(^\s*)|(\s*$) (可以用来删除行首行尾的空白字符(包括空格、制表符、换页符等等)，非常有用的表达式)
31. 腾讯QQ号：[1-9][0-9]{4,} (腾讯QQ号从10000开始)
32. 中国邮政编码：[1-9]\d{5}(?!\d) (中国邮政编码为6位数字)
33. IP地址：\d+\.\d+\.\d+\.\d+ (提取IP地址时有用)
34. IP地址：((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))
     */
}
