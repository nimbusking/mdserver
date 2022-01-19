package cc.nimbusk.mdserver.runner.config;

import cc.nimbusk.mdserver.web.config.StaticPagePathResolver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/19
 */
@Configuration
@EnableWebMvc
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    private StaticPagePathResolver staticPagePathResolver;

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations(
                CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // add controller model and view resolver
        for (StaticPagePathResolver.PagePath pagePaths : staticPagePathResolver.findAllPath()) {
            String requestUrlPath = pagePaths.getRequestUrlPath();
            if (StringUtils.isNoneBlank(requestUrlPath)) {
                String realResourcePath = pagePaths.getRealResourcePath();
                registry.addViewController(requestUrlPath).setViewName(realResourcePath);
                log.info("WebConfig add view requestUrlPath:{}, realResourcePath:{}", requestUrlPath, realResourcePath);
            }
        }

    }

    @Autowired
    public void setStaticPagePathResolver(StaticPagePathResolver staticPagePathResolver) {
        this.staticPagePathResolver = staticPagePathResolver;
    }
}
