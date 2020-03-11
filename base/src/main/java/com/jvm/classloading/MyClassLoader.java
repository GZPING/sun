package com.jvm.classloading;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : GD
 * @date :2020/3/11 : 21:58
 */
public class MyClassLoader extends ClassLoader {

    private final static Path DEFUALT_CLASS_PATH = Paths.get("D:","class");

    private final Path classDir;

    public MyClassLoader() {
        super();
        classDir = DEFUALT_CLASS_PATH;
    }
    public MyClassLoader(String dir) {
        super();
        classDir = Paths.get(dir);
    }

    public MyClassLoader(String dir,ClassLoader parent) {
        super(parent);
        classDir = Paths.get(dir);
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
        return "MyClassLoader{" +
                "classDir=" + classDir +
                '}';
    }
}
