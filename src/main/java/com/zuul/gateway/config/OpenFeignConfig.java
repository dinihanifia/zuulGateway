//package com.zuul.gateway.config;
//
//import feign.Client;
//import feign.Logger;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.ssl.SSLContexts;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//
//@Configuration
//@Slf4j
//public class OpenFeignConfig {
//    @Bean
//    Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }
//
//    @Bean
//    public Client feignClient() {
//        return new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
//    }
//
//    private SSLSocketFactory getSSLSocketFactory() {
//        try {
//            TrustStrategy acceptingTrustStrategy = (chain, authType) -> true;
//
//            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
//            return sslContext.getSocketFactory();
//        } catch (Exception exception) {
//            log.warn("Catch Exception : {}", ExceptionUtils.getFullStackTrace(exception));
//        }
//        return null;
//    }
//}
