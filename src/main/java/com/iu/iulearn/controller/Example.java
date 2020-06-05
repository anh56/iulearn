//package com.iu.iulearn.controller;
//
//import com.sendgrid.*;
//import java.io.IOException;
//
//public class Example {
//    private final static String token = "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";
//    public static void main(String[] args) throws IOException {
//        Email from = new Email("iulearn@hcmiu.edu.vn");
//        String subject = "Course Registration Confirmation";
//        Email to = new Email("ititiu17024@student.hcmiu.edu.vn");
//        Content content = new Content("text/plain", "Please click on the following link to confirm your course registration");
//        Mail mail = new Mail(from, subject, to, content);
//
//        SendGrid sg = new SendGrid(token);
//        Request request = new Request();
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            Response response = sg.api(request);
//            System.out.println(response.getStatusCode());
//            System.out.println(response.getBody());
//            System.out.println(response.getHeaders());
//        } catch (IOException ex) {
//            throw ex;
//        }
//    }
//}