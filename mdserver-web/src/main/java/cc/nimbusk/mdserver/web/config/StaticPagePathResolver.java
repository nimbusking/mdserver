package cc.nimbusk.mdserver.web.config;

import cc.nimbusk.mdserver.util.constant.BaseConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * StaticPagePathResolver
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/19
 */
@Component
@Slf4j
public class StaticPagePathResolver {

    private ResourcePatternResolver resourcePatternResolver;

    @Autowired
    public StaticPagePathResolver(ResourcePatternResolver resourcePatternResolver) {
        this.resourcePatternResolver = resourcePatternResolver;
    }

    /**
     * findAllPath
     * @return the list of page paths
     */
    public List<PagePath> findAllPath() {
        List<PagePath> pagePathList = new ArrayList<>();
        Resource baseResource = resourcePatternResolver.getResource(BaseConstants.RESOURCE_PATH);
        try {
            String baseUrl = baseResource.getURL().getPath();
            Resource[] resources = resourcePatternResolver.getResources(String.format("%s/**/*%s",
                    BaseConstants.RESOURCE_PATH, BaseConstants.PAGE_SUFFIX));

            for (Resource resource : resources) {
                String path = relativeResourcePath(baseUrl, resource);
                pagePathList.add(new PagePath(path, path));
            }
        } catch (IOException e) {
            log.error("StaticPagePathResolver findAllPath exception e:", e);
        }
        return pagePathList;
    }

    private String relativeResourcePath(String basePath, Resource resource) throws IOException {
        return resource.getURL().getPath().substring(basePath.length()).replace(BaseConstants.PAGE_SUFFIX, "");
    }

    /**
     * inner page path class
     */
    public static class PagePath {
        private final String realResourcePath;
        private final String requestUrlPath;

        public PagePath(String realResourcePath, String requestUrlPath) {
            this.realResourcePath = realResourcePath;
            this.requestUrlPath = requestUrlPath;
        }

        public String getRealResourcePath() {
            return realResourcePath;
        }

        public String getRequestUrlPath() {
            return requestUrlPath;
        }

        @Override
        public String toString() {
            return "PagePath{" +
                    "realResourcePath='" + realResourcePath + '\'' +
                    ", requestUrlPath='" + requestUrlPath + '\'' +
                    '}';
        }
    }

}
