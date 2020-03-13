Основной код программы который выводит список студентов.
```Kotlin
var ascending = true

fun main() {
    document.getElementById("karas")!!.append {
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
        }
    }
}

```
Данная часть кода отвечает за вывод списка студентов.
В данном коде используется функция onClickFunction2.

```Kotlin
private fun LI.onClickFunction2(tmp: Student): (Event) -> Unit = {
    console.log("1 - SN = ${tmp.surName}\n ${tmp.presence} \nID = ${this.id}")
    tmp.presence = !tmp.presence
    val listStudents = document.getElementById(this.id)!!
    listStudents.clear()
    listStudents.append {
        span { +"${tmp.firstName} ${tmp.surName} ${if(tmp.presence)"присутствует" else "отсутствует"}"
            attributes += if(!tmp.presence) {
                "style" to "color:grey"
            } else "style" to "color:white"}
    }
    console.log("2 - SN = ${tmp.surName}\n ${tmp.presence} \nID = ${this.id}")
```
Функция отвечает за окрашивание студета при нажатии на него.



На рисунке 1 представлен список студентов до нажатия

<img src = 1.jpg>

На рисунке 2 представлен список студентов после нажатия на какого либо студента 

<img src = 2.jpg>