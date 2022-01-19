package cc.nimbusk.mdserver.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * JarFileLoader
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/17
 */
public class JarFileLoader {

    /**
     * Load class from target jar file under target file path.
     * @param jarFilePath the path of target jar file
     * @return the set of classes
     */
    public static Set<Class<?>> loadInterfaceClass(String jarFilePath) {
        if (StringUtils.isAnyBlank(jarFilePath)) {
            return null;
        }
        Set<Class<?>> classes = new HashSet<>();
        File file = new File(jarFilePath);
        try {
            JarFile jarFile = new JarFile(file);
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toURI().toURL()}, JarFileLoader.class.getClassLoader());
            for (Enumeration<JarEntry> e = jarFile.entries(); e.hasMoreElements(); ) {
                JarEntry jarEntry =  e.nextElement();
                if (!jarEntry.isDirectory()) {
                    String entryName = jarEntry.getName();
                    if (!entryName.endsWith(".class")) {
                        continue;
                    }
                    String className = entryName.substring(0, entryName.length() - 6);
                    Class<?> cls = urlClassLoader.loadClass(className.replace("/", "."));
                    if (cls != null && cls.isInterface()) {
                        // cls is interface and add into the set of classes.
                        classes.add(cls);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }

}
