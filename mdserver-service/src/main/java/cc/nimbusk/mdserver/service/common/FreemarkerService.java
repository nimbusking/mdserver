package cc.nimbusk.mdserver.service.common;

import java.util.Map;

/**
 * FreemarkerService interface definition
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/17
 */
public interface FreemarkerService {

    /**
     * using freemarker utility to convert template(*.ftl) by target <strong>paramMap</strong>
     *
     * @param templateName the name of freemarker tempalte
     * @param paramMap source param map
     * @return result string after processing template. Default is blank string.
     */
    String parseTemplate(String templateName, Map<String, Object> paramMap);

}
