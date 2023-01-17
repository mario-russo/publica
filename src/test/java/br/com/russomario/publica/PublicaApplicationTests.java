package br.com.russomario.publica;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
class PublicaApplicationTests {

	@Test
	void contextLoads() {
	}

}
