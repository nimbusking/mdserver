package cc.nimbusk.mdserver.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MdServerApplicationRunner
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/14
 */
@SpringBootApplication
public class MdServerApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MdServerApplicationRunner.class, args);
    }

}
