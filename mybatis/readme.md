[TOC]
## 什么是Mybatis
MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。
## Mybatis 适用场合？
MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案。

对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。
## 怎么用Mybatis？
http://www.mybatis.org/mybatis-3/zh/index.html
## Mybatis 优势？
1. 与JDBC相比，减少了50%以上的代码量。

2. MyBatis是最简单的持久化框架，小巧并且简单易学。

3. MyBatis相当灵活，不会对应用程序或者数据库的现有设计强加任何影响，SQL写在XML里，从程序代码中彻底分离，降低耦合度，便于统一管理和优化，并可重用。

4. 提供XML标签，支持编写动态SQL语句。

5. 提供映射标签，支持对象与数据库的ORM字段关系映射。


## 传统JDBC链接
```
public class DBBaseTest {

    public static void main(String[] args) throws Exception {
        //加载驱动
        // DriverManager.registerDriver(new Driver());//第一种方式
        Class.forName("com.mysql.jdbc.Driver");//第二种方式
        //创建连接
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取连接
        Statement statement = connection.createStatement();
        String insertSql = "insert into orders values (null,100,30.20)";
        int num = statement.executeUpdate(insertSql);
        System.out.println(num);
        //一次会话
        String sql = "select * from orders limit 0 ,10";
        ResultSet set = statement.executeQuery(sql);
        //执行SQL语句
        while (set.next()) {
            String id = set.getString(1);
            String name = set.getString(2);
            String money = set.getString(3);
            //接着一个一个的区便利
            System.out.println(id + "<===========>" + name + "<===========>" + money);
        }
        //返回结果集
        set.close();
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        //关闭资源

    }
}
```

## Mybatis 是如何实现的

### Mybatis 执行过程
可参照该博客：

https://blog.csdn.net/u014297148/article/details/78696096


