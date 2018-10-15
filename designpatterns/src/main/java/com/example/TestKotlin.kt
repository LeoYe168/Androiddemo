package com.example

/**
 * Created by yeyao on 2018/10/11 下午4:40
 */
class TestKotlin {
    fun main(args: Array<String>) {
        val list = listOf(2, 4, 0)
        // 不标明参数名
        println(joinToString(list, " - ", "[", "]"))
        // 显式的标明参数名称
        println(joinToString(list, separator = " - ", prefix = "[", postfix = "]"))
    }

    // 打印列表的内容
    fun <T> joinToString(collection: Collection<T>,
                         separator: String,
                         prefix: String,
                         postfix: String): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    /**************************************

    Tips7 用局部函数抽取重复代码。

     *************************************/
    class User(val id: Int, val name: String)

    fun saveUser(user: User) {
        //利用内嵌函数抽取逻辑
        fun validate(value: String, fildName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${user.id}: empty $fildName")
            }
        }
        validate("", "")
    }

    //   利用扩展函数来抽取逻辑
    fun User.validateAll(user: User) {
        fun validate(value: String, fildName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${user.id}: empty $fildName")
            }
        }
        validate("", "")
    }

    fun saveUser2(user: User) {
        user.validateAll(user)
    }

    /**************************************

    Tips 8 使用数据类来快速实现model类

     *************************************/
    class User8(val name: String, val id: Int)   //kotlin 会自动实现get set 方法

    data class User9(val name: String, val id: Int)    //用data关键词来声明一个数据类，除了会自动实现get set，还会自动生成equals hashcode toString

    data class User10(val name: String)

}
