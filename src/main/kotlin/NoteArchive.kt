package main.kotlin
import java.util.Scanner
class NoteArchive(val name: String){
    private val scanner = Scanner(System.`in`)
    private val notes = mutableListOf<Note>()

        fun startMenu() {
            while (true) {
                println("1. Выбор заметки")
                println("2. Создание заметки")
                println("3. Вернуться к выбору архива")

if (scanner.hasNextInt()) {
                when (scanner.nextInt()) {
                    1 -> selectNotes()
                    2 -> createNotes()
                    3 -> return
                    else -> println("Неверный ввод. Пожалуйста, выберите опцию 1, 2 или 3.")
                }
            } else {
    println("Неверный ввод. Пожалуйста, выберите опцию 1, 2 или 3 в цифровом выражении.")
    scanner.next()
}
            }
        }
    private fun selectNotes() {
        println("Выберите заметку:")

        for ((index, note) in notes.withIndex()) {
            println("${index + 1}. ${note.title}")
        }
        if (scanner.hasNextInt()) {
            val noteIndex = scanner.nextInt() - 1
            if (noteIndex in notes.indices) {
                notes[noteIndex].display()
            } else {
                println("Неверный ввод. Пожалуйста, выбирите среди существующих заметок")
            }
        } else {
            println("Неверный ввод. Пожалуйста введите целое число из предлагаемых опций")
            scanner.next()
        }
    }


    private fun createNotes() {
        val scanner = Scanner(System.`in`)
        println("Введите название для новой заметки:")
        val noteTitle = scanner.nextLine().trim()

        if (noteTitle.isNotEmpty()) {
            println("Введите текст новой заметки")
            val noteText = scanner.nextLine().trim()

            if (noteText.isNotEmpty()) {
                val newNote = Note(noteTitle, noteText)
                notes.add(newNote)
                println("Заметка '$noteTitle' создана")
            } else {
                println("Ошибка. Текст заметки не может быть пуст")
            }
        }else {
            println("Ошибка. Название заметки не может быть пустым")
        }
    }
}

class Note(val title: String, val text: String){
    fun display() {
        println("Заголовок: '$title'")
        println("Текст: '$text'")
    }
}