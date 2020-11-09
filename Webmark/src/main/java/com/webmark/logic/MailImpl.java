package com.webmark.logic;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.webmark.model.PassMailVO;

@Service
public class MailImpl implements Mail {
	@Autowired
	private JavaMailSenderImpl mailSender;

	public Integer sendPassMail(final PassMailVO vo) {
			final MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mime) throws Exception {
				final MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");
				helper.setFrom(vo.getFrom());
				helper.setTo(vo.getTo());
				helper.setSubject(vo.getSubject());
				helper.setText(vo.getContents(), true);
			}
		};
		
		mailSender.send(preparator);
		return null;
	}

}
