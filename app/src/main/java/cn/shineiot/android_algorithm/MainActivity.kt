package cn.shineiot.android_algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val list: MutableList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WeChatRedPacketAlgorithm(100, 10)
        sameString(list1,list2)
    }

    /**
     *  微信群抢红包
     *  @param money 钱
     *  @param num 人数
     *  如果最小红包为1元、最大的红包就是91
     */
    private fun WeChatRedPacketAlgorithm(money: Int, num: Int, mixMoney: Int = 1, maxMoney: Int = money - mixMoney * (num - 1)) {
        for (index in 1..num - list.size) {
            var randomNum: Int

            when (index) {
                1 -> {    //第一个红包
                    randomNum = (1..maxMoney).random() //取1-91之间的随机数
                }
                num -> {  //最后一个红包
                    var separateMoney = 0 //已被抢走的钱数
                    list.map {
                        separateMoney += it
                    }
                    randomNum = money - separateMoney

                }
                else -> {
                    var separateMoney = 0 //已被抢走的钱
                    list.map {
                        separateMoney += it
                    }

                    val money1 = money - separateMoney - (num - list.size - 1) //第n次的最大数
                    randomNum = (1..money1).random()

                }
            }
            list.add(randomNum)
        }
        Log.e("tag", list.toString())
    }

    /**
     * 取出两个数组中相同的字符串
     */
    val list1 = arrayListOf("a", "ab", "ac", "abc", "abcd", "abcdf", "abcdfg")
    val list2 = arrayListOf("a", "ab", "ac", "abc", "abcd", "abcdf_", "abcdfg_")

    fun sameString(list1: MutableList<String>, list2: MutableList<String>) {
        val list3: MutableList<String> = arrayListOf()
        list1.forEach {
            if (list2.contains(it)) {
                list3.add(it)
            }
        }
        Log.e("tag",list3.toString())
    }

}