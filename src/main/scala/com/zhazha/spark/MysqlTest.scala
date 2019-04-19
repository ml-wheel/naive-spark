package com.zhazha.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext


/**
  * count(*) 和count(1) 是相同的执行计划,别被部分面试的家伙带偏了
  * == Physical Plan ==
  * (2) HashAggregate(keys=[], functions=[count(1)])
  * +- Exchange SinglePartition
  * +- *(1) HashAggregate(keys=[], functions=[partial_count(1)])
  * +- *(1) Scan JDBCRelation(scrapy.cyginfo) [numPartitions=1] [] PushedFilters: [], ReadSchema: struct<>
  */


object MysqlTest extends App {
  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("WordCount").setMaster("local")
  val sc = new SparkContext(conf)
  val sqlContent = new SQLContext(sc)

  import sqlContent.implicits._

  val df = sqlContent.read.format("jdbc")
    .option("url", "jdbc:mysql://localhost:3306")
    .option("dbtable", "scrapy.cyginfo")
    .option("user", "root")
    .option("password", "123456").load()
  df.registerTempTable("cyginfo")
  //  sqlContent.sql("select count(1) from cyginfo").explain()
  //  sqlContent.sql("select count(*) from cyginfo").explain()
  sqlContent.sql("select menpai,cast(zhuangbei/10000 as int),avg(price) from  cyginfo where zhuangbei >200000 group by menpai,cast(zhuangbei/10000 as int)").explain()
}
