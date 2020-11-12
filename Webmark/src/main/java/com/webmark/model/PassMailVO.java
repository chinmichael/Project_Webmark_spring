package com.webmark.model;

public class PassMailVO extends MailVO {
	
	public void setContents (String key) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta charset=\"UTF-8\">");
		sb.append("<title>Webmark Service</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<table style=\"width:100%; font-size:10pt;background:#F2F2F2;\">");
		sb.append("<tr style=\"background:#848484; color:white; font-size:18pt;\">");
		sb.append("<td style=\"padding-left:10px;height:20pt;\">Webmark Service Center</td></tr>");
		sb.append("<tr><td style=\"padding-top:20px;padding-left:10px;height:20pt;\">");
		sb.append("안녕하세요 고객님. 요청하신 변경 건은 아래 링크를 통해 처리 가능합니다.</td></tr>");
		sb.append("<tr><td style=\"padding-top:10px;padding-left:10px;height:20pt;\">");
		sb.append("<button style=\"background:#31B404;border:0;color:white;outline:0;height:20pt;border-radius:5px;\">");
		sb.append("<a style=\"text-decoration:none;color:white;\"");
		sb.append("href=\"http://192.168.0.191:8180/Webmark/account/resetForm.html?key="+key+"\">비밀번호 변경</a></button></td></tr>");
		sb.append("</form>");
		sb.append("<tr><td style=\"padding-top:10px;padding-left:10px;height:20pt;\">");
		sb.append("위 링크는 24시간 후 사용이 불가하며, 한 번만 사용 가능합니다.</td></tr>");
		sb.append("<tr><td style=\"padding-left:10px;height:20pt;\">이 메일 이후 새로운 재설정 요청을 하셨다면 이 메일은 사용이 불가능합니다.</td></tr>");
		sb.append("<tr><td style=\"padding-left:10px;height:20pt;\">비밀번호 변경을 원치 않거나, 요청하지 않은 경우 이 메일을 무시하고 삭제하시길 바랍니다.</td></tr>");
		sb.append("<tr><td style=\"padding-top:20px;padding-left:10px;height:20pt;\">감사합니다</td></tr>");
		sb.append("<tr><td style=\"font-weight:bold;padding-left:10px;height:20pt;\">Webmark 팀</td></tr>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		super.setContents(sb.toString());
	}
}
