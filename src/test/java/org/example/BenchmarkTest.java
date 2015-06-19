package org.example;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkTest
{
  @Test
  public void run() throws RunnerException
  {
    new Runner(new OptionsBuilder()
                   .include(this.getClass().getPackage().getName() + ".*.*Benchmark.benchmark*")
                   .build()).run();
  }
}
