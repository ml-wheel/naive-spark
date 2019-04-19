package com.zhazha.spark.sparkstreaming

import com.zhazha.spark.StreamingExamples
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.ArrayBuffer

object KafkaPartitions extends App {


  def mapFun(line: ConsumerRecord[String, String]): Int = {
    val value: String = line.value()
    var re = 0
    if (value.equals("")) {
    } else {
      val num = Integer.parseInt(value)
      if (num % 5 == 0) {
        re = num / 0
      }
      else {
        re = num
      }
    }
    re
  }

  def mapPartitionFun(iterator: Iterator[String]): Iterator[String] = {
    var result = new ArrayBuffer[String]()
    iterator.foreach(it => result.append(it))
    result.iterator
  }

  StreamingExamples.setStreamingLogLevels()
  val conf = new SparkConf().setAppName("test").setMaster("local[2]")
  val ssc = new StreamingContext(conf, Seconds(5))


  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "group.id" -> "kafka-test-group",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer]
  )

  val topics = Array("test")

  val stream = KafkaUtils.createDirectStream[String, String](
    ssc,
    PreferConsistent,
    Subscribe[String, String](topics, kafkaParams)
  )

  stream.foreachRDD { rdd =>
    //    rdd.map(mapFun(_)).foreach(println(_))
    rdd.map((_.value())).mapPartitions(mapPartitionFun).foreach(println(_))
  }

  ssc.start()
  ssc.awaitTermination()

}
