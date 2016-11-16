package com.ecwid

import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

@Suppress("UNCHECKED_CAST")
/**
 * Created by aleksandr on 15.11.16.
 */
class CopyUtils {

    constructor()

    companion object {
        fun copyProperties(obj: Any): Any {
            val properties = getProperties(obj)
            val newInstance = obj.javaClass.newInstance()

            properties.forEach { prop -> setFieldValue(obj, newInstance, prop) }

            val classesObj = getSubClass(obj)
            val classesNew = getSubClass(newInstance)
            for (i in 0..classesObj.size - 1) {
                CopyUtils.Companion.copySubClass(classesObj[i] as Any, classesNew[i] as Any)
            }

            return newInstance
        }

        private fun copySubClass(obj: Any, newInstance: Any) {
            val properties = getProperties(obj)

            properties.forEach { prop -> setFieldValue(obj, newInstance, prop) }

        }

        fun theyAreEqual(first: Any, second: Any): Boolean {
            val propertyFirst = getProperties(first)
            val propertySecond = getProperties(second)

            val subClassFirst = getSubClass(first)
            val subClassSecond = getSubClass(second)

            if (propertyFirst.size != propertySecond.size) return false

            for (i in 0..propertyFirst.size - 1) {
                if (propertyFirst[i].name != propertySecond[i].name) return false

                if (getFieldValue(first, propertyFirst[i]) != getFieldValue(second, propertySecond[i])) return false
            }

            if (subClassFirst.size != subClassFirst.size) return false

            for (i in 0..subClassFirst.size - 1) {
//                return CopyUtils.Companion.theyAreEqual(subClassFirst[i], subClassSecond[i])
            }

            return true
        }

        private fun getSubClass(obj: Any): List<KClass<*>> {
            val classList = mutableListOf<KClass<*>>()
            val classes = obj.javaClass.kotlin.nestedClasses
            classes.forEach { c -> classList.add(c) }
            return classList
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

