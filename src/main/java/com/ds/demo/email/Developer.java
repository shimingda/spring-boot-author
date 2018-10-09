package com.ds.demo.email;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class Developer {

        //发件人emai
        private List<String> mail;

        public List<String> getMail() {
            return mail;
        }
        public void setMail(List<String> mail) {
        this.mail = mail;
    }
}
