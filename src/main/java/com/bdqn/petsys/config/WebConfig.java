package com.bdqn.petsys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.core.convert.converter.Converter; // 必须导入此包
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                // 支持 "yyyy-MM-dd" 和 "yyyy-MM-dd HH:mm:ss" 两种格式
                if (source == null || source.isEmpty()) {
                    return null;
                }
                try {
                    // 尝试解析完整时间格式
                    return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                } catch (Exception e) {
                    // 如果失败，尝试解析日期格式
                    return LocalDateTime.parse(source + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                }
            }
        });
    }
}