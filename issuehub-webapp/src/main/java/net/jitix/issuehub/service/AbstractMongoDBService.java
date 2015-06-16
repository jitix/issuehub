package net.jitix.issuehub.service;

import javax.annotation.PostConstruct;
import net.jitix.issuehub.config.MongoConfig;
import net.jitix.issuehub.util.DBBootstrapUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public abstract class AbstractMongoDBService {
    
    private MongoOperations mongoOperations;

    @PostConstruct
    public void initialize() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(MongoConfig.class);
        this.mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
        
        DBBootstrapUtil.bootstrapDB(this.mongoOperations);
    }
    
    protected MongoOperations getMongoOperations(){
        return this.mongoOperations;
    }
    
}
