package com.zhazha.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object SqlCloumnToRow extends App {
  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)
  val sqlContent = new SQLContext(sc)

  import sqlContent.implicits._

  val lines = sc.textFile("C:\\Users\\tanyongkai\\Desktop\\spark\\navie-words.txt").map(line => (line.split(",")(0), line.split(",")(1), line.split(",")(2)))
  val df = lines.toDF("class", "subClass", "time")
  df.registerTempTable("tmp")

  //列转行
  val sql: String = "select concat_ws('||',collect_set(A.sm))  from (select class,concat(class,'|',subClass,'|',time) as sm from tmp order by class,time) A group by A.class"
  sqlContent.sql(sql).foreach(println(_))

  //row_number 这里好像只能放最后的位置
  sqlContent.sql("select class,subClass,time ,row_number() over(partition by class order by time ) from tmp").foreach(println(_))

  //case
  sqlContent.sql("select class,sum(case when subClass<'B' then 1 else 0 end),sum(case when subClass>'B' then 1 else 0 end) from tmp group by class").foreach(println(_))

  //df.groupBy("class").agg(("subClass","collect_set")).show()

}
