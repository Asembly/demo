package asembly.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {
	public static void main(String[] args) {
        try {
            SpringApplication.run(Server.class, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
