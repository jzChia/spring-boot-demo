package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private static final Log log = LogFactory.getLog(DemoApplicationTests.class);
	@Autowired
	private JavaMailSender mailSender;

	@Test
	public void sendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("490441342@qq.com");//发送者.
		message.setTo("jiazhijie@navinfo.com");//接收者.
		message.setSubject("测试邮件（邮件主题）");//邮件主题.
		message.setText("这是邮件内容sssjjd");//邮件内容.

		mailSender.send(message);//发送邮件
	}

	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("490441342@qq.com");//发送者.
		helper.setTo("jiazhijie@navinfo.com");//接收者.
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMessage);
	}

	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("490441342@qq.com");//发送者.
		helper.setTo("jiazhijie@navinfo.com");//接收者.
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addInline("weixin", file);

		mailSender.send(mimeMessage);
	}


}


