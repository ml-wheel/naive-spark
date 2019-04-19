package com.zhazha.spark


import org.apache.spark.{SparkConf, SparkContext}


object TestDebug extends App {
  print(System.currentTimeMillis())
  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)
  val lines = sc.textFile("C:\\Users\\Administrator\\Desktop\\*.txt")
  //  val rdd = sc.textFile("")
  //  val b = sc.broadcast(rdd)
  //  val meta = b.value.map((_,1))

  val words = lines.flatMap(_.split(" "))
    .map((_, 1))
    .reduceByKey(_ + _)
    .foreach(println(_))
  print(System.currentTimeMillis())
  //  .groupByKey()
  //  val w = words.cache()
  //  w.repartition(1).sortBy(_._1)
  ////  w.union(meta).cogroup()

  //  val sqlContent = new SQLContext(sc)
  //  import sqlContent.implicits._
  //
  //  sqlContent.sql("show tables").show()

}