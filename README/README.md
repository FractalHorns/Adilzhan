Данная часть кода отвечает за вывод списка студентов и создания кнопок для окрашивания текста.

```kotlin

fun main() {
    document.getElementById("root")!!.append {
        h1 {
            +"Students"
            firstSort()
            onClickFunction = onCLickFunction()
        }
        ol {
            attributes += "id" to "listStudents"
            var i = 0;
            studentList.map {
                li {
                    attributes += "id" to "l${++i}"
                    +"${it.firstName} ${it.surName} ${if(it.presence)"присутствует" else "отсутствует"}"
                    val tmp = it
                    onClickFunction = onClickFunction2(tmp)
                }
            }

            p {

                +"Blue"
                input (option = arrayListOf("blue"))
                br
                +"Red"
                input (option = arrayListOf("red"))
                br
                +"Yellow"
                input (option = arrayListOf("yellow"))
                br
                +"White"
                input (option = arrayListOf("white"))
            }
        }
    }
}

```

Для уменьшения размера кода мы переопределили функцию input.

```kotlin

fun FlowOrInteractiveOrPhrasingContent.input(
    option: List<String>,
    block : INPUT.() -> Unit = {}
) : Unit = input (
    type = InputType.radio,
    name = "color") {
    option.forEach {
        value = it
        onClickFunction = colorchange(value)
    }
    block()

}


private fun colorchange(value: String): (Event) -> Unit {
    return {
        val div = document.getElementById("root")!!
        div.setAttribute("style", "color:${value}")
    }
}

```

На рисунке 1 представлен текст до нажатия на кнопку

<img src = 1.jpg>


