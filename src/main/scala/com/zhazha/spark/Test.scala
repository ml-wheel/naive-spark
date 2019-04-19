package com.zhazha.spark

object Test {
  def main(args: Array[String]): Unit = {
    val test = new Test("钩子", 18)
    test.printPer()
    println(test.calc(x => (3 * x, "3倍年龄")))
  }
}

class Test(name: String, age: Int) {
  def printPer() = {
    println(name)
    println(age)
  }

  def calc(f: Int => (Int, String)) = {
    f(age)
  }
}