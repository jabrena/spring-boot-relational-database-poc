# MyBatis review

## Dependencies

```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.1</version>
</dependency>

<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.4.1</version>
    <configuration>
        <includeAllDependencies>true</includeAllDependencies>
        <overwrite>true</overwrite>
    </configuration>
</plugin>

<dependency>
    <groupId>org.mybatis.dynamic-sql</groupId>
    <artifactId>mybatis-dynamic-sql</artifactId>
    <version>1.4.1</version>
</dependency>
```

## Features

- CRUD
- INSERT & RETURN key

## References

- https://mybatis.org/spring/
- http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
- https://mybatis.org/generator/running/runningWithMaven.html
- https://mybatis.org/generator/configreference/context.html
- https://mybatis.org/generator/reference/plugins.html
