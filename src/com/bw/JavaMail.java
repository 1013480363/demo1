package com.bw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	public static void main(String[] args) throws MessagingException, InterruptedException {
		// 1.创建一个程序与邮件服务器会话对象 Session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.smtp.host", "smtp.163.com");
		props.setProperty("mail.smtp.port", "25");
		// 指定验证为true
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.timeout", "5000");
		// 验证账号及密码，密码需要是第三方授权码
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("l1013480363@163.com", "lixianfeng0");
			}
		};
		Session session = Session.getInstance(props, auth);
		System.out.println(222);
		System.out.println(33);
		// 2.创建一个Message，它相当于是邮件内容
		MimeMessage message = new MimeMessage(session);
		// 设置发送者
		message.setFrom(new InternetAddress("l1013480363@163.com"));
		// 设置发送方式与接收者
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1013480363@qq.com"));
		// 设置主题
		message.setSubject("王坤主题");
		// 设置内容
		message.setContent("王坤小可爱", "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送
		while (true) {
			Transport.send(message);
			TimeUnit.SECONDS.sleep(1);
			System.out.println("发送成功");
		}
	}
}