### 如何读取配置文件
XMLConfigBuilder.java
```
/*
此段代码将配置文件中的内容加载到configuration 中
*/
 private void parseConfiguration(XNode root) {
        try {
            //加载db.properties 文件到properties 中，便于解析外部配置
            this.propertiesElement(root.evalNode("properties"));
            Properties settings = this.settingsAsProperties(root.evalNode("settings"));
            this.loadCustomVfs(settings);
            //解析别名配置 
            this.typeAliasesElement(root.evalNode("typeAliases"));
            this.pluginElement(root.evalNode("plugins"));
            this.objectFactoryElement(root.evalNode("objectFactory"));
            this.objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
            this.reflectorFactoryElement(root.evalNode("reflectorFactory"));
            //设置默认值，如果配置中setting 存在配置，则按照setting中的配置，如果没有，则在此处进行初始化
            this.settingsElement(settings);
            // 环境的配置，例如线程池，链接，用户名，密码，驱动，事务等内容
            this.environmentsElement(root.evalNode("environments"));
            this.databaseIdProviderElement(root.evalNode("databaseIdProvider"));
            this.typeHandlerElement(root.evalNode("typeHandlers"));
            this.mapperElement(root.evalNode("mappers"));
        } catch (Exception var3) {
            throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + var3, var3);
        }
    }
```
#### 环境读取
```java
private void environmentsElement(XNode context) throws Exception {
    //获取环境节点<environments default="development">
    if (context != null) {
      if (environment == null) {
        environment = context.getStringAttribute("default");
      }
      //读取一个环境节点 <environment id="development">
      for (XNode child : context.getChildren()) {
        String id = child.getStringAttribute("id");
        if (isSpecifiedEnvironment(id)) {
        // 事务 <transactionManager type="JDBC"/>
          TransactionFactory txFactory = transactionManagerElement(child.evalNode("transactionManager"));
          // 数据库内容<dataSource type="POOLED">
          DataSourceFactory dsFactory = dataSourceElement(child.evalNode("dataSource"));
          DataSource dataSource = dsFactory.getDataSource();
          Environment.Builder environmentBuilder = new Environment.Builder(id)
              .transactionFactory(txFactory)
              .dataSource(dataSource);
          configuration.setEnvironment(environmentBuilder.build());
        }
      }
    }
  }
```
#### mapper解析
```java
private void mapperElement(XNode parent) throws Exception {
    if (parent != null) {
      for (XNode child : parent.getChildren()) {
        if ("package".equals(child.getName())) {
          String mapperPackage = child.getStringAttribute("name");
          configuration.addMappers(mapperPackage);
        } else {
          String resource = child.getStringAttribute("resource");
          String url = child.getStringAttribute("url");
          String mapperClass = child.getStringAttribute("class");
          // 获取到mapper resource 路径，解析resource
          if (resource != null && url == null && mapperClass == null) {
            ErrorContext.instance().resource(resource);
            // 读取
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建一个mapper builder 解析
            XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
            //解析mapper.xml 文件
            mapperParser.parse();
            // 解析远程的url 的mapper 文件
          } else if (resource == null && url != null && mapperClass == null) {
            ErrorContext.instance().resource(url);
            InputStream inputStream = Resources.getUrlAsStream(url);
            XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, url, configuration.getSqlFragments());
            mapperParser.parse();
          } else if (resource == null && url == null && mapperClass != null) {
            Class<?> mapperInterface = Resources.classForName(mapperClass);
            configuration.addMapper(mapperInterface);
          } else {
            throw new BuilderException("A mapper element may only specify a url, resource or class, but not more than one.");
          }
        }
      }
    }
  }
```
XMLMapperBuilder.java
```java
private void configurationElement(XNode context) {
    try {
    //读取namespace <mapper namespace="com.mybatis.mapper.OrderMapper">
      String namespace = context.getStringAttribute("namespace");
      if (namespace == null || namespace.equals("")) {
        throw new BuilderException("Mapper's namespace cannot be empty");
      }
      builderAssistant.setCurrentNamespace(namespace);
      cacheRefElement(context.evalNode("cache-ref"));
      cacheElement(context.evalNode("cache"));
      //读取parameterMap<parameterMap>
      parameterMapElement(context.evalNodes("/mapper/parameterMap"));
      // 读取resultMap <resultMap>
      resultMapElements(context.evalNodes("/mapper/resultMap"));
      // 读取sql<sql  >
      sqlElement(context.evalNodes("/mapper/sql"));
      // 解析执行的语句<select><insert><update><delete>
      buildStatementFromContext(context.evalNodes("select|insert|update|delete"));
    } catch (Exception e) {
      throw new BuilderException("Error parsing Mapper XML. The XML location is '" + resource + "'. Cause: " + e, e);
    }
  }
```
XMLStatementBuilder.java
```java
 public void parseStatementNode() {
    String id = context.getStringAttribute("id");
    String databaseId = context.getStringAttribute("databaseId");

    if (!databaseIdMatchesCurrent(id, databaseId, this.requiredDatabaseId)) {
      return;
    }

    Integer fetchSize = context.getIntAttribute("fetchSize");
    Integer timeout = context.getIntAttribute("timeout");
    String parameterMap = context.getStringAttribute("parameterMap");
    String parameterType = context.getStringAttribute("parameterType");
    Class<?> parameterTypeClass = resolveClass(parameterType);
    String resultMap = context.getStringAttribute("resultMap");
    String resultType = context.getStringAttribute("resultType");
    String lang = context.getStringAttribute("lang");
    LanguageDriver langDriver = getLanguageDriver(lang);

    Class<?> resultTypeClass = resolveClass(resultType);
    String resultSetType = context.getStringAttribute("resultSetType");
    StatementType statementType = StatementType.valueOf(context.getStringAttribute("statementType", StatementType.PREPARED.toString()));
    ResultSetType resultSetTypeEnum = resolveResultSetType(resultSetType);

    String nodeName = context.getNode().getNodeName();
    SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));
    boolean isSelect = sqlCommandType == SqlCommandType.SELECT;
    boolean flushCache = context.getBooleanAttribute("flushCache", !isSelect);
    boolean useCache = context.getBooleanAttribute("useCache", isSelect);
    boolean resultOrdered = context.getBooleanAttribute("resultOrdered", false);

    // Include Fragments before parsing
    XMLIncludeTransformer includeParser = new XMLIncludeTransformer(configuration, builderAssistant);
    includeParser.applyIncludes(context.getNode());

    // Parse selectKey after includes and remove them.
    processSelectKeyNodes(id, parameterTypeClass, langDriver);
    
    // Parse the SQL (pre: <selectKey> and <include> were parsed and removed)
    SqlSource sqlSource = langDriver.createSqlSource(configuration, context, parameterTypeClass);
    String resultSets = context.getStringAttribute("resultSets");
    String keyProperty = context.getStringAttribute("keyProperty");
    String keyColumn = context.getStringAttribute("keyColumn");
    KeyGenerator keyGenerator;
    String keyStatementId = id + SelectKeyGenerator.SELECT_KEY_SUFFIX;
    keyStatementId = builderAssistant.applyCurrentNamespace(keyStatementId, true);
    if (configuration.hasKeyGenerator(keyStatementId)) {
      keyGenerator = configuration.getKeyGenerator(keyStatementId);
    } else {
      keyGenerator = context.getBooleanAttribute("useGeneratedKeys",
          configuration.isUseGeneratedKeys() && SqlCommandType.INSERT.equals(sqlCommandType))
          ? Jdbc3KeyGenerator.INSTANCE : NoKeyGenerator.INSTANCE;
    }

    builderAssistant.addMappedStatement(id, sqlSource, statementType, sqlCommandType,
        fetchSize, timeout, parameterMap, parameterTypeClass, resultMap, resultTypeClass,
        resultSetTypeEnum, flushCache, useCache, resultOrdered, 
        keyGenerator, keyProperty, keyColumn, databaseId, langDriver, resultSets);
  }
```

### 如何执行

### 结果集如何解析