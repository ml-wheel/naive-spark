package com.zhazha.spark.sparkstreaming

import com.zhazha.spark.StreamingExamples
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreamingToMysql {
  def main(args: Array[String]): Unit = {
    StreamingExamples.setStreamingLogLevels()
    val conf = new SparkConf().setAppName("test").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))


    val df = ssc.socketTextStream("localhost", 8888)

    df.foreachRDD { rdd =>
      rdd.foreachPartition { partition =>
        val conn = MDBManager.getMDBManager(true).getConnection
        conn.setAutoCommit(false)
        val sql = "insert into test(name) values(?)"
        val stmt = conn.prepareStatement(sql)
        partition.foreach { item =>
          stmt.setObject(1, "二狗子")
          stmt.addBatch()
        }
        stmt.executeBatch()
        conn.commit()
        conn.close()
      }
    }
    
    ssc.start()
    ssc.awaitTermination()
  }
}
