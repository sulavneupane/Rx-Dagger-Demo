package com.nepalicoders.rxdaggerdemo.dependencies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Sulav on 8/28/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
