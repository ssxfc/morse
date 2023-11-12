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

### Spring 如何解析配置类CustomizedConfig
1. 编写测试用例
```text
public class SpringEventTest {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(MyEventHandlerConfig.class);
//        ctx.start();
//        ctx.refresh();
//        ctx.stop();
    }
}

@Configuration
public class MyEventHandlerConfig {
    @Bean
    public ApplicationListener getRefreshedHandler(){
        return new MyRefreshedEventHandler();
    }

    @Bean
    public ApplicationListener getStartHandler(){
        return new MyStartEventHandler();
    }

    @Bean
    public ApplicationListener getStopHandler(){
        return new MyStopEventHandler();
    }
}
```
2. debug执行流
```text
// 执行refresh前,根据AnnotatedBeanDefinitionReader注册自定义配置类
register(componentClasses); ==>
BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, this.registry);
// 针对自定义配置类，根据Spring的ConfigurationClassPostProcessor找出自定义配置类
this.reader.loadBeanDefinitions(configClasses);
// 经过一系列的阅读器解读，最终定位到核心方法
private void loadBeanDefinitionsForConfigurationClass(
			ConfigurationClass configClass, TrackedConditionEvaluator trackedConditionEvaluator) {

    if (trackedConditionEvaluator.shouldSkip(configClass)) {
        String beanName = configClass.getBeanName();
        if (StringUtils.hasLength(beanName) && this.registry.containsBeanDefinition(beanName)) {
            this.registry.removeBeanDefinition(beanName);
        }
        this.importRegistry.removeImportingClass(configClass.getMetadata().getClassName());
        return;
    }

    if (configClass.isImported()) {
        registerBeanDefinitionForImportedConfigurationClass(configClass);
    }
    for (BeanMethod beanMethod : configClass.getBeanMethods()) {
        loadBeanDefinitionsForBeanMethod(beanMethod);
    }

    loadBeanDefinitionsFromImportedResources(configClass.getImportedResources());
    loadBeanDefinitionsFromRegistrars(configClass.getImportBeanDefinitionRegistrars());
}
// 通过分析出自定义配置类含有的@Bean方法，生成beanDefinition
```
3. 总结就是：Spring通过在BeanFactoryPostProcessor激活期间同ing过配置类后置处理器来处理我们的自定义配置类