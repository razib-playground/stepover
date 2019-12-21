#                                 Concepts

## Webapplication/J2EE

### Servlet

### Filter

### Servlet Container, Application Server

### web.xml

### Session and Cookies



<div style="text-align:center; color:gray; font-size:12px; margin-bottom:0px; padding-bottom:0px;">Webapplication/J2EE</div>
<hr/>



## Spring Concepts



### Dependency Injection

- **resources:** 
  - https://www.journaldev.com/2410/spring-dependency-injection



### Spring Beans and Beans Scope

- **resources:**
  - https://www.journaldev.com/21039/spring-bean-scopes



### Spring Container

- **resources:**
  - https://howtodoinjava.com/spring-core/different-spring-ioc-containers/
  - https://www.journaldev.com/2461/spring-ioc-bean-example-tutorial
  - https://howtodoinjava.com/spring-core/different-spring-ioc-containers/



### Spring Component Scanning

- **resources:**
  -  



### Spring Proxy

- **resources:**
  - pitfalls of proxies:
    -  https://www.nurkiewicz.com/2011/10/spring-pitfalls-proxying.html 



### How Spring MVC Works? How HTTP request is processed?

- **resources:**
  - https://javarevisited.blogspot.com/2017/06/how-spring-mvc-framework-works-web-flow.html



<div style="text-align:center; color:gray; font-size:12px; margin-bottom:0px; padding-bottom:0px;">Spring Concepts</div>
<hr/>


##  JPA/Hibernate

### [Persistence Context](https://stackoverflow.com/questions/19930152/what-is-persistence-context)

