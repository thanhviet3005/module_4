package com.codegym.cms;
import com.codegym.cms.repository.CustomerRepository;
import com.codegym.cms.repository.impl.CustomerRepositoryImpl;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.impl.CustomerServiecImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.codegym.cms")
public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiecImpl();
    }

    //Thymeleaf Configuration
    // dat ten duong dan va duoi cac file view de config
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    // thiet lap mau hien thi cho cac view
    @Bean
    public TemplateEngine templateEngine(){
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    //__+__+__+__+__+__+__+__+
    // thiet lap Thymeleaf viewResolver cho tầng view

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    //JPA configuration
    // EntityManager là interface cung cấp các api để thao tác giữa csdl với ứng dụng
    // EntityManagerFactory là một factory class của EntityManager để khởi tạo và quản lý
    // các EntityManager
    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    //localContainerEntityManagerFactoryBean() đóng vai trò tạo ra một
    // LocalContainerEntityManagerFactoryBean, sau đó nó sẽ sinh ra một EntityManagerFactory và
    // từ EntityManagerFactory các EntityManager được tạo ra.
    // Các EntityManager cung cấp API cho phép nó quản lý các entity của application trong
    // persistence context mà nó được liên kết tới.

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.codegym.cms.model"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    //__+__+__+__+__+__+__+__+
    // thiet lap ket noi toi csdl gom
    // + driver class cho mysql,
    // + duong dan ket noi toi mysql ben trong
    // + acc va pass de dang nhap vao mysql
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cms");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "123456" );
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    //__+__+__+__+__+__+__+__+
    // thiet lap thuoc tinh cap nhat_update toi csdl,
    // thiet lap dialect là do làm việc với các loại database khác nhau thì hibernate sử
    // dụng tham số “Dialect” để biết được loại database nào đang được sử dụng,
    // như thế các câu lệnh SQL được sinh ra sẽ phù hợp với database.

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }




    //__+__+__+__+__+__+__+__+
    //    Ví dụ về phương thức clone lại đối tượng để tạo ra, tiết kiệm bộ nhớ thay vì tạo ra một
    // đối tượng mới hoàn toàn như ở ví dụ dưới
    //    public Object clone() throws CloneNotSupportedException {
    //        return super.clone();
    //    }
    //
    //    public static void main(String args[]) {
    //        try {
    //            Student s1 = new Student(101, "An");
    //            Student s2 = (Student) s1.clone();
    //            System.out.println(s1.rollno + " " + s1.name);
    //            System.out.println(s2.rollno + " " + s2.name);
    //        } catch (CloneNotSupportedException c) {
    //        }

    //__+__+__+__+__+__+__+__+
    //__+__+__+__+__+__+__+__+
}
