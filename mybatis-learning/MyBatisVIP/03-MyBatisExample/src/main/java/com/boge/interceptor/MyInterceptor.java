package com.boge.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * MyBatis中的自定义的拦截器
 *
 * @Signature 表示一个方法签名，唯一确定一个方法
 */
@Intercepts(
        {@Signature(
                type = Executor.class, // 拦截类型
                method = "query", // 拦截方法
                // args 中指定 被拦截方法的 参数列表
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(
                        type = Executor.class,
                        method = "close",
                        args = {boolean.class})
        })
public class MyInterceptor implements Interceptor {

    private String interceptorName;

    public String getInterceptorName() {
        return interceptorName;
    }

    /**
     * 执行拦截的方法
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("------MyInterceptor  before---------");
        Object proceed = invocation.proceed();
        System.out.println("------MyInterceptor  after---------");
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties : " + properties.getProperty("interceptorName"));
        this.interceptorName = properties.getProperty("interceptorName");
    }
}
