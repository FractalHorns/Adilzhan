Реализация компонента занятие

```kotlim
interface RSubjectProps : RProps {
    var subject: Array<Subject>
    var listStudent :Array<Student>
 
}

interface RSubjectState : RState {
    var present: Array<Boolean>
}

class RSubject : RComponent<RSubjectProps, RSubjectState>() {
    override fun componentWillMount() {
        state.apply {
            present = Array(props.listStudent.size) { false }
        }
    }
    fun RBuilder.onIndex(): (Int) -> (Event) -> Unit = {
        onClick(it)
    }
    override fun RBuilder.render() {
        props.subject.map {
            + it.name
            ol {
                rstudentlist(props.listStudent, state.present, onIndex())
            }
        }
    }

    fun RBuilder.onClick(index: Int): (Event) -> Unit = {
        setState {
            present[index] = !present[index]
        }
    }
}



fun RBuilder.rsubject(subject:  ArrayList<Subject> ) =
    child(RSubject::class)
    {
        attrs.subject = subject.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }

```



В данной части кода мы подняли состояние компонента RStudentList в созданый компонент RSubject

```kotlin
interface RSubjectProps : RProps {
    var subject: Array<Subject>
    var listStudent :Array<Student>
 
}

interface RSubjectState : RState {
    var present: Array<Boolean>
}

```

В данной части кода мы переделали компонент  RStudentList  в функциональный 

```kotlin

interface RStudentListProps : RProps {
    var students: Array<Student>
    var present: Array<Boolean>
    var onClick:  (Int) -> (Event) -> Unit
}

val RFstudentlist =
    functionalComponent<RStudentListProps> { props ->
        props.students.mapIndexed { index, student ->
            li {
                rstudent(student, props.present[index], props.onClick(index))
            }
        }
    }

fun RBuilder.rstudentlist(students: Array<Student>, present: Array<Boolean>, onClick:(Int) -> (Event) -> Unit) =
    child(RFstudentlist) {
        attrs.students = students
        attrs.present = present
        attrs.onClick = onClick
    }
```





<img src = 1.jpg>

информация об RSubjects в React Components

<img src = 2.jpg>

