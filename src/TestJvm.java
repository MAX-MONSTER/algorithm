import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class TestJvm {
 public static class User{
     private int id;
     private String name;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }
    public static void main(String[] args) {
//        byte[] array = new byte[150 * 1024 * 1024];//
//
//        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
//
//            System.out.println(memoryPoolMXBean.getName() + "  总量:" + memoryPoolMXBean.getUsage().getCommitted() + "   使用的内存:" + memoryPoolMXBean.getUsage().getUsed());
//        }
        try {

            TreeMap<String,String> map =new TreeMap<>();
            map.put("","");
                         //准备url
                         URL url = new File("C:\\work\\codes\\nioresearch\\target\\classes\\beans\\").toURI().toURL();
                         URL[] urls = {url};
                         //获取有关类型加载的JMX接口
                         ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
                         //用于缓存类加载器
                         List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
                         while (true) {
                                 //加载类型并缓存类加载器实例
                                 ClassLoader classLoader = new URLClassLoader(urls);
                                 classLoaders.add(classLoader);
                                 classLoader.loadClass("FileMeta.class");
                                 //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                                 System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                                 System.out.println("active: " + loadingBean.getLoadedClassCount());
                                 System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
                             }
                     } catch (Exception e) {
                         e.printStackTrace();
                    }
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("blueStarWei");
    }
}
