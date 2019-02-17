package campsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class App {

	@Autowired
	private ApplicationContext context;

	@Bean
	public ServletRegistrationBean<DispatcherServlet> campsite() {
		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
		applicationContext.setParent(context);
		applicationContext.setConfigLocation("classpath:/META-INF/rest.xml");

		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setApplicationContext(applicationContext);

		ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<DispatcherServlet>(
				dispatcherServlet, "/campsite/*");
		servletRegistrationBean.setName("campsite");

		return servletRegistrationBean;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}
