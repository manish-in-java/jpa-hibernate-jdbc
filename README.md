[![Build status](https://drone.io/github.com/manish-in-java/jpa-hibernate-jdbc/status.png)](https://drone.io/github.com/manish-in-java/jpa-hibernate-jdbc/latest)

# Background
It is common concern among developers that using an
[Object-Relational Mapping](https://en.wikipedia.org/wiki/Object-relational_mapping)
tool (ORM) will impact the performance of their application severely, especially
if the database contains a significant number of records or if data needs to be
fetched in bulk.  Some developers have created working benchmarks that kind of
indicate that using ORMs can lead to 10 or 100 times degradation in performance
as compared to using raw JDBC.  Needless to say, many developers who are new to
ORM concepts and who come across such benchmarks run away from ORMs in fear and
many of them never dare to return to take a critical look at whether the difference
in performance is due to the ORM or even real.

There is no doubt that application performance (and security) are (or at least should
be) the topmost concerns for any Software Architect.  Therefore, it is only justified
that any technology be looked at critically and adopted only if fits the performance
and security goals of a Software Development Team.  The same applies to ORM tools
because if they indeed pose a severe performance penalty on an application, there is
no point using them in any serious application.

On the other hand, Project Managers and Business Users are more interested in more
and better functionality quickly.  Given the amount of boilerplate code that an ORM
tool can reduce, it is natural for Development Teams looking to rely heavily on database
interactions to gravitate towards ORM tools in order to build new features quickly.
Most database interactions are standard and repetitive and pose no fun at all if copied
and pasted for every single domain object in an application's code.  Therefore, a clear
incentive exists for the Developers to use an ORM tool for database interactions and
focus more on the business rules, logic and workflows in the application.  However, many
teams have a deeply ingrained fear of ORM tools and therefore they cannot make an
objective decision on whether or not they will benefit from using an ORM tool for their
application.

# Overview
This application uses popular tools and technologies to compare the runtime performance
of data access code using different mechanisms.  It uses an extreme case where any
glaring flaws in any one data access technology should be highlighted much more than in
regular use cases.  An in-memory database ([H2](http://www.h2database.com)) with two
tables `Person` and `Contract` is used.  The `Contract` table holds 3 records for every
record in the `Person` table.  The `Person` table has 100,000 records (thereby having
300,000 records in the `Contract` table).  H2 database has been used because it allows
the application to load the entire database in memory and performance measurement
be free from the impact of external factors such as server load, network latency, network
congestion, etc.  Measurements can focus purely on the mechanism used to load data.

[JMH](http://openjdk.java.net/projects/code-tools/jmh/), a popular micro-benchmarking
tool is used for running the benchmarks.  The advantage of using JMH lies in the fact
that it attempts to run the benchmark under conditions close to realistic scenarios by
performing tasks such as JVM warmup, multi-iteration measurements and JVM cooldown.  It
even compiles and presents statistical parameters for the measurements such as minimum,
maximum, mean, standard deviation, etc.

Three data access technologies - [JDBC](https://en.wikipedia.org/wiki/Java_Database_Connectivity),
[Hibernate](https://en.wikipedia.org/wiki/Hibernate_(Java)) and
[JPA](https://en.wikipedia.org/wiki/Java_Persistence_API) are compared.  JDBC is the
standard Java mechanism for connecting to and working with relational databases.
Hibernate and JPA are ORM tools built on top of JDBC.

The benchmarks load all 100,000 person records from the database at the same time and
then count the total number of contracts load along with the person records.

Sample results can be checked by clicking the build status image at the top of this
page which will lead to a page showing details for the latest continuous integration build
for this sample, that includes benchmark measurements at the very bottom.

# Environment
[![JDK 8+](http://b.repl.ca/v1/JDK-8+-blue.png)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Maven 3.3](http://b.repl.ca/v1/Maven-3.3-blue.png)](https://maven.apache.org)
[![JMH 1.9](http://b.repl.ca/v1/JMH-1.9-blue.png)](http://openjdk.java.net/projects/code-tools/jmh/)
[![JPA 2.1](http://b.repl.ca/v1/JPA-2.1-blue.png)](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html)
[![Hibernate 4.3](http://b.repl.ca/v1/Hibernate-4.3-blue.png)](http://www.hibernate.org)
[![JDBC 4](http://b.repl.ca/v1/JDBC-4-blue.png)](http://www.oracle.com/technetwork/java/javase/jdbc/index.html
[![MIT License](http://b.repl.ca/v1/License-MIT-blue.png)](#License)

# License
This sample application and its associated source code in its entirety is being made
available under the following licensing terms.

    The MIT License (MIT)

    Copyright (C) 2015

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
