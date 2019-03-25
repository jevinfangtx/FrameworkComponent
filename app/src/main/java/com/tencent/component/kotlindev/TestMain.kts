package com.tencent.component.kotlindev

import java.io.File
import java.lang.Exception
import java.util.*

fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null
    return obj.length
}

fun forTest() {
    val items = listOf("apple", "banana")
    for (item in items) {
        println(item)
    }
}

fun forTest1() {
    for (x in 1..5) {
        println(x)
    }
}

fun forTest2() {
    for (x in 1..10 step 2) {
        println(x)
    }
}

fun testMap() {
    val map = mapOf("a" to 1, "b" to 2)
    for ((k,v) in map) {
        println("$k, $v")
    }
}

fun descript(obj: Any): String =
    when(obj) {
        1 -> "one"
        "hello" ->"Greeting"
        !is String->"Not a string"
        else ->"unknow"
    }

fun testNull() {
    val files = File("test").listFiles()
    println(files?.size)
}

fun testTry() {
    var a:Int = 0
    val result = try {
        a = 1
    } catch (e: Exception){

    }
    println(result)
    println(a)
}


class Turtle {
    fun penDown() {
        println(1)
    }

    fun penUp() {
        println(2)
    }
}

fun testTurle() {
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        penUp()
    }
}

fun testFor() {
    val a: Array<Int> = arrayOf(1, 2, 3)
    for ((index, value) in a.withIndex()) {
        println("$index, $value")
    }
}

class Constructors {
    init {
        println("Init block")
    }
}

open class A {
    open fun f() {
        println("A")
    }
    fun a() {
        println("a")
    }
}

interface B {
    fun f() {
        println("B")
    }

    fun b() {
        println("b")
    }
}

class C(): A(), B {
    override fun f() {
        super<B>.f()
    }
}

class Fang {
    var allByDefault: Int? = 0
    lateinit var data: C
    fun setUp() {
        data = C()
    }
}

interface MyInterface {
    fun bar()
    fun foo(){}
}

class Child: MyInterface {
    override fun bar() {

    }
}

fun Any?.toString(): String {
    var a: String
    if (this == null) {
        a = "null"
    } else {
        a = toString()
    }
    println(a)
    return a
}

val sum = {x: Int, y: Int -> x + y}
val sum2: (Int, Int)->Int = {x, y -> x + y}

fun listTest() {
//    val bb = listOf<String>("bb", "cc")
//    bb.filter { it.startsWith("b") }.forEach { println(it); }
    val name = listOf("a", "b", "c")
    name.filter { x -> x.startsWith("a") }.forEach { y -> println(y) }

}

fun setTest() {
    val a = listOf(1, 2, 2, 3)
    println(a)
    if (1 in a) {
        println("in set")
    }
}

fun main() {
    listTest()
}



main()

