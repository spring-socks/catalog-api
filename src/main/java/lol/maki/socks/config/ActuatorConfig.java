package lol.maki.socks.config;

import io.micrometer.core.instrument.config.MeterFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {
	@Bean
	public MeterFilter customMeterFilter() {
		return MeterFilter.deny(id -> {
			String uri = id.getTag("uri");
			// exclude requests to the healthcheck endpoints
			return uri != null && (uri.equals("/readyz") || uri.equals("/livez") || uri.startsWith("/actuator/health"));
		});
	}
}