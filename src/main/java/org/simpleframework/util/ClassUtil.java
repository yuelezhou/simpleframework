package org.simpleframework.util;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ClassUtil {

   public static final String FILE_PROTOCOL = "file";

   public static Set<Class<?>> extractPackageClass(String packageName){
       //1获取到类的加载器
      ClassLoader classLoader = getClassLoader();
       //2通过类加载器获取到加载的资源
      URL url = classLoader.getResource(packageName.replace(".","/"));
      if (url == null){
         log.warn("unable to retrieve anything from package:" + packageName);
         return null;
      }
       //3依据不同的资源类型,采用不同的方式获取资源的集合
      Set<Class<?>> classSet = null;
      if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
         classSet = new HashSet<Class<?>>();
         File packageDirectory = new File(url.getPath());
         extractClassFile(classSet,packageDirectory,packageName);
      }
      return null;
   }

   private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
      if (!fileSource.isDirectory()){
         return;
      }
      //如果是一个文件夹,则调用其listFiles方法获取文件夹下的文件或文件夹
      File[] files = fileSource.listFiles(new FileFilter() {
         public boolean accept(File file) {
            if (file.isDirectory()){
               return true;
            }else {
               //获取文件的绝对值路径
               String absoluteFilePath = file.getAbsolutePath();
               if (absoluteFilePath.endsWith(".class")){
                  //若是class文件,则直接加载
                  addToClassSet(absoluteFilePath);
               }
            }
            return false;
         }
      });
   }

   private static void addToClassSet(String absoluteFilePath) {
      //1.从class文件的绝对路径里提取出了包含了package的类名
      //如 a/b/c/d 需要换成a.b.c.e
      absoluteFilePath.replace(File.separator,".");
      String className = absoluteFilePath.substring(absoluteFilePath.indexOf(absoluteFilePath));
      className = className.substring(0,className.lastIndexOf("."));
      //2通过反射机制获取对应的Class对象并加入到classSet里
      Class targetClass = loadClass(className);
      emptyClassSet.add(targetClass);
   }

   /**
    * 获取Class对象
    * @param className class全名=package + 类名
    * @return Class
    */

   public static Class<?> loadClass(String className){
      try {
         return Class.forName(className);
      } catch (ClassNotFoundException e) {
         log.error("load class error:",e);
         throw new RuntimeException(e);
      }
   }

   public static ClassLoader getClassLoader(){
      return Thread.currentThread().getContextClassLoader();
   }
}
