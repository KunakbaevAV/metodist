package other

val jsonStr = """
    {
        "name": "Barsik",
        "age": 21,
        "isAwesome": true
    }
    """.trimIndent()

data class Cat(val name: String, val age: Int, val isAwesome: Boolean)

