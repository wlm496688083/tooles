package com.rd.common.util;


import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by wanglm on 2017/4/10.
 */

public class MailUtil {

    private static Properties props = new Properties();
    private static String MAIL_TO = "mail_to";

    static {
        //1. 创建配置
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        props.setProperty("mail.smtp.auth", "true");
    }

    /**
     * 发送异常邮件主方法
     *
     * @param errMsg 异常信息
     */
    public static void sendMail(String errMsg) {

        try {
            // 2. 根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            // 3. 创建一封邮件
            String myEmailAccount = "limin.wang@ebaonet.cn";
            String myEmailPassword = "Wlm112233";
            MimeMessage message = createMimeMessage(session, myEmailAccount, errMsg);

            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();
            transport.connect(myEmailAccount, myEmailPassword);

            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());

            // 7. 关闭连接
            transport.close();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    /**
     * @param session  和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param errMsg   异常信息
     * @return MimeMessage
     */
    private static MimeMessage createMimeMessage(Session session, String sendMail, String errMsg) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "报警邮件客户端", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipients(MimeMessage.RecipientType.TO, createInternetAddress(PropertiesUtil.getValue(MAIL_TO)));

        // 4. Subject: 邮件主题
        message.setSubject("应用异常报警", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(creatErrMsg(errMsg), "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

    private static Object creatErrMsg(String errMsg) {
        return "【ebao】应用[" + PropertiesUtil.getAppName() + "] 服务器[" + IpUtil.getLocalIp() + "] 日期[" + DateUtil.getCurrDate() + "]  \n 异常信息 ： " + errMsg + "\n";
    }

    private static Address[] createInternetAddress(String receiveMail) throws UnsupportedEncodingException {

        String[] receiveMails = receiveMail.split(",");
        int length = receiveMails.length;

        Address[] addresses = new Address[length];

        for (int i = 0; i < length; i++) {
            addresses[i] = new InternetAddress(receiveMails[i], "", "UTF-8");
        }

        return addresses;
    }
}
