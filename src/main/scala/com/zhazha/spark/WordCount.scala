package com.zhazha.spark

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.Iterable
import scala.reflect.ClassTag

object WordCount extends App {
  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)
  val lines = sc.textFile("C:\\Users\\tanyongkai\\Desktop\\spark\\navie-words.txt") // /user/hdfs/words.txt
  //  lines.flatMap(line=>line.split(",")).map((_,1)).reduceByKey(_+_).foreach(println(_)) wordCount
  lines.map(line => (line.split(",")(0), line.split(",")(1), line.split(",")(2)))
    .sortBy(line => (line._1, line._3))
    .groupBy(line => line._1) //CompactBuffer[(String,String,String)]
    .map(line => line._2)
    .map(mapFunc)
    .sortBy(x => (x))
    .take(2)
    .foreach(println(_))



  //  line =>
  //    println(line.getClass)
  //  line.foreach(l=>println(l.getClass))
  //  var tmp: String = ""
  //  line.foreach(e =>
  //    tmp = tmp + "||" + e._1 + "|" + e._2 + "|" + e._3
  //  )
  //  tmp.substring(2)

  def mapFunc(line: Iterable[(String, String, String)]): String = {
    var tmp = ""
    line.foreach(e => tmp += "||" + e._1 + "|" + e._2 + "|" + e._3)
    tmp.substring(2)
  }



  test("99")
  def test(num:String): Unit ={
    println(xx(num=>Integer.parseInt(num),num))

  }
  def xx(f:String=>Int,num:String="10"):Int={
    f(num)
  }
}
