fun main() {
    fun part1(input: List<String>): Int {
        return input
            .splitListByBlank()
            .maxOf { it.sum() }
    }

    fun part2(input: List<String>): Int {
        val sum = input
            .splitListByBlank()
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("Day01_test")
    check(part1(testInput1) == 24000)

    // test if implementation meets criteria from the description, like:
    val testInput2 = readInput("Day01_test")
    check(part2(testInput2) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}


fun List<String>.splitListByBlank(): MutableList<MutableList<Int>> {
    val elves: MutableList<MutableList<Int>> = mutableListOf()
    var food: MutableList<Int> = mutableListOf()
    forEach {
        if (it.isBlank()) {
            elves.add(food)
            food = mutableListOf()
        } else {
            food.add(it.toInt())
        }
    }
    elves.add(food)
    return elves
}
