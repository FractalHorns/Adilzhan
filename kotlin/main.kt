import data.Student
import data.studentList
import input
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlinx.html.js.li
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear

var ascending = true

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

fun firstSort(ascending:Boolean = true){
    if (!ascending)
        studentList.sortBy { it.firstName }
    else
        studentList.sortByDescending { it.firstName }
}

private fun H1.onCLickFunction(): (Event) -> Unit = {
    val listStudents = document.getElementById("listStudents")!!
    listStudents.clear()
    listStudents.append {
        firstSort(!ascending)
        ascending = !ascending
        var i = 0;
        studentList.map {
            li {
                attributes += "id" to "l${++i}"
                +"${it.firstName} ${it.surName}, ${if(it.presence)"присутствует" else "отсутствует"}"
                val tmp = it
                onClickFunction = onClickFunction2(tmp)
                attributes += if(!it.presence) "style" to "color:grey"
                else "style" to "color:white"
            }
        }
    }
}

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
}
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
