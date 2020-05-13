package com.leohoc.dse.infrastructure.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.security.InvalidParameterException;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.leohoc.dse.infrastructure.persistence")
public class DynamoDBConfig {

    private static Logger LOGGER = LogManager.getLogger();

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.region}")
    private String amazonAWSRegion;

    @Value("${amazon.aws.profile}")
    private String amazonAWSProfile;

    public DynamoDBConfig() {}

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        LOGGER.info("m=amazonDynamoDB, amazonDynamoDBEndpoint=" + amazonDynamoDBEndpoint);
        LOGGER.info("m=amazonDynamoDB, amazonAWSRegion=" + amazonAWSRegion);
        LOGGER.info("m=amazonDynamoDB, amazonAWSAccessKey=" + amazonAWSProfile);

        AmazonDynamoDBClientBuilder builder = configDBClientBuilder();
        return builder.build();
    }

    protected AmazonDynamoDBClientBuilder configDBClientBuilder() {

        validateProperties();

        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        builder.setEndpointConfiguration(amazonEndpointConfiguration());
        builder.withCredentials(amazonAWSCredentials());
        return builder;
    }

    private AwsClientBuilder.EndpointConfiguration amazonEndpointConfiguration() {
        return new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, amazonAWSRegion);
    }

    private AWSCredentialsProvider amazonAWSCredentials() {
        return new ProfileCredentialsProvider(amazonAWSProfile);
    }

    private void validateProperties() {
        if (StringUtils.isEmpty(amazonDynamoDBEndpoint)
                || StringUtils.isEmpty(amazonAWSRegion)
                || StringUtils.isEmpty(amazonAWSProfile)) {
            throw new InvalidParameterException();
        }
    }
}
