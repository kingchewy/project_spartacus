package at.technikumwien.dependencyinjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Stereotype;

@Stereotype
@Alternative
@Retention(RetentionPolicy.RUNTIME)
public @interface Mock {}