- A persistence context is a set of entity instances in which for any persistent entity identity there is a unique entity instance. Within the persistence context, the entity instances and their lifecycle is managed by a particular entity manager. The scope of this context can either be the transaction, or an extended unit of work.
- Both the `org.hibernate.Session` (Hibernate) API and `javax.persistence.EntityManager` (JPA) API represent a persistence context. 
-  it is like a **cache** which contains a set of persistence entities
- **resources:** 
  - [Hibernate Documentation>Devguide>Chapter 3 - Persistance Contexts](https://docs.jboss.org/hibernate/core/4.0/devguide/en-US/html/ch03.html)
    - entity states - new/transient, managed/persistence, detached, removed
  - [Hibernate Documentation>EntityManager>Chapter 01 - Architecture](https://docs.jboss.org/hibernate/entitymanager/3.5/reference/en/html/architecture.html)
    - persistence context, persistence unit, EntityManager, EntityManagerFactory etc

- **Persistence Unit:** 
  - The set of entity types that can be managed by a given entity manager is defined by a persistence unit. A persistence unit defines the set of all classes that are related or grouped by the application, and which must be collocated in their mapping to a single data store.



<div style="text-align:center; color:gray; font-size:12px; margin-bottom:0px; padding-bottom:0px;">JPA/Hibernate</div>
<hr/>












<hr/>
#                          Important Annotations

## Spring Annotations by Group

### Spring Core Annotations 

- **package(s):** 

  - `org.springframework.beans.factory.annotation` 
  - `org.springframework.context.annotation`

- **DI - Related:**  `@Autowired`, `@Bean` , `@Qualifie`, `@Required` , `@Value`, `@DependsOn, @Lazy, @Lookup, @Primary, @Scope`.

- **Context Configuration Annotations:**  `@Profile, @Import, @ImportResource, @PropertySource, @PropertySources`

- **resources**: 

  - [Spring Core Annotation](https://www.baeldung.com/spring-core-annotations) by Baeldung  

  

### Spring Bean Annotations

- <span style="color: green">we can mark a class with one of the annotations from the *`org.springframework.stereotype`* package and leave the rest to component scanning.</span>

- **package(s)**: 

  - `org.springframework.stereotype`
  - **some important annotations:** `@Component, @Repository, @Service, @Controller, @Configuration`
  - **Stereotype Annotations and AOP:** 
    - with stereotype annotations it's easy to create a pointcut (`@Pointcut`) that targets all classes that have a particular stereotype

- **resources:**  

  - [Spring Bean Annotations](https://www.baeldung.com/spring-bean-annotations) by Baeldung

  

### Spring Web Annotations

- **package(s)** : `org.springframework.web.bind.annotation` 

- **request related:** `@RequestMappin, @RequestBody, @PathVariable, @RequestParam`

- **response handling:** `@ResponseBody, @ExceptionHandler, @ResponseStatus`

- **other:** `@Controller, @RestController, @ModelAttribute`

- **resources**: 

  - [Spring Web Annotations](https://www.baeldung.com/spring-mvc-annotations) by Baeldung  

    

### Spring Boot Annotations

- **package(s):** 
  - `sprig.springframework.boot.autoconfigure` 
  - `org.springframework.boot.autoconfigure.condition`
- **basics:** `@SpringBootApplication, @EnableAutoConfiguration`
- **auto configuration conditions related:**  
  - `@CoditionalOnClass and @ConditionalOnMissingClass`
  - `@CoditionalOnBean and @ConditionalOnMissingBean` 
  - `@ConditionalOnProperty`
  - `@ConditionalOnResource` 
  - `@CoditionalOnWebApplication and @ConditionalOnNotWebApplication`
  - `@ConditionalException`
  - `@Conditional` 

- **resources**: 

  -  [Spring Boot Annotations](https://www.baeldung.com/spring-boot-annotations) by Baeldung

    

### Spring Data Annotation

- **common spring data annotation:** 

  -  `@Transactional`
  - ` @NonRepositoryBean ` 
  - `@Param`
  - ` @Id` 
  - ` @Transient ` 
  - `@CreatedBy, @LastModifiedBy, @CreatedDAte, @LastModifiedDate`

- **spring data jpa annotations**: `@Query, @Procedure, @Lock, @Modifiying, @EnableJpaRepositories`

- **spring data mongoDB annotations:** `@Document, @Field, @Query, @EnableMongoRepositories`

- **resources**:

  - [Spring Data Annotations](https://www.baeldung.com/spring-data-annotations) by Baeldung

    

### Spring Scheduling Annotations

- **package(s):** `org.springframework.scheduling.annotation`

- **common annotations:** `@EnableScheduling, @EnableAsync, @Async, @Scheduled, @Schedules`

- **resources:** 

  - [Spring Scheduling Annotations](https://www.baeldung.com/spring-scheduling-annotations) by Baeldung 

    

<div style="text-align:center; color:gray; font-size:12px; margin-bottom:0px; padding-bottom:0px;">Spring Annotations by Group</div>
<hr/>




## Some Useful Annotations(Spring, JPA, Hibernate etc)

### @Configuration 

- part of spring core framework 
- `@Configuration`  <span style="color:green; background-color:yellow;"> *annotation indicates that a class has `@Bean` definition methods. So Spring container (application context) can process the class to generate Spring Beans to be used in the application*</span>
- **read more**: 
  - [Spring @Configuration Annotation](https://www.journaldev.com/21033/spring-configuration-annotation)
    - <span style="font-size:0.7em; color:ash">nice article with proof that bean created by `@Bean` annotation are singletone by default </span>
    - keywords: bean scope, bean
  - [Why Spring Boot Application class needs to have @configuration annotation](https://stackoverflow.com/questions/39247487/why-spring-boot-application-class-needs-to-have-configuration-annotation)



### @EnableTransactionManagement

- it is used in a spring `@Configuration` class to enable transactional support 

  ```java
  @Configuration
  @EnableTransactionManagement
  public class PersistenceJPAConfig{
   
     @Bean
     public LocalContainerEntityManagerFactoryBean
       entityManagerFactoryBean(){
        //...
     }
   
     @Bean
     public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
          entityManagerFactoryBean().getObject() );
        return transactionManager;
     }
  }
  ```

  

-  however if we use Spring Boot project and have a `spring-data-*` or `spring-tx` dependencies on the class path, then the transaction management will be enabled by  default. 

### @Transactional 

- after transaction enabled (by automatic or configuration) we can use` @Transactional` annotation. It can be used at class or method level

  ```java
  @Service
  @Transactional
  public class FooService {
      //...
  }
  ```

  -  the `@Transactional` annotation supports further configuration as well:
    - the ***Propagation Type*** of the transaction 
    - the ***Isolation Level*** of transaction 
    - a ***Timeout*** for the operation wrapped by the transaction
    - a ***readOnly flag***  - a hint for the persistence provider that the transaction should be read only
      
      - Note – by default, rollback happens for runtime, unchecked exceptions only. **The checked exception does not trigger a rollback** of the transaction. We can, of course, configure this behavior with the ***rollbackFor*** and ***noRollbackFor*** annotation parameters
    - **read more:** 
      - https://www.javacodegeeks.com/2016/05/understanding-transactional-annotation-spring.html
      - https://www.baeldung.com/transaction-configuration-with-jpa-and-spring 
      



### @Controller, @ResponseBody, @RestController

- The job of`@Controller` is to create a Map of model object and find a view but `@RestController` simply return the object and the object data are written into HTTP response as JSON or XML
- You also can write the object data in HTTP response body with the traditional `@Controller` but you need to use `@ResponseBody` annotation along with the `@Controlelr` annotation. 
  
- when you use the `@RestController` you don't need to use the `@ResponseBody` annotation to write the object data in HTTP response. 
  
- `@RestControlelr` is nothing but a combination of both`@Controller` and `@ResponseBody`

  - it was added at Spring 4.0 to make the RESTful webservice development easier
  - <span style="background-color: yellow;">one of the very important difference between web application and REST API ist that the responses from a web application generally produces view (HTML+CSS+Javascript), since web application are intendent for human viewers. Front end and backend are tightly coupled. </span>
    - <span style="background-color: yellow;">REST API returns data in form of JSON or XML because most of the REST clients are programs </span> 

  

### @ResponseBody vs. @Request Body

-  

- **How do @ResponseBody and @RequestBody Work?:**

  

### @RequestMapping, @RequestParam, @PathVariable

- **@RequestMapping**
  - one of the most common annotation used in spring web application
  - it maps HTTP request to handler methods of **MVC** and **REST** controller
  - **resources:**
    - https://dzone.com/articles/using-the-spring-requestmapping-annotation

- **@RequestParam**
  -  both `@RequestParam` and `@PathVariable` are used to extract values from the HTTP request
  - `@RequestMapping` is used to get the request parameters(query parameter) from the URL
- **@PathVariable**
  -  it extract values from the URI itself
    - example: to get the ISBN number of a book from URI we could use **@PathVariable**

```java
URI http://localhost:8080/book/9783827319333

@RequestMapping(value="/book/{ISBN}", method= RequestMethod.GET)
public String showBookDetails(@PathVariable String isbnNumber, Model model){
   model.addAttribute("ISBN", isbnNumber);
   return "bookDetails";
}
```



<div style="text-align:center; color:gray; font-size:12px; margin-bottom:0px; padding-bottom:0px;">Some Useful Annotation (Spring, JPA, Hibernate etc)</div>
<hr/> 














#                            Important Classes

## <u>DataSource, EntityManager, TransactionManager and SessionFactory</u>

- if you are using spring spring boot then you may not need to use any of the class above explicitly.	
  
- spring boot search the class path and scan for different jar/library. Based on what is found in class path it create/configures these above class
  
- If spring boot get an in memory`H2 Database` dependency in class path then it will create H2 DataSource implementation. In this specific case of `H2 Database` spring boot also create/configure connection pool (based on what found in class path) for `HikariCP`, `Apache Tomcat`, or `Common DBCP`. 

  

- ### DataSource

  - package: `javax.sql`

    - will available through `jt.jar`

  - <span style="color:green; background-color:yellow;"> it is factory for the connection to the physical data source</span>

  - It's an interface and implemented by driver vendor. There could be 3 types of implementations - 

    - ***basic implementation*** - produce a standard `Connection` object
    - ***connection pooling implementation***  - produces a `Connection` object that will automatically participate in connection pooling. This work with middle-tier connection pooling manager.
    - ***distributed transaction implementation***  - produces a `Connection` object that may be use for distribute transaction and almost always participate in connection pooling. 

  - **How it looks:** 

    ```java
    public interface DataSource  extends CommonDataSource, Wrapper {
      Connection getConnection() throws SQLException;
      Connection getConnection(String username, String password)
        throws SQLException;
    }
    
    ```

  - in `DataSource` we provide the physical data source connection url, username, password etc.  These are read from  configuration (`application.properties` or some `.xml` or `.yml`) file.

    ```pr
    spring.datasource.url=jdbc:mysql://localhost:3306/test_db
    spring.datasource.username=root
    spring.datasource.password=root
    ```

  - for single data source we don't need to manually create/configure the `DataSource` object. Spring boot do it for us. Spring boot also configure the connection pool for us. With `Spring Boot 1` it  was `Tomcat Pool` as connection pool provider. Later from `Spring Boot 2` `HikiriCp` is used as default.

  - if you want better level of customization you can create your own `DataSource.` **The simplest way to accomplish this is by defining a `DataSource` factory method, and placing it within a class annotated with the `@Configuration` annotation** 

    ```java
    @Configuration
    public class DataSourceConfig {
    	
        @Bean(name = "masterDataSource")
        public DataSource masterDataSource() {
            LOG.info("Setting up masterDataSource with: "
                    + masterDbProperties.toString());
    
            HikariDataSource ds = new HikariDataSource();
            ds.setUsername(masterDbProperties.getUsername());
            ds.setPassword(masterDbProperties.getPassword());
            ds.setJdbcUrl(masterDbProperties.getUrl());
            ds.setDriverClassName(masterDbProperties.getDriverClassName());
            ds.setPoolName(masterDbProperties.getPoolName());
            // HikariCP settings
            // Maximum number of actual connection in the pool
            ds.setMaximumPoolSize(masterDbProperties.getMaxPoolSize());
            // Minimum number of idle connections in the pool
            ds.setMinimumIdle(masterDbProperties.getMinIdle());
            // Maximum waiting time for a connection from the pool
            ds.setConnectionTimeout(masterDbProperties.getConnectionTimeout());
            // Maximum time that a connection is allowed to sit idle in the pool
            ds.setIdleTimeout(masterDbProperties.getIdleTimeout());
            LOG.info("Setup of masterDataSource succeeded.");
            return ds;
        }
    }
    ```

  - **Resources:** 

    - [Configure DataSource Pragrammatically in Spring Boot](https://www.baeldung.com/spring-boot-configure-data-source-programmatic)

    -  [A Simple Guide to Connection Pooling in Java](https://www.baeldung.com/java-connection-pooling)

      

- ### EntityManager 

  -  **package:** `javax.persistence.EntityManager` 
  -   an JPA element
  -   it represents a persistent context 
  -   this interface is similar to `Session` in hibernate
  -   The `EntityManager` API is used to access a database in a particular unit of work. 
  -   It is used to create and remove persistent entity instances, to find entities by their primary key identity, and to query over all entities
  -  resources:
     -  [JPA - Persistence-Context vs Persistence-Unit. Proper use of EntityManager and EntityManagerFactory](https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/entity-context.html)
        -   persistence-context, persistent unit, EntityManager, different way of creating EntityManager etc 
  
- ### TransactionManager

- ### Session

- ### Session vs. EntityManager

- Some others















