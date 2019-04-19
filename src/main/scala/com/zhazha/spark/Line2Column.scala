package com.zhazha.spark

import org.apache.spark.{SparkConf, SparkContext}

object Line2Column {
  def main(args: Array[String]): Unit = {


    StreamingExamples.setStreamingLogLevels()
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("C:\\Users\\Administrator\\Desktop\\line2col.txt")
      .map { l =>
        println(l.getClass)
        (l.split("\t")(0), l.split("\t")(1))
      } //.foreach(println(_))
      .map { line =>
      var newLine = ""
      line._2.toString.split(",").foreach(str => newLine += line._1 + ":" + str + ",")
      newLine.substring(0, newLine.length - 1)
    }.flatMap(line => line.split(",")).foreach(println(_))
  }
}
