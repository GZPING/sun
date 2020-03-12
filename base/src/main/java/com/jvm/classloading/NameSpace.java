package com.jvm.classloading;

/**
 *1。 使用同一个类加载器加载同一个class 文件，加载出的Class对象 都是一样的
 * 509886383
 * 509886383
 * true
 * 2. 不同加载器加载出来的的Class 对象不是同一个对象
 *
 * 357863579
 * 1811044090
 * false
 *
 * 运行时包
 *
 * 3. 运行时的包是由类加载器的命名空间和类的全限名称共同组成。比如 MyClassLoader.com.jvm.classloading.Hello
 *
 * 初始化类加载器
 *
 * 4. jvm 规定了不同运行时下的类彼此之间不能进行相互访问。那么为什么我们可以new 一个java.lang 或者第三方的对象呢？
 *
 * 5， 在类加载过程中，所有参与类加载的加载器，，即使没有亲自加载过该类，这些类加载器都会被表示为初始类加载器
 * ，比如 BrokerDelegateClassLoader 在加载的时候，会保存String.class，在类加载器中维护列表中添加该class类型
 * 所以 BrokerDelegateClassLoader 加载器中会有Hello.java,String.class
 *
 * 类的卸载
 *
 * 6. JVM 规定，满足三个条件才会被GC 回收，也就是类被卸载
 * 1)  该类的所有实例都给GC 回收
 * 2） 加载该类的ClassLoader 实例被回收
 * 3） 该类的class 实例没有在任何其他地方被引用
 *
 * 查看java 启动是的JVM 运行期间到底加载了多少class        -verbose:class
 *
 * 可以自己构造一个java.lang.String 加载器加载类，
 * 但是JVM 在defineClass 的时候会做安全检查，所有会报错
 *
 * @author : GD
 * @date :2020/3/12 : 21:42
 */
public class NameSpace {
    public static void main(String[] args) throws ClassNotFoundException {
        /*ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.jvm.classloading.Hello");
        Class<?> clazz1 = classLoader.loadClass("com.jvm.classloading.Hello");*/
        MyClassLoader myClassLoader = new MyClassLoader();
        BrokerDelegateClassLoader brokerDelegateClassLoader = new BrokerDelegateClassLoader();
        Class<?> clazz = myClassLoader.loadClass("com.jvm.classloading.Hello");
        Class<?> clazz1 = brokerDelegateClassLoader.loadClass("com.jvm.classloading.Hello");
        System.out.println(clazz.hashCode());
        System.out.println(clazz1.hashCode());
        System.out.println(clazz == clazz1);
    }
}
