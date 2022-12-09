package days

import Exercise
import java.awt.Point

class Day8 : Exercise {
    override fun a(input: List<String>): String {
        val grid = fillGrid(input)
        return determineVisibleTrees(grid).toString()
    }

    override fun b(input: List<String>): String {
        val grid = fillGrid(input)
        return determineHighestScore(grid).toString()
    }

    private fun determineVisibleTrees(grid: List<List<Int>>): Int {
        val gridAsPineTrees = grid.mapIndexed { rowIndex, treeLine ->
            treeLine.mapIndexed { colIndex, tree ->
                PineTree(
                    tree,
                    Point(rowIndex, colIndex),
                )
            }
        }
        return gridAsPineTrees.map { row ->
            row.map { pineTree -> isVisible(pineTree, gridAsPineTrees) }
        }.flatten().count { it }
    }
    private fun determineHighestScore(grid: List<List<Int>>): Int {
        val gridAsPineTrees = grid.mapIndexed { rowIndex, treeLine ->
            treeLine.mapIndexed { colIndex, tree ->
                PineTree(
                    tree,
                    Point(rowIndex, colIndex),
                )
            }
        }
        return gridAsPineTrees.map { row ->
            row.map { pineTree -> scenicScore(pineTree, gridAsPineTrees) }
        }.flatten().max()
    }
    private fun isVisible(tree: PineTree, grid: List<List<PineTree>>): Boolean {
        when {
            tree.coordinate.x == 0 || tree.coordinate.x == grid.size - 1
                    || tree.coordinate.y == 0 || tree.coordinate.y == grid.size - 1
            -> return true
        }
        val height = tree.height
        val row = grid[tree.coordinate.x]
        val column = tree.coordinate.y

        val left = row.subList(0, column).maxOf { it.height }
        val right = row.subList(column + 1, grid.size).maxOf { it.height }
        val up = grid.map { it[column] }.subList(0, tree.coordinate.x).maxOf { it.height }
        val down = grid.map { it[column] }.subList(tree.coordinate.x + 1, grid.size).maxOf { it.height }
        return height > left || height > right || height > up || height > down
    }

    private fun scenicScore(tree: PineTree, grid: List<List<PineTree>>): Int {
        when {
            tree.coordinate.x == 0 || tree.coordinate.x == grid.size - 1
                    || tree.coordinate.y == 0 || tree.coordinate.y == grid.size - 1
            -> return 0
        }
        val height = tree.height
        val row = grid[tree.coordinate.x]
        val column = tree.coordinate.y

        val treesLeft = row.subList(0, column)
        var left = treesLeft.reversed().takeWhile { it.height < height }.count()
        if (treesLeft.size > left) left++

        val treesRight = row.subList(column + 1, grid.size)
        var right = treesRight.takeWhile { it.height < height }.count()
        if (treesRight.size > right) right++

        val treesUp = grid.map { it[column] }.subList(0, tree.coordinate.x)
        var up = treesUp.reversed().takeWhile { it.height < height }.count()
        if (treesUp.size > up) up++

        val treesDown = grid.map { it[column] }.subList(tree.coordinate.x + 1, grid.size)
        var down = treesDown.takeWhile { it.height < height }.count()
        if (treesDown.size > down) down++


        return left * right * up * down
    }

    private fun fillGrid(input: List<String>): List<List<Int>> {
        return input
            .map { it.toCharArray() }
            .map {
                it.map { char ->
                    char.digitToInt()
                }
            }
    }

    data class PineTree(
        val height: Int,
        var coordinate: Point,
    )
}
