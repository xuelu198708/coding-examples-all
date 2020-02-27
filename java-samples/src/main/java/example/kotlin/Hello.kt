package example.kotlin

/**
 * Created by xuelu
 * 2019-08-07.
 */

var age:Int = 18
val address = "浙江省"
var name:String = "xxx"


fun main(args: Array<String>) {
    println("Hello Kotlin!")
    //非空变量，不能设置为null
    var name:String = "xue"
    var phone = null
    println(phone) 
    println(hello(name))
    println("age is $age")
}

fun hello(name: String): String {
    return "Hello $name"

}