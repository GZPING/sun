package com.jvm.classloading;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : GD
 * @date :2020/3/11 : 21:58
 */
public class BrokerDelegateClassLoader extends ClassLoader {

    private final static Path DEFUALT_CLASS_PATH = Paths.get("D:","class");

    private final Path classDir;

    public BrokerDelegateClassLoader() {
        super();
        classDir = DEFUALT_CLASS_PATH;
    }
    public BrokerDelegateClassLoader(String dir) {
        super();
        classDir = Paths.get(dir);
    }

    public BrokerDelegateClassLoader(String dir, ClassLoader parent) {
        super(parent);
        classDir = Paths.get(dir);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // 该方法返回与指定类名称相关联的专用对象。 否则，该方法返回的ClassLoader对象,确保每个对象只被加载一次
        synchronized (getClassLoadingLock(name)){
            Class<?> clazz = findLoadedClass(name);
            if(clazz == null){
                // 如果类全路径以java,javax 开头，则直接交给系统类加载器进行加载
                if(name.startsWith("java.") || name.startsWith("javax.")){
                    try {
                        clazz = getSystemClassLoader().loadClass(name);
                    }catch (Exception e){
                    }
                }else{
                    // 其他方式以自定义类加载器加载
                    try{
                        clazz = this.findClass(name);
                    }catch (Exception e){
                    }
                    if(clazz == null){
                        if(getParent() != null){
                            clazz = getParent().loadClass(name);
                        }else{
                            clazz = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
                if(clazz == null){
                    throw new ClassNotFoundException("xxxxx");
                }
                if(resolve){
                    resolveClass(clazz);
                }
                return clazz;
            }
        }
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 读取class二进制文件
        byte[] classByte = this.readClassBytes(name);
        if(classByte == null || classByte.length == 0){
            throw new ClassNotFoundException(" can not load class " + name);
        }
        return super.defineClass(name,classByte,0,classByte.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        // 将报名改为路径名称
        String classPath = name.replace(".","/");
        // class 文件地址
        Path fullPath = classDir.resolve(Paths.get(classPath+".class"));

        if(!fullPath.toFile().exists()){
            throw new ClassNotFoundException(" class not found in " + fullPath);
        }
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(fullPath,baos);
            return baos.toByteArray();
        }catch (Exception e){
            throw new ClassNotFoundException(" load the class found in " + fullPath);
        }
    }

    @Override
    public String toString() {
        return "BrokerDelegateClassLoader{" +
                "classDir=" + classDir +
                '}';
    }
}
