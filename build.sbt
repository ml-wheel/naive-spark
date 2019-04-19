name := "naive-spark"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.3.0"

libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.3.0"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.1.1" excludeAll ExclusionRule(organization = "com.fasterxml.jackson.core")

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.6"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"

libraryDependencies += "com.mchange" % "c3p0" % "0.9.5.4"

