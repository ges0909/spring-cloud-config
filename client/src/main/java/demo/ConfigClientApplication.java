package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }
}

// The default configuration only allows the values to be read on the client’s
// startup and not again. So, using @RefreshScope we force the bean to refresh
// its configuration, which means it will pull updated values from the Config
// Server, and then trigger a refresh event.
@RefreshScope
@RestController
class MessageRestController {
  @Value("${message:This is the non-configured default value!}")
  private String message;

  @RequestMapping("/message")
  String getMessage() {
    return this.message;
  }
}
