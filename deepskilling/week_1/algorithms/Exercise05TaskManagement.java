package deepskilling.week_1.algorithms;

public class Exercise05TaskManagement {
    static class Task {
        private final int taskId;
        private final String taskName;
        private final String status;

        Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public String toString() {
            return taskId + " - " + taskName + " [" + status + "]";
        }
    }

    static class TaskList {
        private Node head;

        private static class Node {
            private final Task task;
            private Node next;

            Node(Task task) {
                this.task = task;
            }
        }

        void add(Task task) {
            Node node = new Node(task);
            if (head == null) {
                head = node;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

        Task search(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.taskId == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        boolean delete(int taskId) {
            if (head == null) {
                return false;
            }
            if (head.task.taskId == taskId) {
                head = head.next;
                return true;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.task.taskId == taskId) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        void traverse() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        tasks.add(new Task(1, "Design UI", "Open"));
        tasks.add(new Task(2, "Write tests", "In Progress"));
        System.out.println(tasks.search(2));
        tasks.delete(1);
        tasks.traverse();
        System.out.println("Linked lists grow dynamically. Search/traverse/delete by id are O(n); insert at head can be O(1).");
    }
}
