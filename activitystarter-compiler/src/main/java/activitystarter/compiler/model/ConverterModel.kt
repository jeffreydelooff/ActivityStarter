package activitystarter.compiler.model

import activitystarter.compiler.model.param.ParamType
import activitystarter.compiler.utils.isSubtypeOfType
import java.lang.reflect.Type
import javax.lang.model.type.TypeMirror


data class ConverterModel(
        val className: String,
        val typeFrom: TypeMirror,
        val typeTo: TypeMirror
) {

    val typeFromParamType = ParamType.fromType(typeFrom)

    val toParamType: ParamType?
        get() = ParamType.fromType(typeTo)

    val fromParamType: ParamType?
        get() = ParamType.fromType(typeFrom)

    fun canWrap(type: ParamType): Boolean {
        return type == fromParamType
    }

    fun canUnwrap(type: ParamType): Boolean {
        return type == toParamType
    }
}