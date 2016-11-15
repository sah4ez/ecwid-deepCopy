package com.ecwid

import kotlin.reflect.jvm.accessible
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.memberProperties

/**
 * Created by aleksandr on 15.11.16.
 */
class CopyUtils<T> {

    constructor()

    fun copyIntProperty(obj:Any):T{
        val properties = obj.javaClass.kotlin.memberProperties
        val newInstance = obj.javaClass.newInstance()

        properties.forEach { prop ->
            run {
                if (!prop.isAccessible){
                    prop.accessible = true
                    val mp = prop.getter
                    mp.property.accessible = true
                    var f = newInstance.javaClass.getDeclaredField(prop.name)

                    f.isAccessible = true

                    println(prop.name + " :: " + prop.get(obj))
                    f.set(newInstance, prop.get(obj))
                    println(prop.name + " :: " + prop.get(newInstance))
                }

            }
        }

        return newInstance as T
    }
}

