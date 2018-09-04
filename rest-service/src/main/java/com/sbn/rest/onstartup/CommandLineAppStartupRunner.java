package com.sbn.rest.onstartup;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sbn.rest.properties.AmpsProperties;
import com.sbn.rest.properties.GlobalProperties;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

	@Autowired
	private Environment environment;

	@Autowired
	private AmpsProperties app;
	@Autowired
	private GlobalProperties global;

	@Override
	public void run(String... args) throws Exception {
		LOG.info(Arrays.asList(environment.getDefaultProfiles()).stream().collect(Collectors.joining("\n")));

		String appProperties = app.toString();
		String globalProperties = global.toString();

		LOG.info("Welcome {}, {}", app, global);

	}
}
