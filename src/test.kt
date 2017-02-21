fun test() {
    val struct =
            struct {
                +{ "field1" to 1 }
                +{ "field2" to arrayOf(1, 2, 3) }
                +{
                    "field3" to struct {
                        +{ "field1.1" to 11 }
                    }
                }
            }

    val value = struct["field1"] // 1
    println(struct["field1"]) // 1
    println(struct["field2"]) // [1, 2, 3]
    println(struct["field3"]) // inner struct

    val struct2 = struct(
            "field1" to 1,
            "field2" to 2,
            "field3" to struct(
                    "field1.1" to 11
            )
    )

    val struct3 = struct {
        s("field1" to 1)
        s("field2" to arrayOf(1, 2, 3))
        s("field3" to struct {
            s("field3.1" to 31)
        })
    }
}
