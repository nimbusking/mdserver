package cc.nimbusk.mdserver.service.common.impl;

import cc.nimbusk.mdserver.service.common.FreemarkerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * the implementation of FreemarkerService interface.
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/17
 */
@Service
@Slf4j
public class FreemarkerServiceImpl implements FreemarkerService {

    @Override
    public String parseTemplate(String templateName, Map<String, Object> paramMap) {
        String result = "";
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        try {
            configuration.setClassLoaderForTemplateLoading(FreemarkerServiceImpl.class.getClassLoader(), "/templates");
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            Template template = configuration.getTemplate(templateName);
            StringWriter stringWriter = new StringWriter();
            template.process(paramMap, stringWriter);
            result = stringWriter.toString();
        } catch (IOException e) {
            log.error("FreemarkerServiceImpl parseTemplate io exception e:", e);
        } catch (TemplateException e) {
            log.error("FreemarkerServiceImpl parseTemplate TemplateException e:", e);
        }
        return result;
    }
}
