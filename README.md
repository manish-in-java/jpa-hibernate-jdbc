[![Build Status](https://drone.io/github.com/manish-in-java/jvm-benchmark/status.png)](https://drone.io/github.com/manish-in-java/jvm-benchmark/latest)

[![Build Status](https://codeship.com/projects/ac168df0-f822-0132-8ade-22801fbd7bef/status?branch=master)](https://codeship.com/projects/86533)

# Overview
This is a collection of micro-benchmarks that can be used to measure the performance
offered by different Java Virtual Machines (JVMs).  The objective is to quantify the
execution time and throughput of different JVMs so that they can be compared to each
other objectively.

This application uses [JMH](http://openjdk.java.net/projects/code-tools/jmh/), a
popular micro-benchmarking tool for running the benchmarks.  The advantage of using
JMH lies in the fact that it attempts to run the benchmark under conditions close
to realistic scenarios by performing tasks such as JVM warmup, multi-iteration
measurements and JVM cooldown.  It even compiles and presents statistical parameters
for the measurements such as minimum, maximum, mean, standard deviation, etc.

# License
This sample application and its associated source code in its entirety is being made
available under the following licensing terms.

    Copyright (C) 2014

    Permission is hereby granted, free of charge, to any person obtaining a copy of
    this software and associated documentation files (the "Software"), to deal in the
    Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
    and to permit persons to whom the Software is furnished to do so, subject to the
    following conditions:

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
    PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
    HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
    CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
    OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
