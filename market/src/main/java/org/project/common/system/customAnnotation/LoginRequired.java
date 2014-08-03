package org.project.common.system.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
	/*
	 * 로그인 체크 어노테이션
	 * 인터셉터로 지정된 url이 있는 클래스의 메소드에 이 어노테이션이 있으면 인터셉터에서 로그인 체크를 수행한다.
	 */
}
