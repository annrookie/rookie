#Rookie-common
    * 通用工具包，主要包含了简单多种简单的工具类。 
#StrUtil
    **************************
    ******* 字符串工具类  *****
    * 部分借鉴网上资源进行整合 *
    **************************
    * 方法：
    
        # 判断是否为空白字符串
       【空格、制表符、全角空格和不间断空格皆为空白字符串】
       
        1.isBlank:判断字符串是否为空白字符串
        2.isNotBlank：判断字符串是否不为空白字符串
        3.existBlank：判断字符串内是否存在空白字符串
        4.isAllBlank：判断字符串数组是否全为空
        5.blankToStr：空白字符串转指定字符串
        6.blankToEmpty：空白字符串转为空""字符串
        
        # 判断是否为空
        【空定义：""或null】
        
        1.isEmpty：判断是否为空
        2.isNotEmpty：判断不为空
        3.existEmpty：判断字符串数组存在空
        4.isAllEmpty：判断字符串数组全为空
        5.nullToEmpty：null转为""
        6.emptyToStr：空转指定字符串
        7.emptyToNull：""转null
        8.isNullOrUndefined：判断是否为null、"null" 或 "undefined"
        9.isEmptyOrUndefined：判断是否为空、"null" 或 "undefined"
        10.isBlankOrUndefined：判断是否为空白字符串、"null" 或 "undefined"
        
        # 字符串常用操作
        
        1.trim：左右两边去空
        2.trimLeft：左去空
        3.trimRight：右去空
        4.firstToUpper：首字母转大写
        5.firstToLower：首字母转小写
        6.removeBlank：去空白字符
        7.count：统计指定内容中包含指定字符的数量，null 或 "" 返回0
        8.uuid：获取uuid
        9.hide：将字符串指定范围替换为指定的标识
        10.getHideFlag：获取指定长度的字符串标识

#ArrayUtil
        