package deepskilling.week_1.design_patterns;

public class Exercise10Mvc {
    static class Student {
        private String name;
        private int id;
        private String grade;

        Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
    }

    static class StudentView {
        void displayStudentDetails(String name, int id, String grade) {
            System.out.println("Student: " + id + ", " + name + ", grade=" + grade);
        }
    }

    static class StudentController {
        private final Student model;
        private final StudentView view;

        StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        void setStudentName(String name) {
            model.name = name;
        }

        void setStudentGrade(String grade) {
            model.grade = grade;
        }

        void updateView() {
            view.displayStudentDetails(model.name, model.id, model.grade);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Nila", 101, "A");
        StudentController controller = new StudentController(student, new StudentView());
        controller.updateView();
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
