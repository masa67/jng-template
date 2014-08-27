package example.com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoConfiguration {
	
	@Value("${userdb.name}")
	private String dbName;
	
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}	
}

