Основной код программы который выводит список студентов.

fun main() {
    render(document.getElementById("root")!!) {
        h1 {
            +"Список студентов"
        }
        studentList(studentList)
    }
}
В данном коде используется функция studentList.

import data.Student
import react.*
import react.dom.li
import react.dom.ol

interface RStudentProps : RProps {
    var student: Student
}

interface RStudentProps_spicok : RProps {
    var students: Array<Student>
}

class RStudentList :  RComponent<RStudentProps_spicok, RState>() {

    override fun RBuilder.render() {
        ol {
            props.students.map {
                li {
                    rstudent(it)
                }
            }
        }

    }
}

fun RBuilder.rstudent(student: Student) =
    child(
        functionalComponent<RStudentProps> {
            +"${it.student.firstname} ${it.student.surname}"
        }
    ){
        attrs.student = student
    }



fun RBuilder.studentList(students: ArrayList<Student>) =
child(RStudentList::class) {
    attrs.students = students.toTypedArray()
}

На рисунке 1 представлены три функциональных компонента React

<img src = 1.jpg>

