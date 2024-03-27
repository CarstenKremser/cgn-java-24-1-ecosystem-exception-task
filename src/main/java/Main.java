public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();

        Student savedStudent = studentService.addNewStudent(newStudent);

        System.out.println("Student saved: " + savedStudent);

        try {
            System.out.println(studentService.findStudentById(savedStudent.id()));
            System.out.println(studentService.findStudentById("abc"));
        } catch (StudentNotFoundException e) {
            System.out.println("konnte Student nicht finden");
        }

    }
}
