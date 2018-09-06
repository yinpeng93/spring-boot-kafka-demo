package com.kedacom.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @Auther: YinPeng
 * @Date: 2018/8/31 0031 14:02
 * @Description:
 */
@Configuration
@EnableKafka
@Data
public class KafkaConsumerConfig {

    @Value("${kafka.consumer.zookeeper.connect}")
    public String zookeeperConnect;
    @Value("${kafka.consumer.servers}")
    public  String servers;
    @Value("${kafka.consumer.enable.auto.commit}")
    public  boolean enableAutoCommit;
    @Value("${kafka.consumer.session.timeout}")
    public  String sessionTimeout;
    @Value("${kafka.consumer.auto.commit.interval}")
    public  String autoCommitInterval;
    @Value("${kafka.consumer.auto.offset.reset}")
    public  String autoOffsetReset;
    @Value("${kafka.consumer.concurrency}")
    public  int concurrency;
}
