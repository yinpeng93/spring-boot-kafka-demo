package com.kedacom.web;

import com.kedacom.producer.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Auther: YinPeng
 * @Date: 2018/8/31 0031 15:27
 * @Description:
 */
@RestController
public class ProducerController {

    @Autowired
    KafkaSender kafkaSender;

    @RequestMapping("/produce")
    public String producer(){
        try {
            kafkaSender.sendTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "true";
    }
}
