package com.rd.common.util;

import com.jd.jmq.client.producer.MessageProducer;
import com.jd.jmq.common.exception.JMQException;
import com.jd.jmq.common.message.Message;
import com.rd.common.annotation.ConvertException;
import com.rd.common.annotation.UMP;
import com.rd.common.exception.CommonError;
import com.rd.common.exception.SystemRpcUnavailableException;
import com.rd.common.rdenum.Key;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wanglimin1 on 2016/7/12.
 */
@ConvertException
@UMP(Key.RPC)
public class SendJMQUtil<T> {

    @Autowired
    private MessageProducer jmqProducer;

    public void send(T t, String topicId, String businessId) {
        try {
            jmqProducer.send(new Message(topicId, JacksonUtil.writeValueAsString(t), businessId));
        } catch (JMQException e) {
            throw new SystemRpcUnavailableException(CommonError.JMQ_SEND_EXCEPTION, e, topicId, businessId);
        }
    }
}
