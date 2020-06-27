package com.yyz.demo.facade.common.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 17:55
 * @Description:
 */
public class ToStringHelper {

    public static final transient ToStringStyle DEFAULT_TO_STRING_STYLE = new DefaultToStringStyle();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, DEFAULT_TO_STRING_STYLE);
    }

    public static class DefaultToStringStyle extends ToStringStyle{

        private static final long serialVersionUID = -804376326220569463L;

        public DefaultToStringStyle(){
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        @Override
        public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
            if (value != null){
                super.append(buffer, fieldName, value, fullDetail);
            }
        }

        @Override
        public void append(StringBuffer buffer, String fieldName, Object[] array, Boolean fullDetail) {
            if (array != null && array.length > 0){
                super.append(buffer, fieldName, array, fullDetail);
            }
        }
    }
}
