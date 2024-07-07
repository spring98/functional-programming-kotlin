package part1.chapter2

fun factorial(i: Int): Int {
    // 함수형 프로그래밍에서는 지역 함수를 정의하는 것을 이상하게 생각하면 안된다.
    // 주로 go(), loop() 혹은 f(), g(), h() 와 같은 짧은 이름을 사용하는 것이 표준 관습이다.

    // tailrec: 재귀적인 함수 호출을 하는 호출자가 재귀 함수 호출이 반환값을 즉시 호출하기만 하고
    // 다른 아무 일도 하지 않을 때 이 재귀 호출이 꼬리 위치에 있다고 말한다.
    // 어떤 함수의 모든 재귀 호출이 꼬리 위치에 있고 함수 앞에 tailrec 변경자가 붙어 있으면 코틀린 컴파일러는
    // 재귀 이터레이션 호출 스택을 소비하지 않는 반복적인 루프로 컴파일 한다.
    tailrec fun go(n: Int, acc: Int): Int {
        return if (n <= 0) acc

        // 호출 결과를 직접 반환하고 호출 결과에 대해 다른 어떻 일도 하지 않으므로 꼬리 위치에 있다.
        else go(n-1, n * acc)
    }

    return go(i, 1)
}

fun formatResult(name: String, n: Int, f: (Int) -> Int): String {
    val msg = "The %s of  %d is %d."

    return msg.format(name, n, f(n))
}

fun main() {
    println(factorial(7))

    // 함수를 참조로 넘기는 방법
    // 1. 기존 함수 선언에 대한 호출 가능 참조를 전달하는 방법
    println(formatResult("factorial", 7, ::factorial))

    // 2. 함수 리터럴(익명함수/람다)을 익명으로 인스턴스화 해서 인자로 전달하는 방법
    println(formatResult("abs", -7) { if (it < 0) -it else it })
}