package com.zhazha.spark

import com.zhazha.spark.WordCount.lines
import org.apache.spark.{SparkConf, SparkContext}

object AggregateTest extends App {
  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)
  val lines = sc.textFile("C:\\Users\\Administrator\\Desktop\\spark.txt")
  lines.map(line => (line.split(",")(0), line.split(",")(1), line.split(",")(2)))
    .groupBy(line => line._1).aggregateByKey("")(seqOp, combOp).foreach(println(_))


  def seqOp(key: String, value: Iterable[(String, String, String)]): String = {
    var tmp = ""
    value.foreach { e =>
      tmp += "||" + e._1 + "|" + e._2 + "|" + e._3
    }
    tmp.substring(2)
  }

  def combOp(value1: String, value2: String): String = {
    value1 + "||" + value2
  }

}
