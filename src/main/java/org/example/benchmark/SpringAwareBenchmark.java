package org.example.benchmark;

import org.openjdk.jmh.annotations.Setup;
import org.springframework.context.support.GenericXmlApplicationContext;

public abstract class SpringAwareBenchmark
{
  @Setup
  public void setup()
  {
    new GenericXmlApplicationContext("classpath:springContext.xml")
        .getAutowireCapableBeanFactory()
        .autowireBean(this);
  }
}
