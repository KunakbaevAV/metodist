package prof_parser

class Stack(val size: Int) {
    var chars = CharArray(size)
    var top = -1

    fun push(c: Char) {
        chars[++top] = c
    }

    fun pop(): Char {
        return chars[top--]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isFull(): Boolean {
        return top == size - 1
    }
}