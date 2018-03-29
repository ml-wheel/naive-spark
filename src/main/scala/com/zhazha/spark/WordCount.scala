package com.zhazha.spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount extends App {
  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)
  val lines = sc.textFile("C:\\Users\\tanyongkai\\Desktop\\spark\\navie-words.txt")
  //  lines.flatMap(line=>line.split(",")).map((_,1)).reduceByKey(_+_).foreach(println(_)) wordCount
  lines.map(line=>(line.split(",")(0),line.split(",")(1),line.split(",")(2)))
    .sortBy(line=>(line._1,line._3))
    .groupBy(line=>line._1)
    .map(line=>line._2)
    .map{line=>
      var tmp:String=""
      line.foreach(e=>
        tmp=tmp+"||"+e._1+"|"+e._2+"|"+e._3
      )
      tmp.substring(2)
    }//行转列
    .sortBy(x=>(x))
    .foreach(println(_))


}
