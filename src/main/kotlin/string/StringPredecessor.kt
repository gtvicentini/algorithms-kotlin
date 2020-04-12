package string

fun String.predecessor(): String {
    if (length == 0 || this == MIN_STRING) {
        throw IllegalArgumentException("No string.predecessor could be computed for $this")
    }

    val sb = StringBuilder(this)
    var carry = 0
    for(i in sb.indices.reversed()) {
        if (sb[i] == Char.MIN_VALUE) {
            carry = 1
            sb.setCharAt(i, Char.MAX_VALUE)
        } else {
            carry = 0
            sb.setCharAt(i, sb[i] - 1)
        }
        if (carry == 0) {
            break
        }
    }
    if (carry == 1) {
        sb.deleteCharAt(0)
    }
    return sb.toString()
}