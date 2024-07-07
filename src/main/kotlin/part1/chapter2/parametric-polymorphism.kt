package part1.chapter2

// monomorphic function
fun findFirst1(ss: Array<String>, key: String): Int {
    tailrec fun loop(n: Int): Int {
        return when {
            ss.size <= n -> -1
            ss[n] == key -> n
            else -> loop(n+1)
        }
    }

    return loop(0)
}

// polymorphic function
fun <A> findFirst2(xs: Array<A>, p: (A) -> Boolean): Int {
    tailrec fun loop(n: Int): Int {
        return when {
            xs.size <= n -> -1
            p(xs[n]) -> n
            else -> loop(n+1)
        }
    }

    return loop(0)
}

fun main() {
    println(findFirst2(arrayOf(1, 2, 3, 4, 5)) { i: Int -> i == 4 })
}