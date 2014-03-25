package util

fun StringBuilder.plus(item: Any?) : StringBuilder {
    this.append(item.toString())
    return this
}

