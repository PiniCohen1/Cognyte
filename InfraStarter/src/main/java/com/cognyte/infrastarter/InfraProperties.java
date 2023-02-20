package com.cognyte.infrastarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "cognyte")
public class InfraProperties {
    private boolean logging;
    private boolean info;
    private boolean debug;
}
