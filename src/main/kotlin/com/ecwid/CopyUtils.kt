package com.ecwid

import kotlin.reflect.KProperty1
import kotlin.reflect.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

@Suppress("UNCHECKED_CAST")
/**
 * Created by aleksandr on 15.11.16.
 */
class CopyUtils {

    companion object {
        fun copyProperties(obj: Any): Any {
            val properties = getProperties(obj)
            val newInstance = obj.javaClass.newInstance()

            properties.forEach { prop -> setFieldValue(obj, newInstance, prop) }

            return newInstance
        }


        fun theyAreEqual(first: Any, second: Any): Boolean {
            val propertyFirst = getProperties(first)
            val propertySecond = getProperties(second)

            if (propertyFirst.size != propertySecond.size) return false

            for (i in 0..propertyFirst.size - 1) {
                if (propertyFirst[i].name != propertySecond[i].name) return false

                if (getFieldValue(first, propertyFirst[i]) != getFieldValue(second, propertySecond[i])) return false
            }

            return true
        }


        private fun getProperties(obj: Any): List<KProperty1<Any, *>> {
            val propertyList = mutableListOf<KProperty1<Any, *>>()
            val properties = obj.javaClass.kotlin.declaredMemberProperties
            properties.forEach { kProperty1 -> propertyList.add(kProperty1) }
            return propertyList
        }

        private fun getFieldValue(obj: Any, kProperty: KProperty1<Any, *>): Any? {
            kProperty.isAccessible = true
            return kProperty.get(obj)
        }

        private fun setFieldValue(from: Any, to: Any, kProperty: KProperty1<Any, *>) {
            val f = from.javaClass.getDeclaredField(kProperty.name)
            f.isAccessible = true
            kProperty.isAccessible = true
            println(kProperty.name + " :: " + kProperty.get(from))
            f.set(to, kProperty.get(from))
            println(kProperty.name + " :: " + kProperty.get(to))
        }
    }

}

