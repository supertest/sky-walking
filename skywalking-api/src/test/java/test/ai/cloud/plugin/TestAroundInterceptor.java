package test.ai.cloud.plugin;

import com.ai.cloud.skywalking.plugin.interceptor.ConstructorInvokeContext;
import com.ai.cloud.skywalking.plugin.interceptor.EnhancedClassInstanceContext;
import com.ai.cloud.skywalking.plugin.interceptor.IAroundInterceptor;
import com.ai.cloud.skywalking.plugin.interceptor.MethodInvokeContext;

public class TestAroundInterceptor implements IAroundInterceptor {

	@Override
	public void onConstruct(EnhancedClassInstanceContext context, ConstructorInvokeContext interceptorContext) {
		context.set("test.key", "123");
		System.out.println("onConstruct, args size=" + interceptorContext.allArguments().length);
	}

	@Override
	public void beforeMethod(EnhancedClassInstanceContext context, MethodInvokeContext interceptorContext) {
		System.out.println("beforeMethod : " + context.get("test.key", String.class));
	}

	@Override
	public Object afterMethod(EnhancedClassInstanceContext context, MethodInvokeContext interceptorContext, Object ret) {
		System.out.println("afterMethod: " + context.get("test.key", String.class));
		return ret;
	}

	@Override
	public void handleMethodException(Throwable t, EnhancedClassInstanceContext context,
			MethodInvokeContext interceptorContext, Object ret) {
		// TODO Auto-generated method stub
		
	}

}
