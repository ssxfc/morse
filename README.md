# morse
## Spring
### Spring IOC
1. 启动过程
```text
加载beanFactory(解析bean的metadata为beanDefinition并注入其中)
注册beanFactory的后置处理器并启动处理
注册bean的后置处理器
...
```
### Spring常见接口扩展点
1. BeanFactoryPostProcessor 
```text
// ioc容器借此修改beanDefinition
public interface BeanFactoryPostProcessor {
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
```
2. BeanPostProcessor
```text
// ioc容器借此对bean进行修改，如检查实例的标记接口或代理包装
public interface BeanPostProcessor {

	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
```