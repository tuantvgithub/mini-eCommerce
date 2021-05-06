package hust.soict.hedspi.mproduct.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my-config")
@RefreshScope
public class ApplicationPropertiesConfiguration {
    private int limitProduct;

    public int getLimitProduct() {
        return limitProduct;
    }

    public void setLimitProduct(int limitProduct) {
        this.limitProduct = limitProduct;
    }
}
