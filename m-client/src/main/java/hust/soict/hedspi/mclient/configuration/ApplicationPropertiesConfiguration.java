package hust.soict.hedspi.mclient.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my-config")
@RefreshScope
public class ApplicationPropertiesConfiguration {

}
