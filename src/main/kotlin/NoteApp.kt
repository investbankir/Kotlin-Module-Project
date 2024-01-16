package main.kotlin
import java.util.Scanner
class NoteApp {
    private val archives = mutableListOf<NoteArchive>()
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true){
            println("1. Выбор архива")
            println("2. Создание архива")
            println("3. Выход")

            if (scanner.hasNextInt()){
            when(scanner.nextInt()) {
                1 -> selectArchive()
                2 -> createArchive()
                3 -> return
                else -> println("Неверный ввод. Пожалуйста, выбирите опцию 1, 2 или 3")
            }
        } else {
                println("Неверный ввод. Пожалуйста, выбирите опцию 1, 2 или 3 в цифровом выражении")
                scanner.next()
            }
        }
    }

    private fun selectArchive() {
        println("Выберите архив:")

        for ((index, archive) in archives.withIndex()) {
            println("${index + 1}. ${archive.name}")
        }
        if (scanner.hasNextInt()) {
            val archiveIndex = scanner.nextInt() - 1

            if (archiveIndex in 0 until archives.size) {
                archives[archiveIndex].startMenu()
            } else {
                println("Неверный ввод. Пожалуйста, выбирите архив из существующих")
            }
        } else {
            println("Неверный ввод. Пожалуйста введите целое число из предлагаемых опций")
            scanner.next()
        }
    }

    private fun createArchive(){
        val scanner = Scanner(System.`in`)
        println("Введите имя нового архива:")

        val archiveName = scanner.nextLine().trim()

        if (archiveName.isNotEmpty()) {
            val newArchive = NoteArchive(archiveName)
            archives.add(newArchive)
            println("Архив '$archiveName' создан.")
        } else {
            println("Ошибка. Имя архива не может быть пустым")
        }
    }
}