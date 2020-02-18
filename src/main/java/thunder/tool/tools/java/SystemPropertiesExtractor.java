package thunder.tool.tools.java;

/**
 *
 *
 */

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Properties;

/**
 * @Title 自定义JVM参数抽取器, SystemProperties抽取器
 * @Description 用于获取通过命令行传递的自定义JVM参数, 格式为: java -D<name>=<value> <MainClass>
 * @Author 陈超雷(chenchaoleicn@gmail.com)
 * @Date 2020/1/19
 */
public class SystemPropertiesExtractor {

    public static void main(String[] args) {
        // 可以获取到-D<name>=<value>格式的参数
        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();

        // 可以获取到所有的JVM参数，包括在命令行自定义的参数
        Properties properties = System.getProperties();
        properties.list(System.out);
        System.getProperty("<name>");
    }
}
