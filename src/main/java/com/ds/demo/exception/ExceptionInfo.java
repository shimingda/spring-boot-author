package com.ds.demo.exception;

public class ExceptionInfo {

        //发件人姓名
        private String developer;
        //发件人方法
        private String method;
        //发件人url
        private String url;
        //发件人捕获异常信息
        private Exception e;

        /**
         * @param developer 发件人姓名
         * @param method 发件人方法
         * @param url 发件人url
         * @param e 发件人捕获异常信息
         */
        public ExceptionInfo(String developer, String method, String url, Exception e) {
            super();
            this.developer = developer;
            this.method = method;
            this.url = url;
            this.e = e;
        }
        public String getDeveloper() {
            return developer;
        }
        public void setDeveloper(String developer) {
            this.developer = developer;
        }
        public String getMethod() {
            return method;
        }
        public void setMethod(String method) {
            this.method = method;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public Exception getE() {
            return e;
        }
        public void setE(Exception e) {
            this.e = e;
        }


    }
