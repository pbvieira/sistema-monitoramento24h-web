package br.com.azindustria.azsim;

import br.com.azindustria.azsim.container.MongoDbContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = AzsimApplicationTest.MongoDbInitializer.class)
@EnableMongoRepositories(basePackages = "br.com.azindustria.azsim.adapter.repository.mongo")
@ActiveProfiles("test")
public abstract class AzsimApplicationTest {

    protected static MongoDbContainer mongoDbContainer;

    public static class MongoDbInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues values = TestPropertyValues.of(
                    String.format("spring.data.mongodb.uri=mongodb://%s:%s/azsimtestdb",
                            mongoDbContainer.getHost(),
                            mongoDbContainer.getPort()));
            values.applyTo(configurableApplicationContext);
        }
    }
}
