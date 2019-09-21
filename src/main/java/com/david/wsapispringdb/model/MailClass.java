/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.model;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author david
 */
public class MailClass {

    public String SendMail(String nombre, String correo,int plantilla,String subject) {
        try {
            MailjetClient client;
            MailjetRequest request;
            MailjetResponse response;
            client = new MailjetClient("d2ffe97c1057d67b8b408dc9a6c62e4f", "3aec2d0df1b39cdf6b8b6d11c0943ce7", new ClientOptions("v3.1"));
            request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, new JSONArray()
                            .put(new JSONObject()
                                    .put(Emailv31.Message.FROM, new JSONObject()
                                            .put("Email", "david88basto@gmail.com")
                                            .put("Name", "ClavaFacil"))
                                    .put(Emailv31.Message.TO, new JSONArray()
                                            .put(new JSONObject()
                                                    .put("Email", correo)
                                                    .put("Name", nombre)))
                                    .put(Emailv31.Message.TEMPLATEID, plantilla)
                                    .put(Emailv31.Message.TEMPLATELANGUAGE, true)
                                    .put(Emailv31.Message.SUBJECT, subject)
                                    .put(Emailv31.Message.VARIABLES, new JSONObject())));
            response = client.post(request);
            System.out.println(response.getStatus());
            System.out.println(response.getData());
            return "SUC";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "ERR";
        }
    }
}
